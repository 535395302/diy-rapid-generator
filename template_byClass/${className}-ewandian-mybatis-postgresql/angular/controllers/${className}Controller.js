<#include "/macro.include"/>
<#assign className = clazz.className>
<#assign classNameLower = className?uncap_first>
/**
 * @author：Tian
 * @date: ${now?string('yyyy/MM/dd')}
 */

"use strict";

define([], function () {
    var app = angular.module('${basepackage}.${namespace}.${classNameLower}Controller',[]);
    app.controller('${classNameLower}Controller',
        function ($scope, $rootScope, $modal,$log,$window,${classNameLower}Service,$modalInstance) {
            $scope.init = function(){

            };

            // kendo grid common setting
            $scope.gridSetting = {

            };

            // ${className} grid options
            $scope.gridOptions = {
                dataSource: {
                    serverPaging: true,
                    serverSorting: true,
                    pageSize: 10,
                    transport:{
                        read: function(options){
                            var vo = $scope.vo;
                            vo["pageCount"]=options.data.pageSize;
                            vo["page"]=options.data.page;
                            ${classNameLower}Service.getList(vo).then(
                                function success(response) {options.success(response);}
                                ,function error(response) {options.error(response);}
                            );
                        }
                    },
                    schema:{
                        data: function (d) {
                            return d.data;
                        },
                        total: function (d) {
                            return d.total;
                        },
                        model:{
                            fields:{
                            <#list clazz.fields as field>
                                <#if field.javaType == 'boolean'||field.javaType=='java.lang.Boolean'>
                                    <#if field != clazz.fields?first>,</#if>'${field.fieldName}':{type:'boolean'}
                                <#elseif field.javaType == 'java.lang.String'>
                                    <#if field != clazz.fields?first>,</#if>'${field.fieldName}':{type:'string'}
                                <#elseif field.javaType == 'java.lang.Integer'>
                                    <#if field != clazz.fields?first>,</#if>'${field.fieldName}':{type:'number'}
                                <#elseif field.javaType == 'java.util.Date'>
                                    <#if field != clazz.fields?first>,</#if>'${field.fieldName}':{type:'date'}
                                <#else>
                                </#if>
                            </#list>
                            }
                        }
                    }
                },
                filterable: $scope.gridSetting.filterable,
                resizable:true,
                sortable: true,
                pageable: {
                    input: true,
                        numeric: false,
                        messages: {
                        display: "显示{0}-{1}条，共{2}条",
                            empty: "没有数据",
                            page: "页",
                            of: "/ {0}",
                            itemsPerPage: "条/页",
                            first: "第一页",
                            previous: "前一页",
                            next: "下一页",
                            last: "最后一页",
                            refresh: "刷新"
                    }
                },
                columns: [
                    <#list clazz.fields as field>
                    <#if field.javaType == 'boolean'||field.javaType=='java.lang.Boolean'>
                    {   field: "${field.fieldName}",
                        title: "${field.fieldName?cap_first}",
                        width: "10%",
                        values: [
                            { text: "True", value: true },
                            { text: "False", value: false }
                        ]
                    }<#elseif field.javaType == 'java.lang.String'>
                    {   field: "${field.fieldName}",
                        title: "${field.fieldName?cap_first}",
                        width: "10%"
                    }<#elseif field.javaType == 'java.lang.Integer'>
                    {   field: "${field.fieldName}",
                        title: "${field.fieldName?cap_first}",
                        width: "10%"
                    }<#elseif field.javaType == 'java.util.Date'>
                    {   field: "${field.fieldName}",
                        title: "${field.fieldName?cap_first}",
                        width: "10%",
                        format: "{0: yyyy-MM-dd HH:mm:ss}"
                    }<#else></#if>,</#list>
                    {   command:[
                            { text: "编辑", click: function (e) {$scope.save${className}(angular.copy(this.dataItem($(e.currentTarget).closest("tr"))));} },
                            { text: "删除", click: function (e) {$scope.remove${className}(this.dataItem($(e.currentTarget).closest("tr")));} }
                        ],
                        title: "操作", width: "15%"
                    }
                ]
            };

            $scope.reset = function () {
                $scope.vo=null;
                $scope.grid.dataSource.read();
            };

            //点击查询
            $scope.search = function () {
                $scope.grid.dataSource.read();
            };

            // ${className} edit
            $scope.save${className} = function (obj) {
                var modalInstance = $modal.open({
                    keyboard: false,
                    backdrop: 'static',
                    templateUrl: 'resources/platform/????????/views/${className}Edit.html',
                    controller: function ($scope, $modalInstance,entity) {
                        $scope.entity = entity || {} ;

                        $scope.validation = {rules: {}, messages: {required:'必填'}};

                        $scope.save = function (obj) {
                            // 验证通过
                            if( $scope.validator.validate() ){
                                ${classNameLower}Service.save(obj).then(
                                    function(data){
                                        if(data.status===1 || data.status==='ERROR'){
                                            alert(data.message);
                                        }else{
                                            $modalInstance.close(data);
                                        }
                                    },function(data){
                                        $window.alert("保存失败：\n" + data ) ;
                                        console.log("保存失败：" , data);
                                    }
                                );

                            }else{
                                for (var i in $scope.validator._errors) { angular.element('[name="'+i+'"]')[0].focus(); break; }
                            }
                        };

                        $scope.cancel = function () {
                            $modalInstance.dismiss('cancel');
                        };
                    },
                    size: 'lg',
                    resolve: {
                        entity: function () { return obj; }
                    }
                });

                modalInstance.result.then(function (result) {
                    // TODO refresh $scope.grid
                }, function () {
                    // close model
                });
            };

            // ${className} delete
            $scope.remove${className} = function (obj) {
                if(obj && obj.${clazz.fields[0].fieldName} && confirm("确定删除吗？")){
                    ${classNameLower}Service.remove(obj.${clazz.fields?first.fieldName}).then(function (response) {
                        if(response.status==='OK'||response.status===0){
                            $window.alert ("删除成功!");
                            $scope.grid.dataSource.read();
                        }else{
                            $window.alert ("出错啦!错误原因:"+response.message);
                        }
                    }, function (data, status) {
                        // error
                        alert("服务器错误："+status+"\n"+data);
                    })
                }
            };

        });
});

/** // Image upload
 * 'VirtualDirectoryWindow'
 * $scope.imgUrl= $scope.entity['imgId'] ? '/images/'+$scope.entity['imgId'] : undefined ;
 * $scope.uploadImage = function () {
        VirtualDirectoryWindow.open({crmId:$rootScope.userInfo.crmId}, function isOk(result){
            if (result.files.length > 0) {
                $scope.entity['imgId']= result.files[0]['fileId'];
                $scope.imgUrl = '/images/' + $scope.entity['imgId'];
            }
        });
    };
 * */