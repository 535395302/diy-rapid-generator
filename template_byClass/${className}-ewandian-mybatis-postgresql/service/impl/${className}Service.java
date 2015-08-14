<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.impl;

<#include "/java_imports.include">
//import com.ewandian.b2b.common.service.impl.BaseService;
//import ${basepackage}.dao.I${className}Dao;
import ${basepackage}.validation.I${className}Validation;
import ${basepackage}.domain.${className};
import ${basepackage}.common.${namespace?cap_first}CommonService;
import ${basepackage}.service.I${className}Service;

import com.ewandian.platform.common.ApplicationContextHolder;
import com.ewandian.platform.common.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import java.util.UUID;
import java.util.Date;
/**
 * ${className}的业务服务实现
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
//@Service
public class ${className}Service extends ${namespace?cap_first}CommonService<${className}> implements I${className?cap_first}Service {

    //private I${className}Dao ${classNameLower}Dao;
    private IBaseDAO commonDAO;

    private I${className}Validation ${classNameLower}Validation;

    private static Logger logger = Logger.getLogger(${className}Service.class);

    @Override
    public void preInsert(${className} entity){
        // 唯一键约束校验
//        if (StringUtils.isNotEmpty(entity.get${clazz.fields[0].fieldName?cap_first}()) && get${className}Validation().isExist(entity)) {
//            throw new BusinessException(String.format("已有“%s”，请不要重复输入！",entity.getId()));
//        }

        entity.set${clazz.fields[0].fieldName?cap_first}(new Date().getTime()+"");

        //校验字符串(长度和空)
        Errors error = new BindException(entity, ${className}.class.getName());
        this.get${className}Validation().validate(entity, error);
        if (error.hasErrors()){
            throw new BusinessException(error);
        }
    }

    @Override
    public void preUpdateById(${className} entity) {
        // TODO update Validation
        super.preUpdateById(entity);
    }

    //-----
    @Override
    protected IBaseDAO<${className}> getBaseDao() {
        return this.commonDAO;
    }

    public I${className}Validation get${className}Validation() {
        if(this.${classNameLower}Validation == null) {
            this.${classNameLower}Validation = (I${className}Validation) ApplicationContextHolder.getBean("${classNameLower}Validation");
        }
        return ${classNameLower}Validation;
    }
    public void setCommonDAO(IBaseDAO commonDAO) {
        this.commonDAO = commonDAO;
        this.commonDAO.setSqlNamespace(${className}.class.getName());
    }
}
