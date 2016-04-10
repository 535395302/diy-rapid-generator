import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tian
 * @version 1.0
 * @date 2016-03-26 17:57
 */
public class ByMapUtils {

    private static final String REG_TABLE_NAME = "^create table [A-z]*";
    private static final String REG_COLUMNS = "\\s\\(\\s(.|\\n)*\\);";

    public static void main(String[] args) {
        final String sql = readSql("F:\\Tian\\Code\\Git\\diy-rapid-generator\\src\\src.sql");
        final Map<String, Object> map = analysisSql(sql);
        System.err.println(map);
    }

    public static Map<String,Object> analysisSqlFile(String path){
        final String s = readSql(path);
        return analysisSql(s);
    }

    static final Map<String, Object> map = Maps.newHashMap();
    static final List<Map<String,String>> columns = Lists.newArrayList();
    static final List<String> constraint = Lists.newArrayList();

    private static final String CREATE_TABLE = "create table";
    public static Map<String,Object> analysisSql(String sql){
        final List<String> list = Splitter.on(";").trimResults().omitEmptyStrings().splitToList(sql);
        for (String line : list) {
            if(isMainSql(line)){
                analysisMainSql(line);
            }else if(isComment(line)){
                analysisCommentLine(map, columns, line);
            }
        }
        map.put("fields",columns);
        return map;
    }

    /** 解析注释定义 */
    static void analysisCommentLine(Map<String, Object> map, List<Map<String, String>> columns, String line) {
        if(StringUtils.startsWithIgnoreCase(line, "comment on table")){
            final String commentWithQuote = line.split("is")[1].trim();
            map.put("comment", commentWithQuote.substring(1,commentWithQuote.length()-1));
        }else{
            final String columnName = getColumnNameFromCommentLine(line);
            String comment = getCommentFromCommentLine(line);
            for (Map<String, String> column : columns) {
                if(StringUtils.equals(column.get("defName"), columnName)){
                    column.put("remark", comment);
                    column.put("comment", comment);
                }
            }
        }
    }

    /** 解析主要sql定义 */
    static void analysisMainSql(String line) {
        String tableName = getTableName(line);
        map.put("tableName", tableName);
        final String className = getClassNameFromTableName(tableName);
        map.put("className", className);
        map.put("classNameVo", className+"Vo");
        map.put("classNameLower", lowerFirst(className));
        // 按逗号[,]或[(]开括号切割字符
        final List<String> strs = Splitter.on(Pattern.compile("(\\s\\(\\n\\s\\s\\s)|,\\n|\\n\\);")).trimResults().omitEmptyStrings().splitToList(line);
        for (String s : strs) {
            if(isMainSql(s)){
                // create table TWms_S_IOType
                //continue;
            }else if(StringUtils.startsWithIgnoreCase(s, "constraint")){
                // constraint PK_TWMS_S_IOTYPE primary key (TypeId)
                //continue;
                if(!s.contains("primary key")){
                    constraint.add(s);
                }
            }else{
                // TypeId               VARCHAR(10)          not null
                final List<String> toList = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(s);
                Map<String,String> clmn = Maps.newHashMap();
                clmn.put("defName", toList.get(0));
                clmn.put("fieldName", lowerFirst(toList.get(0)));
                String jdbcTypeDef = toList.get(1),javaType,jdbcType,length;
                if(jdbcTypeDef.contains("(")){
                    jdbcType = jdbcTypeDef.split("\\(")[0];
                    length = CharMatcher.JAVA_DIGIT.retainFrom(jdbcTypeDef);
                    clmn.put("maxLength",length);
                }else{
                    jdbcType = jdbcTypeDef;
                }
                javaType = getJavaTypeFromJdbcType(jdbcType);
                clmn.put("jdbcType",jdbcType);
                clmn.put("javaType",javaType);
                clmn.put("notNull",s.contains("not null")+"");
                columns.add(clmn);
            }
        }
        map.put("constraint", constraint);
        map.put("fields", columns);
    }

