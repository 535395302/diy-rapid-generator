<#include "/macro.include"/>
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
'use strict';
/**
 * @author：Tian
 * @date: ${now?string('yyyy/MM/dd')}
 */
define([], function () {
    var customersFactory = function ($http,$q) {
        var serviceBase = '/${namespace}Service/${classNameLower}/',
            factory = {};

        /** 获取${className}列表 */
        factory.getPageList = function (vo) {
            return $http.post(serviceBase+'selectPageList',vo||{});
        };

        /** 获取${className}列表 */
        factory.getList = function (vo) {
            return $http.post(serviceBase+'selectList',vo||{});
        };

        /**
         * 保存${className}（包括新增，更新）
         * @param ${classNameLower}
         */
        factory.save = function (vo) {
            return $http.post(serviceBase+(vo['${clazz.fields[0].fieldName}'] ? 'updateOne' : 'insertOne'), vo);
        };

        /**
         * 删除${className}
         * @param id 被删除的${classNameLower}的ID
         */
        factory.remove = function (id) {
            return $http.post(serviceBase+'deleteById/' + id);
        };

        return factory;
    };

    angular.module('${basepackage}.${namespace}.${classNameLower}Service',[]).factory('${classNameLower}Service', customersFactory);
});


