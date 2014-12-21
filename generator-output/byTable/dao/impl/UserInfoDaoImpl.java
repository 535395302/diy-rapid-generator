/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.somebody.dao.impl;


import com.who.are.you.somebody.dao.UserInfoDao;
import com.who.are.you.core.orm.ibatis.IbatisEntityDao;
import com.who.are.you.model.somebody.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserInfoDaoImpl extends IbatisEntityDao<UserInfo> implements UserInfoDao {

	/**
	 *
	 * @Title: selectAll
	 * @Description: 查找所有记录
	 */
	@Override
	public List<UserInfo> selectAll(){
		return (List<UserInfo>)getSqlMapClientTemplate().queryForList("UserInfo.selectAll");
	}

	/**
	 * @param userInfo
	 * @Title: save
	 * @Description: 保存
	 */
	@Override
	public void insert(UserInfo userInfo) {
		getSqlMapClientTemplate().insert("UserInfo.insert",userInfo);
	}


	/**
	 * @param userInfo
	 * @Title: update
	 * @Description: 更新
	 */
	@Override
	public int update(UserInfo userInfo) {
		return getSqlMapClientTemplate().update("UserInfo.update", userInfo);
	}

	/**
	 * @param id
	 * @Title: selectByPK
	 * @Description: 查询
	 */
	@Override
	public UserInfo selectByPK((java.lang.Long id) {
		return (UserInfo) getSqlMapClientTemplate().queryForObject("UserInfo.selectByPK", id);
	}

	/**
	 * @param id
	 * @Title: delete
	 * @Description: 删除
	 */
	@Override
	public int deleteByPK((java.lang.Long id) {
		return getSqlMapClientTemplate().delete("UserInfo.delete", id);
	}

}
