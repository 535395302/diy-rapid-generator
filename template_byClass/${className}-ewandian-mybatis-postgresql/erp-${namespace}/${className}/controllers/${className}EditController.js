<#include "/macro.include"/>
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
/**
 * @author：Tian
 * @date: ${now?string('yyyy/MM/dd')}
 */
"use strict";

define([], function () {
    var app = angular.module('${basepackage}.${namespace}.add${classNameLower}Controller',[]);
    app.controller('add${classNameLower}Controller',
        function ($q,$filter,$scope, $rootScope, $modal,$log,$window,${classNameLower}Service, $modalInstance,entity) {



            $scope.entity = entity || {} ;

            $scope.validation = {rules: {}, messages: {required:'必填'}};

            $scope.save = function (obj) {
                // 验证通过
                if( $scope.validator.validate() ){
                    $scope.lock = true;
                    ${classNameLower}Service.save(obj).then(
                        function(response){
                            Util.result(response, function (response) {$modalInstance.close(response);});
                        },function(response){
                            $window.alert("保存失败：\n" + response ) ;
                            console.log("保存失败：" , response);
                        }
                    ).finally(function(){$scope.lock = false;});

                }else{
                    for (var i in $scope.validator._errors) { angular.element('[name="'+i+'"]')[0].focus(); break; }
                }
            };

            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };

        }
    );
});
