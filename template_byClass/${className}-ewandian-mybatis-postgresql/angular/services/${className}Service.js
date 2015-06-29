<#include "/macro.include"/>
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
/**
 * @author：Tian
 * @date: ${now?string('yyyy/MM/dd')}
 */
'use strict';
define([], function () {
    angular.module('${basepackage}.${namespace}.${classNameLower}Service',[]).factory('${classNameLower}Service',
    ["$http","$q",
    function ($http,$q) {
        var instance = {};

        var basepath = '/${namespace}Service/${classNameLower}/';

        /** 获取${className}列表 */
        instance.list = function (vo) {
            var d = $q.defer();
            $http.post(basepath+'selectPageList',vo)
                .success(function (response) { d.resolve(response); })
                .error(function (response) {d.reject(response);});
            return d.promise;
        }

        /**
         * 保存${className}（包括新增，更新）
         * @param ${classNameLower}
         */
        instance.save = function (vo) {
            var d = $q.defer();
            $http.post(basepath+(vo['${clazz.fields[0].fieldName}'] ? 'updateOne' : 'insertOne'), vo)
                .success(function (response) { d.resolve(response); })
                .error(function (response) {d.reject(response);});
            return d.promise;
        };

        /**
         * 删除${className}，级联删除${className}所持Card
         * @param id 被删除的${classNameLower}的ID
         */
        instance.remove = function (id) {
            var d = $q.defer();
            $http.post(basepath+'deleteById/' + id)
                .success(function (response) { d.resolve(response); })
                .error(function (response) {d.reject(response);});
            return d.promise;
        };

        return instance;
    }]);
});