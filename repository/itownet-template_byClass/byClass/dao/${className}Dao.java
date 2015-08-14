<#include "/java_copyright.include">
<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

<#include "/java_imports.include">
import ${basepackage}.model.${namespace}.${className};
import ${basepackage}.core.orm.ibatis.EntityDAO;

public class ${className}Dao extends EntityDAO<${className}>{

	/**
	 *
	 * @Title: selectAll
	 * @Description: 查找所有记录
	 */
	List<${className}> selectAll();

	/**
	 *
	 * @Title: save
	 * @Description: 保存
	 */
	void insert(${className} ${classNameLower});

	/**
	 *
	 * @Title: update

	 * @Description: 更新
	 */
	int update(${className} ${classNameLower});

	/**
	 *
	 * @Title: selectByPK

	 * @Description: 查询
	 */
	${className} selectByPK(${clazz.fields?first.javaType} ${clazz.fields?first.fieldName});

	/**
	 *
	 * @Title: delete
	 *
	 * @Description: 删除
	 */
	int deleteByPK(${clazz.fields?first.javaType} ${clazz.fields?first.fieldName});

}
