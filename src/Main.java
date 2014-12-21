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
        Class clazz = CitizenInfo.class;

//        Field[] fields = clazz.getDeclaredFields();
//        System.err.println("Class::: "+clazz.getName());
//        for (Field field : fields) {
//            System.err.println("Field:::  "+field.getType()+"  "+field.getName());
//
//            Annotation[] ans = field.getDeclaredAnnotations();
//
//            for (Annotation an : ans) {
//                System.err.println("    Annotation:::  "+an.getClass());
//            }
//        }
        GeneratorFacade g = new GeneratorFacade();
        g.deleteOutRootDir();							//删除生成器的输出目录
        g.generateByClass(CitizenInfo.class,"template_byClass");
        //g.printAllTableNames();				//打印数据库中的表名称
        //g.generateByTable("user_info","template_byTable");	//通过数据库表生成文件,template为模板的根目录
        //g.generateByAllTable("template");	//自动搜索数据库中的所有表并生成文件,template为模板的根目录

        //g.deleteByTable("table_name", "template"); //删除生成的文件

       // String outRoot = GeneratorProperties.getProperty("outRoot");

        // Mac OS: 打开文件夹
        //Runtime.getRuntime().exec("open " + new File(outRoot).getAbsolutePath());
        // Window OS:打开文件夹
        //Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
    }
}
