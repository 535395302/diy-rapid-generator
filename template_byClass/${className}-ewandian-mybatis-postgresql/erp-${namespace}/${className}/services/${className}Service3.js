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
            return $http[httpMethod||'post'](serviceBase+'path',vo||{});
        };

        return factory;
    };

    angular.module('${basepackage}.${namespace}.${classNameLower}Service',[]).factory('${classNameLower}Service', customersFactory);
});


