/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.somebody.web;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.who.are.you.somebody.service.CitizenInfoService;
import com.who.are.you.core.web.struts2.BaseActionSupport;
import com.who.are.you.core.web.struts2.Struts2Utils;
import com.who.are.you.model.somebody.CitizenInfo;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;

import javax.annotation.Resource;

import java.util.*;


/**
 * Action
 */
@Namespace("/somebody")
public class CitizeninfoAction extends BaseActionSupport<CitizenInfo> {

    private static final long serialVersionUID = 1L;

    CitizenInfo citizenInfo;

    @Resource
    private CitizenInfoService citizenInfoService;


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
            CitizenInfo obj = CitizenInfoService.selectByPK(new Java.lang.Integer(id));
            getRequest().setAttribute("citizenInfo", obj);
        }

        return "edit";
    }

    /**
     * 异步Ajax：新增，更新
     */
    public void saveAjax() {
        // FIXME 仅供参考
        if (citizenInfo != null) {
            if (citizenInfo.getPK() != null) {
                citizenInfoService.update(citizenInfo);
            } else {
                citizenInfoService.save(citizenInfo);
            }
        }
        Struts2Utils.renderJson(new Gson().toJson(citizenInfo));
    }

    /**
     * 异步Ajax：删除
     */
    public void deleteAjax() {
        // FIXME 仅供参考
        String id = getRequest().getParameter("id");
        int result = CitizenInfoService.delete(new Java.lang.Integer(id));

        // return "true" or "false"
        Struts2Utils.renderText(new Boolean(result > 0).toString());
    }


    // ---setter/getter---
    public CitizenInfo getCitizenInfo() {
        return citizenInfo;
    }

    public void setCitizenInfo(CitizenInfo citizenInfo) {
        this.citizenInfo = citizenInfo;
    }

    @Override
    protected void prepareModel() throws Exception {
    }

    @Override
    public CitizenInfo getModel() {
        return null;
    }
}
