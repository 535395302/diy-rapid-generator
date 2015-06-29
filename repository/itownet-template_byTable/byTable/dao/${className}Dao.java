<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${namespace}.dao;

<#include "/java_imports.include">
import ${basepackage}.model.${namespace}.${className};
import com.itownet.isms.core.orm.ibatis.EntityDAO;

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

<#list table.columns as column>
  <#if column.pk>
	/**
	 *
	 * @Title: selectByPK

	 * @Description: 查询
	 */
	${className} selectByPK(${column.javaType} id);

	/**
	 *
	 * @Title: delete
	 *
	 * @Description: 删除
	 */
	int deleteByPK(${column.javaType} id);
  </#if>
</#list>

}
