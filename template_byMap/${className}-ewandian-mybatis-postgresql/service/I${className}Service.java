<#include "/java_copyright.include">

package ${basepackage}.${namespace}.service;

import ${basepackage}.${namespace}.common.I${namespace?cap_first}CommonService;
import ${basepackage}.${namespace}.domain.${classNameVo};

/**
 * ${classNameVo}的业务服务接口
 *
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public interface I${className}Service extends I${namespace?cap_first}CommonService<${classNameVo}>{
    List<${classNameVo}> batchSelect(Collection<String> ids);
}
