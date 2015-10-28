<#include "/java_copyright.include">
<#assign className = table.className>
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
<#list table.columns as field>
    /** ${field.remarks} */
    <#if field.javaType == 'java.lang.String'>@NotEmpty@Length(max = 15)<#else>@NotNull</#if>@Label("${className}.${field.sqlName}")
    private ${field.javaType} ${field.sqlName};

</#list>

    public ${className}(){}
<#list table.columns as field>

    public ${field.javaType} get${field.sqlName?cap_first}(){
        return  this.${field.sqlName};
    }

    public void set${field.sqlName?cap_first}(${field.javaType} ${field.sqlName}){
        this.${field.sqlName} = ${field.sqlName};
    }
</#list>
}
