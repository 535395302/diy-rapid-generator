<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import ${basepackage}.common.I${namespace?cap_first}CommonService;
import ${basepackage}.domain.${className};

/**
 * ${className}的业务服务接口
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public interface I${className}Service extends I${namespace?cap_first}CommonService<${className}>{}
