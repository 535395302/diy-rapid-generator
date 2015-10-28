<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.validation.impl;

import org.springframework.validation.Errors;

import ${basepackage}.common.${namespace?cap_first}CommonValidation;
import ${basepackage}.constants.${namespace?cap_first}Constants;
import ${basepackage}.domain.${className};
import ${basepackage}.validation.I${className}Validation;
import org.springframework.validation.Errors;

/**
 * ${className}-validation 实现
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public class ${className}Validation extends ${namespace?cap_first}CommonValidation<${className}>
		implements I${className}Validation {
	
	//private I${className}DAO ${classNameLower}DAO;

	public boolean supports(Class<?> class1) {
		return class1.equals(${className}.class);
	}

	public void validate(Object obj, Errors errors) {
		${className} ${classNameLower} = (${className}) obj;
		String[] validateValues = {
<#list table.columns as field><#if field.javaType=="java.lang.String">			<#if field == table.columns?first><#else>,</#if>${classNameLower}.get${field.sqlName?cap_first}()
</#if></#list>
		};

		Integer[] maxlengths = {
<#list table.columns as field><#if field.javaType=="java.lang.String"><#if field == table.columns?first>			<#else>,</#if>100</#if></#list>
		};
		/*String[] showMessages = {
<#list table.columns as field><#if field.javaType=="java.lang.String"><#if field == table.columns?first>			<#else>,</#if>"${field.sqlName?cap_first}"</#if></#list>
		};*/
		  
		Integer[] isAllowBlanks ={
<#list table.columns as field><#if field.javaType=="java.lang.String">			<#if field == table.columns?first> <#else>,</#if>${namespace?cap_first}Constants.isBlank.YES.getValue()
</#if></#list>
		};
		//String errorPrefix = "${namespace}.errors.";
		this.doValidateString(errors, validateValues, maxlengths, null,isAllowBlanks,errorPrefix);
	}
	
//	public boolean isExist(${className} ${classNameLower}) {
//		Long count = this.get${className}DAO().selectCount(${classNameLower});
//		return count > 0;
//	}

//	public I${className}DAO get${className}DAO() {
//		if(this.${classNameLower}DAO == null) {
//			this.${classNameLower}DAO = (I${className}DAO) ApplicationContextHolder.getBean("${classNameLower}DAO");
//		}
//		return this.${classNameLower}DAO;
//	}
}
