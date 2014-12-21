/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.somebody.web;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.who.are.you.busanalysis.service.UserInfoService;
import com.who.are.you.core.web.struts2.BaseActionSupport;
import com.who.are.you.core.web.struts2.Struts2Utils;
import com.who.are.you.model.somebody.UserInfo;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;

import javax.annotation.Resource;

import java.util.*;


/**
 *
 */
@Namespace("/somebody")
public class UserinfoAction extends BaseActionSupport<UserInfo> {

    private static final long serialVersionUID = 1L;

    UserInfo userInfo;

    @Resource
    private UserInfoService userInfoService;


    /**
     * 异步Ajax：返回集合
     */
    public void listAjax() {
        List list = Lists.newArrayList();
        // TODO 获取集合数据
        Struts2Utils.renderJson(new Gson().toJson(list));
    }

    /** 编辑的页面 */
    public String edit(){
        // FIXME 仅供参考
        String id = getRequest().getParameter("id");
        if(StringUtils.isNotEmpty(id)){
            UserInfo obj = UserInfoService.selectByPK(Integer.parseInt(id));
            getRequest().setAttribute("userInfo", obj);
        }

        return "edit";
    }

    /**
     * 异步Ajax：新增，更新
     */
    public void saveAjax() {
        // FIXME 仅供参考
        if (userInfo != null) {
            if (userInfo.getPK() != null) {
                userInfoService.update(userInfo);
            } else {
                userInfoService.save(userInfo);
            }
        }
        Struts2Utils.renderJson(new Gson().toJson(userInfo));
    }

    /**
     * 异步Ajax：删除
     */
    public void deleteAjax() {
        // FIXME 仅供参考
        String id = getRequest().getParameter("id");
        int result = UserInfoService.delete(Integer.parseInt(id));

        // return "true" or "false"
        Struts2Utils.renderText(new Boolean(result > 0).toString());
    }


    // ---setter/getter---
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    protected void prepareModel() throws Exception {
    }

    @Override
    public UserInfo getModel() {
        return null;
    }
}
