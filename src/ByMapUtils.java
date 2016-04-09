import cn.org.rapid_framework.generator.GeneratorFacade;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tian
 * @version 1.0
 * @date 2016-03-26 17:57
 */
public class ByMapUtils {
    public static void createBPMN(GeneratorFacade g) throws Exception {
        Map map = new HashMap();

//        map.put("id","TV");map.put("name","电视");
//        map.put("id","CW");map.put("name","厨卫");
//        map.put("id","BX");map.put("name","冰洗");
//        map.put("id","KT");map.put("name","空调");
//        map.put("id","XD");map.put("name","小电");
        map.put("id","3C");
        map.put("name","3C");
        g.generateByMap(map, "template_byMap");
    }

    public static String getFieldTypeFromSql(String sqlType) {
        for (String javaType : _types.keySet()) {
            if(_types.get(javaType).equals(sqlType)){
                return javaType;
            }
        }
        throw new RuntimeException("找不到对应的javaType:"+sqlType);
    }

    final static Map<String, String> _types = new HashMap<String, String>();
    static {
        _types.put( "java.lang.Byte"		,"TINYINT"		);
        _types.put( "java.lang.Short"		,"SMALLINT"		);
        _types.put( "java.lang.Integer"		,"INTEGER"		);
        _types.put( "java.lang.Long"		,"BIGINT"		);
        _types.put( "java.lang.Float"		,"REAL"			);
        _types.put( "java.lang.Double"		,"DOUBLE"		);
        _types.put( "java.math.BigDecimal"	,"NUMERIC"		);
        _types.put( "java.lang.Boolean"		,"BOOLEAN"		);
        _types.put( "java.lang.String"		,"VARCHAR"		);
        _types.put( "java.util.Date"		,"TIMESTAMP"	);
        _types.put( "java.sql.Date"			,"DATE"			);
        _types.put( "java.sql.Time"			,"TIME"			);
        _types.put( "java.sql.Timestamp"	,"TIMESTAMP"	);
        _types.put( "java.sql.Clob"			,"CLOB"			);
        _types.put( "java.sql.Blob"			,"BLOB"			);
        _types.put( "java.sql.Array"		,"ARRAY"		);
        _types.put( "java.sql.Ref"			,"REF"			);
    }
}
