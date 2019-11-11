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
                    <form role="form" method="post" action="/boss/insertBoss">
                        <div class="form-group">
                            <label>用户名</label>
                            <input name="userName" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>商铺id</label>
                            <input name="shopId" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>权限id</label>
                            <select name="usertype" type="text" class="form-control">
                                <option value="1">老板</option>
                                <option value="2">服务员</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>