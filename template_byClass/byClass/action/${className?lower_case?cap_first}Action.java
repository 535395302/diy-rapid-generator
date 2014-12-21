<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "action">
package ${basepackage}.${namespace}.web;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import ${basepackage}.${namespace}.service.${className}Service;
import ${basepackage}.core.web.struts2.BaseActionSupport;
import ${basepackage}.core.web.struts2.Struts2Utils;
import ${basepackage}.model.${namespace}.${className};

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;

import javax.annotation.Resource;

import java.util.*;


/**
 * Action
 */
@Namespace("/${namespace}")
public class ${className?lower_case?cap_first}Action extends BaseActionSupport<${className}> {

    private static final long serialVersionUID = 1L;

    ${className} ${classNameLower};

    @Resource
    private ${className}Service ${classNameLower}Service;


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
            ${className} obj = ${className}Service.selectByPK(new <#list clazz.fields as field><#if field==clazz.fields[0]>${field.javaType?cap_first}</#if></#list>(id));
            getRequest().setAttribute("${classNameLower}", obj);
        }

        return "edit";
    }

    /**
     * 异步Ajax：新增，更新
     */
    public void saveAjax() {
        // FIXME 仅供参考
        if (${classNameLower} != null) {
            if (${classNameLower}.getPK() != null) {
                ${classNameLower}Service.update(${classNameLower});
            } else {
                ${classNameLower}Service.save(${classNameLower});
            }
        }
        Struts2Utils.renderJson(new Gson().toJson(${classNameLower}));
    }

    /**
     * 异步Ajax：删除
     */
    public void deleteAjax() {
        // FIXME 仅供参考
        String id = getRequest().getParameter("id");
        int result = ${className}Service.delete(new <#list clazz.fields as field><#if field==clazz.fields[0]>${field.javaType?cap_first}</#if></#list>(id));

        // return "true" or "false"
        Struts2Utils.renderText(new Boolean(result > 0).toString());
    }


    // ---setter/getter---
    public ${className} get${className}() {
        return ${classNameLower};
    }

    public void set${className}(${className} ${classNameLower}) {
        this.${classNameLower} = ${classNameLower};
    }

    @Override
    protected void prepareModel() throws Exception {
    }

    @Override
    public ${className} getModel() {
        return null;
    }
}
