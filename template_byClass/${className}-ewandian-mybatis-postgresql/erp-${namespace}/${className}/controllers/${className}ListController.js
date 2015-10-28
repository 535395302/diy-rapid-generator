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
        function ($q,$filter,$scope, $rootScope, $modal,$log,$window,${classNameLower}Service) {

            $scope.vo = {};

            $scope.init = function(){  };

            // ${className} grid options
            $scope.gridOptions = {
                dataSource: {
                    serverPaging: true,
                    serverSorting: true,
                    pageSize: 10,
                    transport:{
                        read: function(options){
                            var vo = $scope.vo;
                            vo["page"]=options.data.page;
                            vo["pageCount"]=options.data.pageSize;
                            if (options.data.sort && options.data.sort[0]) {
                                vo.sorting = options.data.sort[0].field+' '+options.data.sort[0].dir;
                            }
                            $scope.lock = true;
                            ${classNameLower}Service.getPageList(vo).then(
                                function (response) {
                                    Util.result(response,
                                        function (response) {options.success(response);},
                                        function (response) {options.error(response);}
                                    );
                                }
                                ,function (response) {options.error(response);}
                            ).finally(function(){$scope.lock = false;});
                        }
                    },
                    schema:{
                        data: function (d) { return d.data.datas;},
                        total: function (d) {return d.data.total;}
                    }
                },
                resizable:true,
                sortable: true,
                selectable:true,
                toolbar:kendo.template(angular.element('#gridHeader').html()),
                dataBound:function(e){
                    if(e.sender.pager.page() > e.sender.pager.totalPages()){
                        e.sender.pager.page(e.sender.pager.totalPages());
                    }
                },
                pageable: {
                    input: true,
                    numeric: false,
                    pageSizes: [10,20,30],
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
                columns: [<#list clazz.fields as field>                    <#if field.javaType == 'boolean'||field.javaType=='java.lang.Boolean'>
                    {   field: "${field.fieldName}"    ,width: "10%"   ,type:'boolean'
                        ,values: [{ text: "是", value: true },{ text: "否", value: false }],title: "${field.remark}"}<#elseif field.javaType == 'java.lang.String'>
                    {   field: "${field.fieldName}"    ,width: "10%"   ,type:'string',title: "${field.remark}"  }<#elseif field.javaType == 'java.lang.Integer' || field.javaType == 'java.lang.Double' || field.javaType == 'java.math.BigDecimal'>
                    {   field: "${field.fieldName}"    ,width: "10%"   ,type:'number'  ,format:'{0:c}',title: "${field.remark}"  }<#elseif field.javaType == 'java.util.Date' || field.javaType == 'java.sql.Timestamp'>
                    {   field: "${field.fieldName}"    ,width: "10%"   ,type:'date'    ,format: "{0: yyyy-MM-dd HH:mm:ss}",title: "${field.remark}"}<#else></#if>,</#list>
                    {   command:[
                            { text: "编辑", click: function (e) {$scope.save${className}(angular.copy(this.dataItem($(e.currentTarget).closest("tr"))));} },
                            { text: "删除", click: function (e) {$scope.remove${className}(this.dataItem($(e.currentTarget).closest("tr")));} }
                        ],
                        title: "操作", width: "15%"
                    }
                ]
            };

            // Reset query conditions
            $scope.reset = function () {
                $scope.vo = {};
            };

            //点击查询
            $scope.search = function () {
                $scope.grid.dataSource.read();
            };

            // Edit window
            $scope.save${className} = function (obj) {
                var modalInstance = $modal.open({
                    keyboard: false,
                    backdrop: 'static',
                    templateUrl: 'resources/erp-${namespace}/${className}/views/${className}Edit.html',
                    controller: function ($window,$scope, $modalInstance,entity) {
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
                    },
                    //size: 'lg',
                    windowClass:'modal-dialog-width-70',
                    resolve: {
                        entity: function () { return obj; }
                    }
                });

                modalInstance.result.then(function (data) {$scope.search();});
            };

            // Delete
            $scope.remove${className} = function (obj) {
                if(obj && obj['${clazz.fields[0].fieldName}'] && confirm("确定删除吗？")){
                    ${classNameLower}Service.remove(obj['${clazz.fields[0].fieldName}']).then(function (response) {
                        Util.result(response,function(response){$scope.search()});
                    }, function (data) {alert("服务器错误：\n"+data);})
                }
            };

        });
});

/**
 * template:'<span class="text-overflow" title="{{dataItem.model}}" ng-bind="dataItem.model"/>'
 *
 * format: "{0: yyyy-MM-dd HH:mm:ss}"        format:'{0:c}'
 *
 * // Image upload
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