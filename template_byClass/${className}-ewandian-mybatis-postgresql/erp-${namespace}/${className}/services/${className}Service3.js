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

        factory.request = function (path,vo,httpMethod) {
            var d = $q.defer();
            $http[httpMethod||'post'](serviceBase+path,vo||{})
                .success(function (response) {d.resolve(response);})
                .error(function (response) {d.reject(response);});
            return d.promise;
        };

        return factory;
    };

    angular.module('${basepackage}.${namespace}.${classNameLower}Service',[]).factory('${classNameLower}Service', customersFactory);
});


