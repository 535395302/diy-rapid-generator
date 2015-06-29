<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${namespace}.validation.impl;

import org.springframework.validation.Errors;

import ${basepackage}.${namespace}.common.CRMCommonValidate;
import ${basepackage}.${namespace}.constants.${namespace}Constants;
import ${basepackage}.${namespace}.dao.I${className}DAO;
import ${basepackage}.${namespace}.domian.po.${className};
import ${basepackage}.${namespace}.validation.I${className}Validation;
import com.ewandian.platform.common.ApplicationContextHolder;

/**
 * ${className}-validation 实现
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public class ${className}Validation extends ${namespace}CommonValidate<${className}>
		implements I${className}Validation {
	
	private I${className}DAO ${classNameLower}DAO;

	public boolean supports(Class<?> class1) {
		return class1.equals(${className}.class);
	}

	public void validate(Object obj, Errors errors) {
		${className} ${classNameLower} = (${className}) obj;
		  String[] validateValues = {
				  ${classNameLower}.getId(),${classNameLower}.get(),${classNameLower}.get()
				 ,${classNameLower}.get(),${classNameLower}.get(),${classNameLower}.get()
				 ,${classNameLower}.get()
		   };

		  Integer[] maxlengths = {
				 40,40,10,20,10,20,20
		  };
		  String[] showMessages = {
				  "Id","","","","","",""
		  };
		  
		  Integer[] isAllowBlanks ={
				  ${namespace}Constants.isBlank.NO.getValue(),${namespace}Constants.isBlank.NO.getValue()
				 ,${namespace}Constants.isBlank.NO.getValue(),
				  ${namespace}Constants.isBlank.NO.getValue(),${namespace}Constants.isBlank.NO.getValue()
				 ,${namespace}Constants.isBlank.NO.getValue(), ${namespace}Constants.isBlank.YES.getValue()
		  };
		  String errorPrefix = "${namespace}.${classNameLower}.errors.";
		  this.doValidateString(errors, validateValues, maxlengths, showMessages,isAllowBlanks,errorPrefix);
	}
	
	public boolean isExist(${className} ${classNameLower}) {
		Long count = this.get${className}DAO().selectCount(${classNameLower});
		return count > 0;
	}

	public I${className}DAO get${className}DAO() {
		if(this.${classNameLower}DAO == null) {
			this.${classNameLower}DAO = (I${className}DAO) ApplicationContextHolder.getBean("${classNameLower}DAO");
		}
		return this.${classNameLower}DAO;
	}
}
