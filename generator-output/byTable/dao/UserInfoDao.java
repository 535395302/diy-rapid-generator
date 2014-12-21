/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.somebody.dao;

import java.util.*;

import com.who.are.you.somebody.dao.*;
import com.who.are.you.somebody.service.*;
import com.who.are.you.model.somebody.UserInfo;
import com.itownet.isms.core.orm.ibatis.EntityDAO;

public class UserInfoDao extends EntityDAO<UserInfo>{

	/**
	 *
	 * @Title: selectAll
	 * @Description: 查找所有记录
	 */
	List<UserInfo> selectAll();

	/**
	 *
	 * @Title: save
	 * @Description: 保存
	 */
	void insert(UserInfo userInfo);

	/**
	 *
	 * @Title: update

	 * @Description: 更新
	 */
	int update(UserInfo userInfo);

	/**
	 *
	 * @Title: selectByPK

	 * @Description: 查询
	 */
	UserInfo selectByPK(java.lang.Long id);

	/**
	 *
	 * @Title: delete
	 *
	 * @Description: 删除
	 */
	int deleteByPK(java.lang.Long id);

}
