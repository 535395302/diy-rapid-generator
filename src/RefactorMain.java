import cn.org.rapid_framework.generator.GeneratorFacade;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by tian on 14/12/20.
 */
public class RefactorMain {
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
        Map<String,String> map = ImmutableMap.<String,String>builder()
                .put("basePkg","com.ewandian.b2b2c.gl.arap.service.business.impl")
                .put("business","paid")
                .put("task","edit")
                .put("desc","采购付款")
                .put("paramType","ApMaster")
                .put("entityType","ApMaster")
                .build();
        g.generateByMap(map,"refactor_byMap");
    }
}
