/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.somebody.service;


import com.who.are.you.model.somebody.CitizenInfo;

import java.util.List;

/**
 * 
 * @Description: 业务层接口

 * @author: ???
 */
public interface CitizenInfoService {

	/**
	 *
	 * @Title: selectAll
	 * @Description: 查找所有记录
	 */
	List<CitizenInfo> selectAll();

	/**
	 *
	 * @Title: save

	 * @Description: 保存
	 */
	void save(CitizenInfo citizenInfo);

	/**
	 *
	 * @Title: update

	 * @Description: 更新
	 */
	int update(CitizenInfo citizenInfo);

	/**
	 *
	 * @Title: selectByPK

	 * @Description: 查询
	 */
	CitizenInfo selectByPK(Java.lang.Integer id);

	/**
	 *
	 * @Title: delete
	 *
	 * @Description: 删除
	 */
	int delete(Java.lang.Integer id);

}
