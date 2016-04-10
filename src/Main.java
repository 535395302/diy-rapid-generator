import cn.org.rapid_framework.generator.GeneratorFacade;

import java.util.Map;

/**
 * Created by tian on 14/12/20.
 */
public class Main {
    /**
     * 代码生成器主方法
     */
    public static void main(String[] args) throws Exception {
        /**
         * TODO 注意：
         * --> 第一个属性成员变量被当做PK使用，在Service，Dao中被用于ByPK为后缀方法的参数
         */
        GeneratorFacade g = new GeneratorFacade();
        g.deleteOutRootDir();							//删除生成器的输出目录

        byMap(g);
    }

    private static void byMap(GeneratorFacade g) throws Exception {
        /** For Example:
         * Map = {
         *     tableName    :"TWms_S_IOType",
         *     comment      :"参与库内调整的实物序列号",
         *     className    :"IOType",
         *     classNameVo  :"IOTypeVo",
         *     classNameLower:"iOType",
         *     fields:[
         *          {
         *              defName     :"ApplyId",
         *              fieldName   :"applyId",
         *              maxLength   :"64", // 仅字符类型有
         *              jdbcType    :"VARCHAR",
         *              javaType    :"java.lang.String",
         *              notNull     :"true",
         *              remark      :"申请编号",
         *              comment     :"申请编号",
         *          },...
         *     ],
         *     constraint:[
         *          "constraint PK_TWMS_S_IOTYPE primary key (TypeId)",...
         *     ]
         * }
         */
        Map map = ByMapUtils.analysisSqlFile(System.getProperty("user.dir")+"\\src\\src.sql");
        g.generateByMap(map,"template_byMap");
    }
}
