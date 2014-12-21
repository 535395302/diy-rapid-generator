
* 使用前需要配置：
    -------------------
    |generator.xml
    |    1) basepackage   -->    必须，所有生成java文件的基础包名。引用方式：${basepackage}
    |    2) namespace     -->    可选，若不填，就不要引用。引用方式：${namespace}
    |
    |    3) outRoot       -->    必须，输出目录，因为MacOS和WindowOS目录表示方式不同，自己多试试。
    |                            Mac OS ： <entry key="outRoot">generator-class-output</entry>
    |                            结果：在项目根目录下生成generator-class-output文件夹，包含生成的文件
    |                            Window OS：原项目是<entry key="outRoot">.\generator-output</entry>。
    |                            结果：我没试过....
    |
    |    4) 数据库配置
    |        jdbc.username   ...
    |        jdbc.password   ...
    |        jdbc.url        ...
    |        jdbc.driver     ...

    -------------------
    |Main.main():
    |    根据你的调用方式，填入参数，选择调用的方法
    |
    |    1）g.generateByClass(Class<?> clazz,String templateDirByClass);
    |
    |    2）g.generateByTable(String tableName,String templateDirByTable);


* 其他资料：
    -------------------
    | 1）Freemarker操作字符串：http://www.blogjava.net/alinglau36/archive/2011/02/23/344970.html
    | 2）Freemarker详解：http://www.blogjava.net/176142998/archive/2010/07/03/325159.html