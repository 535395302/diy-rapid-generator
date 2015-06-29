<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${namespace}.domian.vo;

import com.ewandian.common.b2b.entity.BaseEntity;

/**
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public class ${className} extends BaseEntity {
<#list clazz.fields as field>
    private ${field.javaType} ${field.fieldName};
</#list>
<#list clazz.fields as field>

    public ${field.javaType} get${field.fieldName?cap_first}(){
        return  this.${field.fieldName};
    }

    public void set${field.fieldName?cap_first}(${field.javaType} ${field.fieldName}){
        this.${field.fieldName} = ${field.fieldName};
    }
</#list>
}
