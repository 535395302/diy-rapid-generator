import cn.org.rapid_framework.generator.GeneratorFacade;

import java.util.Map;

/**
 * Created by tian on 14/12/20.
 */
public class Main {
    /**
     * 代码生成器模板可以引用的相关变量
     * 1. g.generateByTable("table_name") 方法可以引用的变量
     * table : cn.org.rapid_framework.generator.provider.db.model.Table
     * column: cn.org.rapid_framework.generator.provider.db.table.model.*
     *
     * 2. g.generateByClass("class") 方法可以引用的变量
     * clazz : cn.org.rapid_framework.generator.provider.java.model.JavaClass
     * field : cn.org.rapid_framework.generator.provider.java.model.*
     *
     * 3.公共变量
     * env : 系统环境变量
     * System.getProperties() :  直接引用,没有前缀
     * generator.properties 文件中的所有属性,直接引用,没有前缀
     * gg : 模板控制变量, cn.org.rapid_framework.generator.GeneratorControl
     */
    public static void main(String[] args) throws Exception {
        /**
         * TODO 注意：
         * 1）clazz类的package需要含有".",不然会报一个字符串数组越界异常。因为有句代码是要以最后一个点号为offset切割类的包名。
         * 2）第一个属性成员变量被当做PK使用，在Service，Dao中被用于ByPK为后缀方法的参数
         * 3）serialVersionUID应当被注释，不然在ibatis的mapper文件中会被用于sql语句。
         * 4）...
         */
        GeneratorFacade g = new GeneratorFacade();
        g.deleteOutRootDir();							//删除生成器的输出目录

        byMap(g);

    }

    private static void byMap(GeneratorFacade g) throws Exception {
        System.err.println(System.getProperty("user.dir"));
        Map map = ByMapUtils.analysisSqlFile(System.getProperty("user.dir")+"\\src\\src.sql");
        g.generateByMap(map,"template_byMap");
    }
}
