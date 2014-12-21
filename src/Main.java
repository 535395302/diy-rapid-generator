import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.util.FileHelper;
import com.model.CitizenInfo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * Created by tian on 14/12/20.
 */
public class Main {
    /**
     * 代码生成器模板可以引用的相关变量
     * 1. g.generateByTable("table_name") 方法可以引用的变量
     * table : cn.org.rapid_framework.generator.provider.db.model.Table
     *
     * 2. g.generateByClass("class") 方法可以引用的变量
     * clazz : cn.org.rapid_framework.generator.provider.java.model.JavaClass
     *
     * 3.公共变量
     * env : 系统环境变量
     * System.getProperties() :  直接引用,没有前缀
     * generator.properties 文件中的所有属性,直接引用,没有前缀
     * gg : 模板控制变量, cn.org.rapid_framework.generator.GeneratorControl
     */
    public static void main(String... args) throws Exception {
        /**
         * TODO 注意：
         * 1）clazz类的package需要含有".",不然会报一个字符串数组越界异常。因为有句代码是要以最后一个点号为offset切割类的包名。
         * 2）第一个属性成员变量被当做PK使用，在Service，Dao中被用于ByPK为后缀方法的参数
         * 3）serialVersionUID应当被注释，不然在ibatis的mapper文件中会被用于sql语句。
         * 4）...
         */
        Class clazz = CitizenInfo.class;

        GeneratorFacade g = new GeneratorFacade();
        g.deleteOutRootDir();							//删除生成器的输出目录

        /* 通过类生成文件
         * 参数1：类
         * 参数2：模板的根目录
         */
        g.generateByClass(CitizenInfo.class,"template_byClass");

        //g.printAllTableNames();				//打印数据库中的表名称

        /**
         * 参数1：数据表名
         * 参数2：模板的根目录
         * use test;
         * drop table if exists `user_info`;
         * CREATE TABLE `user_info` (
         *   `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
         *   `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
         *   `password` varchar(50) DEFAULT NULL COMMENT '密码',
         *   `birth_date` date DEFAULT NULL,
         *   `sex` int(11) DEFAULT NULL,
         *   `age` int(11) DEFAULT NULL,
         *   PRIMARY KEY (`user_id`)
         * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
         */
        g.generateByTable("user_info","template_byTable");	//通过数据库表生成文件

        //其他方式
        //g.generateByAllTable("template");	//自动搜索数据库中的所有表并生成文件,template为模板的根目录
        //g.deleteByTable("table_name", "template"); //删除生成的文件

        // 打开文件夹
        // String outRoot = GeneratorProperties.getProperty("outRoot");
        // Mac OS: 打开文件夹
        //Runtime.getRuntime().exec("open " + new File(outRoot).getAbsolutePath());
        // Window OS:打开文件夹
        //Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
    }
}
