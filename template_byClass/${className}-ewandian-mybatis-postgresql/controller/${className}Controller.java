<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${namespace}.controller;

import ${basepackage}.${namespace}.service.I${className}Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${className}的控制器
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
@Controller
@RequestMapping("/${classNameLower}")
public class ${className}Controller extends ${namespace}CommonWeb<${className}Vo, ${className}Vo>{

    I${className}Service ${classNameLower}Service;

    @Override
    protected IBaseService<${className}Vo> getBaseService() {
        return get${className}Service();
    }

    public I${className}Service get${className}Service() {
        if(this.${classNameLower}Service == null) {
            this.${classNameLower}Service = (I${className}Service) ApplicationContextHolder.getBean("${classNameLower}Service");
        }
        return ${classNameLower}Service;
    }
}
