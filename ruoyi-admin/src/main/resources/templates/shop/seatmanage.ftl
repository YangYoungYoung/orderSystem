<html>
<#include "../common/header.ftl">
<link rel ="stylesheet" type="text/css" href="../css/seat.css"/>
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
                <div class="col-md-12 column" style="text-align: center;vertical-align: middle;">
                    <table class="table table-bordered table-condensed" style="text-align: center;vertical-align: middle;">
                        <thead>
                        <tr>
                            <th>楼层</th>
                            <th>区域</th>
                            <th>桌号</th>
                            <th>规格</th>
                            <th>状态</th>
                            <th colspan="4">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list TableGrossList as TableGross>
                            <tr style="vertical-align: middle;text-align: center;">
                                <td style="vertical-align: middle;">${TableGross.floor}楼</td>
                                <#if TableGross.area==1>
                                    <td style="vertical-align: middle;text-align: center;">大厅</td>
                                    <#else>
                                    <td style="vertical-align: middle;text-align: center;">包厢</td>
                                </#if>
                                <td style="vertical-align: middle;text-align: center;">${TableGross.tableName}</td>
                                <td style="vertical-align: middle;text-align: center;">${TableGross.specificationName}</td>
                                <#if TableGross.status==0>
                                    <td style="vertical-align: middle;text-align: center;">空闲</td>
                                    <#elseif TableGross.status==1>
                                    <td style="vertical-align: middle;text-align: center;">已开桌</td>
                                    <#elseif TableGross.status==2>
                                    <td style="vertical-align: middle;text-align: center;">用餐中</td>
                                    <#else>
                                    <td style="vertical-align: middle;text-align: center;">待清理</td>
                                </#if>
                                <td style="vertical-align: middle;text-align: center;"><a href="/table/tableupdate?shopId=${TableGross.sid}&tableId=${TableGross.id}&userType=${userType}">修改</a></td>
                                <td style="vertical-align: middle;text-align: center;"><a href="/table/delete?shopId=${TableGross.sid}&tableId=${TableGross.id}&userType=${userType}">删除</a></td>
                                <#if TableGross.status==0>
                                    <td style="vertical-align: middle;text-align: center;">
                                        <form role="form" method="post" action="/table/updateTableS" style="vertical-align: middle;text-align: center;margin: 0;padding: 0;">
                                            <input type="text" name="population"style="height: 26px;width: 50px;vertical-align: middle;text-align: center;" >&nbsp;&nbsp;人数&nbsp;&nbsp;</input>
                                            <input hidden type="text" name="tableId" style="height: 26px;width: 50px;vertical-align: middle;text-align: center;"  value="${TableGross.id}">
                                            <input hidden type="text" name="userType" style="height: 26px;width: 50px;vertical-align: middle;text-align: center;" value="${userType}">
                                            <input hidden type="text" name="tableStatus" style="height: 26px;width: 50px;vertical-align: middle;text-align: center;" value="${1}">
                                            <input hidden type="text" name="shopId" style="height: 26px;width: 50px;vertical-align: middle;text-align: center;" value="${shopId}">
                                            <button type="submit" class="btn btn-default" style="vertical-align: middle;text-align: center;">开桌</button>
                                        </form>
                                    </td>
                                    <#else>
                                        <td style="vertical-align: middle;text-align: center;">
                                            <form role="form" method="post" action="/table/updateTableS" style="vertical-align: middle;text-align: center;margin: 0;padding: 0;">
                                                <select name="tableStatus" style="text-align: center;height: 26px;line-height: 26px;vertical-align: middle;">
                                                    <option value="0">空闲</option>
                                                    <option value="1">已开桌</option>
                                                    <option value="2">用餐</option>
                                                    <option value="3">待清理</option>
                                                </select>
                                                <input hidden type="text" name="population" style="height: 26px;width: 50px;text-align: center;margin: 0;padding: 0;"  value="${TableGross.population}">
                                                <input hidden type="text" name="tableId" style="height: 26px;width: 50px;text-align: center;"  value="${TableGross.id}">
                                                <input hidden type="text" name="userType"  style="height: 26px;width: 50px;text-align: center;" value="${userType}">
                                                <input hidden type="text" name="shopId" style="height: 26px;width: 50px;text-align: center;"  value="${shopId}">
                                                <button type="submit" class="btn btn-default">提交</button>
                                            </form>
                                        </td>
                                </#if>
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