    /** 解析DB表名 */
    static String getTableName(String line){
        final Matcher tableNameMth = Pattern.compile(REG_TABLE_NAME).matcher(line);
        if(tableNameMth.find()) {
            // create table TWms_S_IOType
            final String group = tableNameMth.group();
            List<String> slt = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(group);
            final String tableName = slt.get(slt.size() - 1);
            return tableName;
        }
        throw new RuntimeException("解析DB表名失败");
    }

    static boolean isComment(String line) {
        return StringUtils.startsWithIgnoreCase(line, "comment on");
    }

    static boolean isMainSql(String line) {
        return StringUtils.startsWithIgnoreCase(line, CREATE_TABLE);
    }

    private static String getColumnNameFromCommentLine(String s){
        final Matcher matcher = Pattern.compile("\\.\\w*").matcher(s);
        if(matcher.find()){
            return StringUtils.substring(matcher.group(), 1);
        }else{
            throw new RuntimeException("匹配错误column name:"+s);
        }
    }

    private static String getCommentFromCommentLine(String s){
        final Matcher matcher = Pattern.compile("'.*'").matcher(s);
        if(matcher.find()){
            final String str = matcher.group();
            return StringUtils.substring(str,1,str.length()-1) ;
        }else{
            throw new RuntimeException("匹配错误comment:"+s);
        }
    }

    private static String lowerFirst(String s){
        return s.toLowerCase().substring(0,1).concat(s.substring(1));
    }

    private static String getClassNameFromTableName(String tableName) {
        // TWms_S_IOType
        final List<String> list = Splitter.on("_").trimResults().omitEmptyStrings().splitToList(tableName);
        // IOType
        final String s = list.get(list.size() - 1);
        return s;
    }

    public static String readSql(String path){
        try {
            final File file = new File(path);
            if(file.exists()){
                final List<String> list = Files.readLines(file, Charsets.UTF_8);
                final StringBuffer sb = new StringBuffer();
                for (String s : list) {
                    //skip sql comment
                    if(StringUtils.isBlank(s)||StringUtils.startsWith(s,"--")||StringUtils.startsWith(s,"/*")){
                        continue;
                    }
                    sb.append(s).append("\n");
                }
                return sb.toString();
            }else{
                throw new RuntimeException("FileNotFoundException");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJavaTypeFromJdbcType(String sqlType) {
        String javaType = _types.get(sqlType);
        if(StringUtils.isBlank(javaType)){
            throw new RuntimeException("找不到对应的javaType:"+sqlType);
        }
        return javaType;
    }

    final static Map<String, String> _types = ImmutableMap.<String, String>builder()
        .put( "FLOAT8"		,"java.math.BigDecimal"	)
        .put( "INT4"		,"java.lang.Integer"	)
        .put( "TINYINT"      , "java.lang.Byte"		)
        .put( "SMALLINT"	,"java.lang.Short"		)
        .put( "INTEGER"		,"java.lang.Integer"	)
        .put( "BIGINT"		,"java.lang.Long"		)
        .put( "REAL"		,"java.lang.Float"		)
        .put( "DOUBLE"		,"java.lang.Double"		)
        .put( "NUMERIC"		,"java.math.BigDecimal"	)
        .put( "BOOLEAN"		,"java.lang.Boolean"	)
        .put( "VARCHAR"		,"java.lang.String"		)
        //.put( "TIMESTAMP"	,"java.util.Date"		)
        .put( "DATE"		,"java.util.Date"		)
        .put( "TIME"		,"java.sql.Time"		)
        .put( "TIMESTAMP"	,"java.sql.Timestamp"	)
        .put( "CLOB"		,"java.sql.Clob"		)
        .put( "BLOB"		,"java.sql.Blob"		)
        .put( "ARRAY"		,"java.sql.Array"		)
        .put( "REF"			,"java.sql.Ref"			)
        .build();

}
