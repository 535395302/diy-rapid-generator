<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.ewandian.b2b2c.basic.crm.validation;

import ${basepackage}.common.I${namespace?cap_first}CommonValidation;
import ${basepackage}.domain.${className};

/**
 * ${className}-validation接口
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public interface I${className}Validation extends I${namespace?cap_first}CommonValidation<${className}> {
	  //判断是否存在
//	  public boolean isExist(${className} ${classNameLower});
}
