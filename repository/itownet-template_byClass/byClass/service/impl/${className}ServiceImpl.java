<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.impl;

import java.lang.Override;
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;
import ${basepackage}.model.${namespace}.${className};

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Resource
    private ${className}Dao dao;

    /**
     *
     * @Title: selectAll
     * @Description: 查找所有记录
     */
    @Override
    List<${className}> selectAll(){
        return dao.selectAll();
    }

    /**
     *
     * @Title: save

     * @Description: 保存
     */
    @Override
    void save(${className} ${classNameLower}){
        if(${classNameLower}==null){
            return;
        }
        dao.insert(${classNameLower});
    }

    /**
     *
     * @Title: update

     * @Description: 更新
     */
    @Override
    int update(${className} ${classNameLower}){
        if(${classNameLower}==null){
            return 0;
        }
        return dao.update(${classNameLower});
    }

    /**
     *
     * @Title: selectByPK

     * @Description: 查询
     */
    @Override
    ${className} selectByPK(${clazz.fields?first.javaType} ${clazz.fields?first.fieldName}){
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
    int delete(${clazz.fields?first.javaType} ${clazz.fields?first.fieldName}){
        if(id==null){
            return 0;
        }
        return dao.deleteByPK(id);
    }
}
