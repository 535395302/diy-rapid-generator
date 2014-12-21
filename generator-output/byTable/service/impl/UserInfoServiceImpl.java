/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.somebody.service.impl;


import com.who.are.you.somebody.dao.UserInfoDao;
import com.who.are.you.somebody.service.UserInfoService;
import com.who.are.you.model.somebody.UserInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao dao;

    /**
     *
     * @Title: selectAll
     * @Description: 查找所有记录
     */
    @Override
    List<UserInfo> selectAll(){
        return dao.selectAll();
    }

    /**
     *
     * @Title: save

     * @Description: 保存
     */
    @Override
    void save(UserInfo userInfo){
        if(userInfo==null){
            return;
        }
        dao.insert(userInfo);
    }

    /**
     *
     * @Title: update

     * @Description: 更新
     */
    @Override
    int update(UserInfo userInfo){
        if(userInfo==null){
            return 0;
        }
        return dao.update(userInfo);
    }

    /**
     *
     * @Title: selectByPK

     * @Description: 查询
     */
    @Override
    UserInfo selectByPK(java.lang.Long id){
        if(id==null){
            return null;
        }
        return dao.selectPK(id);
    }

    /**
     *
     * @Title: delete
     *
     * @Description: 删除
     */
    @Override
    int delete(java.lang.Long id){
        if(id==null){
            return 0;
        }
        return dao.deleteByPK(id);
    }
}
