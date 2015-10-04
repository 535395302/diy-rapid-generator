<#include "/java_copyright.include">
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.domain.po;

import com.ewandian.common.b2b.entity.BaseEntity;
import org.hibernate.validator.constraints.*;
import com.ewandian.platform.annotation.Label;

/**
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public class ${className} extends BaseEntity {
<#list clazz.fields as field>
    /** ${field.remark} */
    <#if field.javaType == 'java.lang.String'>@NotEmpty@Length(max = 15)<#else>@NotNull</#if>@Label("${className}.${field.fieldName}")
    private ${field.javaType} ${field.fieldName};

</#list>

    public ${className}(){}
<#list clazz.fields as field>

    public ${field.javaType} get${field.fieldName?cap_first}(){
        return  this.${field.fieldName};
    }

    public void set${field.fieldName?cap_first}(${field.javaType} ${field.fieldName}){
        this.${field.fieldName} = ${field.fieldName};
    }
</#list>
}
