<#include "/macro.include"/>

------------------------------------------------------------------
|
| 还需以下步骤【每个文件都需要更改】：
|   1. mapper.xml中，表名填充
|
|       <sql id="table">...</sql>
|
|
|   2. PathConstants
|       public static final String BATH_PATH = "/${namespace}Service/";
|       public static final String ${className}_PATH = BATH_PATH + "${classNameLower}";
|
|
|   3. 菜单
|       State:
            templateUrl:    resources/erp-${namespace}/${className}/views/${className}List.html
|           uiSref:         app.${namespace}.${classNameLower}
            url:            /${classNameLower}
            controllers:
                            ["resources/erp-${namespace}/${className}/controllers/${className}ListController.js"
                            ,"resources/erp-${namespace}/${className}/controllers/add${className}Controller.js"]
            services:
                            ["resources/erp-${namespace}/${className}/services/${className}Service.js"]

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
|       <bean id="${classNameLower}Service"     class="${basepackage}.${namespace}.service.impl.${className}Service"></bean>
|       <bean id="${classNameLower}Controller"  class="${basepackage}.${namespace}.web.${className}Controller">
            <property name="${classNameLower}Service" ref="${classNameLower}Service"/>
        </bean>
|       <bean id="${classNameLower}Validation"  class="${basepackage}.${namespace}.validation.impl.${className}Validation"></bean>
|
|-----------------------------------------------------------------