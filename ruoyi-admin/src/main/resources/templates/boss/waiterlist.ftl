<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav-boss.ftl">
    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <a href="/boss/insertwaiter?shopId=${shopId}&userType=${userType}">添加用户</a>
                        <thead>
                        <tr>
                            <th>账号</th>
                            <th>密码</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list userList as user>
                        <tr>
                            <td>${user.userName}</td>
                            <td>${user.password}</td>
                            <td><a href="/boss/upskip?userId=${user.id}&shopId=${shopId}&userType=${userType}">修改</a></td>
                            <td><a href="/boss/deletewaiter?userId=${user.id}&shopId=${shopId}&userType=${userType}">删除</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<#--弹窗-->



</body>
</html>