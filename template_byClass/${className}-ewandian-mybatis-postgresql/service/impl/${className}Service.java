<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${namespace}.service.impl;

<#include "/java_imports.include">
import com.ewandian.b2b.common.service.impl.BaseService;
import ${basepackage}.${namespace}.dao.I${className}Dao;
import ${basepackage}.${namespace}.service.I${className}Service;

/**
 * ${className}的业务服务实现
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
//@Service
public class ${className}Service extends ${namespace}CommonService<${className}Vo> implements I${className}Service {

    private I${className}Dao ${classNameLower}Dao;

    private I${className}Validation ${classNameLower}Validation;

    private static Logger logger = Logger.getLogger(${className}Service.class);

    @Override
    public void preInsert(${className}Vo entity){
        // 唯一键约束校验
        if (StringUtils.isNotEmpty(entity.getId()) && get${className}Validation().isExist(entity.getId())) {
            throw new BaseBizException(String.format("已有“%s”，请不要重复输入！",entity.getId()));
        }

        entity.setId('');

        //校验字符串(长度和空)
        Errors error = new BindException(entity, ${className}Vo.class.getName());
        this.get${className}Validation().validate(entity, error);
        if (error.hasErrors()){
            throw new BusinessException(error);
        }
    }

    @Override
    public void preUpdateById(${className}Vo entity) {
        // TODO update Validation
        super.preUpdateById(entity);
    }

    //-----
    @Override
    protected IBaseDAO<${className}Vo> getBaseDao() {
        return get${className}DAO();
    }

    public I${className}DAO get${className}DAO() {
        if(this.${classNameLower}DAO == null) {
            this.${classNameLower}DAO = (I${className}DAO) ApplicationContextHolder.getBean("${classNameLower}DAO");
        }
        return this.${classNameLower}DAO;
    }

    public I${className}Validation get${className}Validation() {
        if(this.${classNameLower}Validation == null) {
            this.${classNameLower}Validation = (I${className}Validation) ApplicationContextHolder.getBean("${classNameLower}Validation");
        }
        return ${classNameLower}Validation;
    }
}
