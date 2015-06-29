<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${namespace}.service;

<#include "/java_imports.include">
import com.ewandian.b2b.common.service.IBaseService;
import ${basepackage}.${namespace}.domian.vo.${className};

/**
 * ${className}的业务服务接口
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public interface I${className}Service extends I${namespace}CommonService<${className}Vo>{}
