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
                    <form role="form" method="post" action="/boss/updatemaiter">
                        <div class="form-group">
                            <label>用户名</label>
                            <input name="userName" type="text" class="form-control" value="${user.userName}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="text" class="form-control" value="${user.password}"/>
                        </div>

                        <input hidden type="text" name="userId" value="${user.id}">
                        <input hidden type="text" name="shopId" value="${shopId}">
                        <input hidden type="text" name="userType" value="${userType}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>