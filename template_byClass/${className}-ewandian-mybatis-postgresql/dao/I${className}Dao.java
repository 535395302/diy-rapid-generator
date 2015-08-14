<#include "/java_copyright.include">
<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

<#include "/java_imports.include">
import com.ewandian.b2b.common.dao.IBaseDAO;

/**
 * ${className}的Dao层接口
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public interface I${className}Dao extends I${namespace?cap_first}CommonDAO<${className}Vo>{}
