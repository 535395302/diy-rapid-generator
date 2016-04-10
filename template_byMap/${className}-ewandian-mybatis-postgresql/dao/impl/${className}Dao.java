<#include "/java_copyright.include">

package ${basepackage}.dao.impl;

import com.ewandian.b2b.common.dao.impl.BaseDAO;
import ${basepackage}.dao.I${className}Dao;
<#include "/java_imports.include">

/**
 * ${classNameVo}的Dao层实现
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
//@Repository
public class ${className}Dao extends ${namespace?cap_first}CommonDAO<${classNameVo}> implements I${className?cap_first}Dao {
}
