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
                            <th>分类编号</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list TypeList as dishTypes>
                        <tr>
                            <td>${dishTypes.id}</td>
                            <td>${dishTypes.dishType}</td>
                            <td><a href="/menu/goUpdateType?dishTypeId=${dishTypes.id}&shopId=${shopId}&userType=${userType}">修改</a></td>
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