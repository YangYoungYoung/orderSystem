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
                    <form role="form" method="post" action="/table/tablemodification">
                        <div class="form-group">
                            <label>楼层</label>
                            <input name="floor" type="text" class="form-control" value="${(table.floor)}"/>
                        </div>
                        <div class="form-group">
                            <label>区域</label>
                            <input name="area" type="text" class="form-control" value="${(table.area)}"/>
                        </div>
                        <div class="form-group">
                            <label>规格</label>
                            <input name="specification" type="text" class="form-control" value="${(table.specification)}"/>
                        </div>
                        <input hidden type="text" name="userType" value="${userType}">
                        <input hidden type="text" name="id" value="${table.id}">
                        <input hidden type="text" name="sid" value="${shopId}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>