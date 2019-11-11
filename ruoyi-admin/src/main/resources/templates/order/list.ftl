<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#if userType==2>
        <#include "../common/nav-fu.ftl">
        <#else>
            <#include "../common/nav-boss.ftl">
    </#if>

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>楼层</th>
                            <th>区域</th>
                            <th>餐桌</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>桌子状态</th>
                            <th>打印状态</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderList as order>
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.floorName}层</td>
                            <#if order.areaName==1>
                                <td>大厅</td>
                                <#else>
                                <td>包厢</td>
                            </#if>
                            <td>${order.tableName}</td>
                            <td>${order.totalPrice}</td>
                            <#if order.status==0>
                                <td>未付款</td>
                                <#else>
                                <td>已付款</td>
                            </#if>
                            <#if order.tableStatus==0>
                                <td>空闲</td>
                            <#elseif order.tableStatus==1>
                                <td>已开桌</td>
                            <#elseif order.tableStatus==2>
                                <td>用餐</td>
                            <#else>
                                <td>待清理</td>
                            </#if>
                            <#if order.isPrint==0>
                                <td>未打印</td>
                            <#else>
                                <td>已打印</td>
                            </#if>
                            <td><a href="/order/detail?orderId=${order.orderId}&shopId=${shopId}&userType=${userType}">详情</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>