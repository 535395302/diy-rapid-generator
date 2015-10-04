<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.web;

import ${basepackage}.service.I${className}Service;
import com.ewandian.b2b.common.service.IBaseService;
import ${basepackage}.common.${namespace?cap_first}CommonWeb;
import ${basepackage}.domain.${className};
import ${basepackage}.service.I${className}Service;
import com.ewandian.platform.common.ApplicationContextHolder;
import com.ewandian.common.b2b.entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * ${className}的控制器
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
@Controller
@RequestMapping("/${classNameLower}")
public class ${className}Controller extends ${namespace?cap_first}CommonWeb<${className}, ${className}>{

    private I${className}Service ${classNameLower}Service;

    @RequestMapping("/test")
    @ResponseBody
    public Result test(){
        return new Result(Result.Status.OK,"test ok!");
    }

    @Override
    protected IBaseService<${className}> getBaseService() {
        return get${className}Service();
    }

    public void set${className}Service(I${className}Service ${classNameLower}Service) {
        this.${classNameLower}Service = ${classNameLower}Service;
    }
}
