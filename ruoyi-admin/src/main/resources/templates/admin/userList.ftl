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
                    <a href="/boss/bossskip">添加用户</a>
                    <table class="table table-bordered table-condensed">

                    </table>
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商铺编号</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list userList as user>
                            <tr>
                                <td>${user.sid}</td>
                                <td>${user.userName}</td>
                                <td>${user.password}</td>
                                <td><a href="/boss/oneboss?userId=${user.id}&shopId=${user.sid}">修改</a></td>
                                <td><a href="/boss/deleteboss?userId=${user.id}">删除</a></td>
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