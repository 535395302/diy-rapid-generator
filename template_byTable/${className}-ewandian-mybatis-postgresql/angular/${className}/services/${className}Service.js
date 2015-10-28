<#include "/macro.include"/>
<#assign className = table.className>
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
            var d = $q.defer();
            $http.post(serviceBase+'selectPageList',vo||{})
                .success(function (response) { d.resolve(response); })
                .error  (function (response) { d.reject(response);});
            return d.promise;
        }

        /** 获取${className}列表 */
        factory.getList = function (vo) {
            var d = $q.defer();
            $http.post(serviceBase+'selectList',vo||{})
                .success(function (response) { d.resolve(response); })
                .error  (function (response) { d.reject(response);});
            return d.promise;
        }

        /**
         * 保存${className}（包括新增，更新）
         * @param ${classNameLower}
         */
        factory.save = function (vo) {
            var d = $q.defer();
            $http.post(serviceBase+(vo['${table.columns[0].sqlName}'] ? 'updateOne' : 'insertOne'), vo)
                .success(function (response) { d.resolve(response); })
                .error  (function (response) { d.reject(response);});
            return d.promise;
        };

        /**
         * 删除${className}
         * @param id 被删除的${classNameLower}的ID
         */
        factory.remove = function (id) {
            var d = $q.defer();
            $http.post(serviceBase+'deleteById/' + id)
                .success(function (response) { d.resolve(response); })
                .error  (function (response) { d.reject(response);});
            return d.promise;
        };

        return factory;
    };

    angular.module('${basepackage}.${namespace}.${classNameLower}Service',[]).factory('${classNameLower}Service', customersFactory);
});


