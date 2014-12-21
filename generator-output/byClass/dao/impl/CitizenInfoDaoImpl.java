/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.somebody.dao.impl;


import com.who.are.you.somebody.dao.CitizenInfoDao;
import com.who.are.you.core.orm.ibatis.IbatisEntityDao;
import com.who.are.you.model.somebody.CitizenInfo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CitizenInfoDaoImpl extends IbatisEntityDao<CitizenInfo> implements CitizenInfoDao {

	/**
	 *
	 * @Title: selectAll
	 * @Description: 查找所有记录
	 */
	@Override
	public List<CitizenInfo> selectAll(){
		return (List<CitizenInfo>)getSqlMapClientTemplate().queryForList("CitizenInfo.selectAll");
	}

	/**
	 * @param citizenInfo
	 * @Title: save
	 * @Description: 保存
	 */
	@Override
	public void insert(CitizenInfo citizenInfo) {
		getSqlMapClientTemplate().insert("CitizenInfo.insert",citizenInfo);
	}


	/**
	 * @param citizenInfo
	 * @Title: update
	 * @Description: 更新
	 */
	@Override
	public int update(CitizenInfo citizenInfo) {
		return getSqlMapClientTemplate().update("CitizenInfo.update", citizenInfo);
	}

	/**
	 * @param id
	 * @Title: selectByPK
	 * @Description: 查询
	 */
	@Override
	public CitizenInfo selectByPK(java.lang.Integer id) {
		return (CitizenInfo) getSqlMapClientTemplate().queryForObject("CitizenInfo.selectByPK", id);
	}

	/**
	 * @param id
	 * @Title: delete
	 * @Description: 删除
	 */
	@Override
	public int deleteByPK(java.lang.Integer id) {
		return getSqlMapClientTemplate().delete("CitizenInfo.delete", id);
	}

}
