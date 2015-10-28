<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
------------------------------------------------------------------
|
| 还需以下步骤【每个文件都需要更改】：
|   1. mapper.xml中，表名填充
|
|       <sql id="table">...</sql>
|
|
|   2. dao中，CommonDAO 更正
|
|       ${namespace?cap_first}CommonDAO
|       I${namespace?cap_first}CommonDAO
|
|
|   3. service中，CommonService 更正
|
|       ${namespace?cap_first}CommonService
|       I${namespace?cap_first}CommonService
|
|   4. controller中，CommonService 更正，requestMapping路径修正
|
|       ${namespace?cap_first}CommonWeb
|
|
|   5. angualr中，controller.js/service.js路径参数修正
|
|       html,url
|
|
|   6. validation中，修正
|
|       ${namespace?cap_first}CommonValidation
|       I${namespace?cap_first}CommonValidation
|
|   7. spring xml配置
|
|       <bean id="${classNameLower}Controller" class="${basepackage}.web.${className}Controller"></bean>
|       <bean id="${classNameLower}Service" class="${basepackage}.service.impl.${className}Service"></bean>
|       <bean id="${classNameLower}Validation" class="${basepackage}.validation.impl.${className}Validation"></bean>
|
|-----------------------------------------------------------------