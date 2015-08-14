<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;


import ${basepackage}.model.${namespace}.${className};

import java.util.List;

/**
 * 
 * @Description: 业务层接口

 * @author: ???
 */
public interface ${className}Service {

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
	void save(${className} ${classNameLower});

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
	int delete(${column.javaType} id);
	</#if>
</#list>

}
