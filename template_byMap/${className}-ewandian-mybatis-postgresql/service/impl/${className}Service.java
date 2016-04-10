<#include "/java_copyright.include">

package ${basepackage}.${namespace}.service.impl;

<#include "/java_imports.include">
import com.ewandian.b2b.common.dao.IBaseDAO;
import com.ewandian.common.b2b.entity.Result;
import com.ewandian.platform.util.JSRValidationUtil;
import ${basepackage}.${namespace}.domain.${classNameVo};
import ${basepackage}.${namespace}.common.${namespace?cap_first}CommonService;
import ${basepackage}.${namespace}.service.I${className}Service;

import com.ewandian.platform.common.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import java.util.Date;
/**
 * ${classNameVo}的业务服务实现
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
//@Service
public class ${className}Service extends ${namespace?cap_first}CommonService<${classNameVo}> implements I${className?cap_first}Service {

    private IBaseDAO commonDAO;

    private static Logger logger = Logger.getLogger(${className}Service.class);

    @Override
    public void insert(${classNameVo} entity){

        entity.set${fields[0].fieldName?cap_first}(new Date().getTime()+"");

        //校验字符串(长度和空)
        Result result = JSRValidationUtil.validate(entity);
        if (result.isError()){
            throw new BusinessException(String.valueOf(result.getMessage()));
        }
        // TODO 键约束校验
<#list constraint as cnst>
        /** ${cnst}*/
</#list>
    }

    @Override
    public void preUpdateById(${classNameVo} entity) {
        // TODO update Validation
        super.preUpdateById(entity);
    }

    public List<${classNameVo}> batchSelect(Collection<String> ids){
        if(CollectionUtils.isEmpty(ids)){
            return null;
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("ids",Lists.newArrayList(ids));
        return this.queryList4Map("batchSelect", param);
    }

    //-----
    @Override
    protected IBaseDAO<${classNameVo}> getBaseDao() {
        return this.commonDAO;
    }

    public void setCommonDAO(IBaseDAO commonDAO) {
        this.commonDAO = commonDAO;
        this.commonDAO.setSqlNamespace(${classNameVo}.class.getName());
    }
}
