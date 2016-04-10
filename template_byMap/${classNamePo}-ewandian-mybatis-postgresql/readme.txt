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
|       public static final String ${classNamePo}_PATH = BATH_PATH + "${classNameLower}";
|
|
|   3. 菜单
|       State:
            templateUrl:    resources/erp-${namespace}/${classNamePo}/views/${classNamePo}List.html
|           uiSref:         app.${namespace}.${classNameLower}
            url:            /${classNameLower}
            controllers:
                            ["resources/erp-${namespace}/${classNamePo}/controllers/${classNamePo}ListController.js"
                            ,"resources/erp-${namespace}/${classNamePo}/controllers/add${classNamePo}Controller.js"]
            services:
                            ["resources/erp-${namespace}/${classNamePo}/services/${classNamePo}Service.js"]

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
|       <bean id="${classNameLower}Service"     class="${basepackage}.${namespace}.service.impl.${classNamePo}Service"></bean>
|       <bean id="${classNameLower}Controller"  class="${basepackage}.${namespace}.web.${classNamePo}Controller">
            <property name="${classNameLower}Service" ref="${classNameLower}Service"/>
        </bean>
|       <bean id="${classNameLower}Validation"  class="${basepackage}.${namespace}.validation.impl.${classNamePo}Validation"></bean>
|
|-----------------------------------------------------------------