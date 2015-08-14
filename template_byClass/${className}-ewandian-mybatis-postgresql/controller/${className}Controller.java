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
        if (logger.isErrorEnabled()) {
            logger.error("\n================== query list =====================");
            Object list = get${className}Service().queryAll();
            logger.error(list);
            logger.error("=================== insert =====================");
            ${className} vo = new ${className}();
<#list clazz.fields as field>
            vo.set${field.fieldName?cap_first}(<#if field.javaType=='java.lang.Boolean'>false<#elseif field.javaType == 'java.lang.String'>"${field.fieldName}"<#elseif field.javaType == 'java.lang.Integer'>2<#elseif field.javaType == 'java.lang.Double'>2D<#elseif field.javaType == 'java.util.Date'>new Date()<#else>..</#if>);
</#list>
            get${className}Service().insert(vo);
            logger.error(vo);
            logger.error("==================== update ===================");
            ${className} vo1 = get${className}Service().queryById(vo.get${clazz.fields[0].fieldName?cap_first}());
            Assert.notNull(vo1);
            vo1.set${clazz.fields[1].fieldName?cap_first}(vo1.get${clazz.fields[1].fieldName?cap_first}() + " 1");
            int result = get${className}Service().updateById(vo1);
            logger.error("update result: "+result);
            logger.error("==================== delete ===================");
            result = get${className}Service().deleteById(vo.get${clazz.fields[0].fieldName?cap_first}());
            Assert.notNull(result);
            logger.error("delete result: "+result);
            logger.error("==================== end ===================");
        }
        return new Result(Result.Status.OK,"test ok!");
    }

    @Override
    protected IBaseService<${className}> getBaseService() {
        return get${className}Service();
    }

    public I${className}Service get${className}Service() {
        if(this.${classNameLower}Service == null) {
            this.${classNameLower}Service = (I${className}Service) ApplicationContextHolder.getBean("${classNameLower}Service");
        }
        return ${classNameLower}Service;
    }
}
