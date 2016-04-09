<#include "/java_copyright.include">
package ${basepackage}.${namespace}.domain;

import com.ewandian.common.b2b.entity.BaseEntity;
import org.hibernate.validator.constraints.*;
import com.ewandian.platform.annotation.Label;
import javax.validation.constraints.NotNull;

/**
 * ${comment}
 * @author Tian
 * @date ${now?string("yyyy-MM-dd")}
 * @version 1.0
 */
public class ${className} extends BaseEntity {
<#list fields as field>
    /** ${field.remark} */
    <#if field.notNull == 'true'><#if field.javaType == 'java.lang.String'>@NotEmpty@Length(max = ${field.maxLength})<#else>@NotNull</#if></#if>@Label("${className}.${field.fieldName}")
    private ${field.javaType} ${field.fieldName};

</#list>

    public ${className}(){}
<#list fields as field>

    public ${field.javaType} get${field.fieldName?cap_first}(){
        return  this.${field.fieldName};
    }

    public void set${field.fieldName?cap_first}(${field.javaType} ${field.fieldName}){
        this.${field.fieldName} = ${field.fieldName};
    }
</#list>
}
