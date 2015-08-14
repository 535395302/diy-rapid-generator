<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dao.impl;


import ${basepackage}.dao.${className}Dao;
import ${basepackage}.core.orm.ibatis.IbatisEntityDao;
import ${basepackage}.model.${namespace}.${className};
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ${className}DaoImpl extends IbatisEntityDao<${className}> implements ${className}Dao {

	/**
	 *
	 * @Title: selectAll
	 * @Description: 查找所有记录
	 */
	@Override
	public List<${className}> selectAll(){
		return (List<${className}>)getSqlMapClientTemplate().queryForList("${className}.selectAll");
	}

	/**
	 * @param ${classNameLower}
	 * @Title: save
	 * @Description: 保存
	 */
	@Override
	public void insert(${className} ${classNameLower}) {
		getSqlMapClientTemplate().insert("${className}.insert",${classNameLower});
	}


	/**
	 * @param ${classNameLower}
	 * @Title: update
	 * @Description: 更新
	 */
	@Override
	public int update(${className} ${classNameLower}) {
		return getSqlMapClientTemplate().update("${className}.update", ${classNameLower});
	}

	/**
	 * @param id
	 * @Title: selectByPK
	 * @Description: 查询
	 */
	@Override
	public ${className} selectByPK(${clazz.fields?first.javaType} ${clazz.fields?first.fieldName}) {
		return (${className}) getSqlMapClientTemplate().queryForObject("${className}.selectByPK", ${clazz.fields?first.fieldName});
	}

	/**
	 * @param id
	 * @Title: delete
	 * @Description: 删除
	 */
	@Override
	public int deleteByPK(${clazz.fields?first.javaType} ${clazz.fields?first.fieldName}) {
		return getSqlMapClientTemplate().delete("${className}.delete", ${clazz.fields?first.fieldName});
	}

}
