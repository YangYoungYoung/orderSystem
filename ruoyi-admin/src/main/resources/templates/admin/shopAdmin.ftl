<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav-guan.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商铺编号</th>
                            <th>商铺名称</th>
                            <th colspan="6">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list shopList as shop>
                            <tr>
                                <td>${shop.id}</td>
                                <td>${shop.name}</td>
                                <td><a href="/admin/goAddFloor?shopId=${shop.id}">添加店铺楼层信息</a></td>
                                <td><a href="/admin/goAddspecification?shopId=${shop.id}">添加店铺座位规格信息</a></td>
                                <td><a href="/admin/goAddTable?shopId=${shop.id}">添加店铺座位信息</a></td>
                                <td><a href="/admin/goUpdate?shopId=${shop.id}&shopName=${shop.name}">修改</a></td>
                                <td><a href="/admin/delete?shopId=${shop.id}">删除</a></td>
                                <td><a href="/boss/today?shopId=${shop.id}&userType=${userType}">老板管理模式</a></td>
                            </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>