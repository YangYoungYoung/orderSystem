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
                        <tr style="background-color: #10a6b4;color: #fff;">
                            <th style="text-align: center;height: 40px;line-height: 40px"">商铺名称</th>
                            <th style="text-align: center;height: 40px;line-height: 40px"">商铺地址</th>
                            <th style="text-align: center;height: 40px;line-height: 40px"">商铺WiFi</th>
                            <th style="text-align: center;height: 40px;line-height: 40px"">商铺电话</th>
<#--                            <th>商铺展示图</th>-->
<#--                            <th>商铺轮播图</th>-->
                            <th colspan="2" style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list shopList as shop>
                        <tr>
                            <td style="text-align: center;height: 40px;line-height: 40px">${shop.name}</td>
                            <td style="text-align: center;height: 40px;line-height: 40px">${shop.address}</td>
                            <td style="text-align: center;height: 40px;line-height: 40px">${shop.wifi}</td>
                            <td style="text-align: center;height: 40px;line-height: 40px">${shop.phone}</td>
<#--                            <td><img src="${shop.details}"></td>-->
<#--                            <td><img src="${shop.banner}"></td>-->
                            <td style="text-align: center;height: 40px;line-height: 40px"><a href="/shop/updatelist?shopId=${shop.id}&shopName=${shop.name}&userType=${userType}">修改</a></td>
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