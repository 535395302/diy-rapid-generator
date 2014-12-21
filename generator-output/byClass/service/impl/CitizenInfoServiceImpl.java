/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.somebody.service.impl;

import java.lang.Override;
import com.who.are.you.somebody.dao.CitizenInfoDao;
import com.who.are.you.somebody.service.CitizenInfoService;
import com.who.are.you.model.somebody.CitizenInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CitizenInfoServiceImpl implements CitizenInfoService {

    @Resource
    private CitizenInfoDao dao;

    /**
     *
     * @Title: selectAll
     * @Description: 查找所有记录
     */
    @Override
    List<CitizenInfo> selectAll(){
        return dao.selectAll();
    }

    /**
     *
     * @Title: save

     * @Description: 保存
     */
    @Override
    void save(CitizenInfo citizenInfo){
        if(citizenInfo==null){
            return;
        }
        dao.insert(citizenInfo);
    }

    /**
     *
     * @Title: update

     * @Description: 更新
     */
    @Override
    int update(CitizenInfo citizenInfo){
        if(citizenInfo==null){
            return 0;
        }
        return dao.update(citizenInfo);
    }

    /**
     *
     * @Title: selectByPK

     * @Description: 查询
     */
    @Override
    CitizenInfo selectByPK(java.lang.Integer id){
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
    int delete(java.lang.Integer id){
        if(id==null){
            return 0;
        }
        return dao.deleteByPK(id);
    }
}
