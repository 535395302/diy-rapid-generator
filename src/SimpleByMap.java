import cn.org.rapid_framework.generator.GeneratorFacade;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * Created by tian on 14/12/20.
 */
public class SimpleByMap {

    public static void main(String[] args) throws Exception {

        GeneratorFacade g = new GeneratorFacade();
        g.deleteOutRootDir();							//删除生成器的输出目录

        List<Map<String,String>> list = Lists.<Map<String,String>>newArrayList(
                ImmutableMap.of("id", "TV", "name", "电视"),
                ImmutableMap.of("id", "CW", "name", "厨卫"),
                ImmutableMap.of("id", "BX", "name", "冰洗"),
                ImmutableMap.of("id", "KT", "name", "空调"),
                ImmutableMap.of("id", "XD", "name", "小电"),
                ImmutableMap.of("id", "3C", "name", "3C")
        );
        for (Map<String, String> map : list) {
            g.generateByMap(map, "bpmn_byMap");
        }
    }
}
