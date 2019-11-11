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
                    <form role="form" method="post" action="/shop/addshop" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>商铺名称</label>
                            <input name="shopName" type="text" class="form-control" value="${(shop.name)}"/>
                        </div>

                        <div class="form-group">
                            <label>店铺地址</label>
                            <input name="shopaddress" type="text" class="form-control" value="${(shop.address)}"/>
                        </div>

                        <div class="form-group">
                            <label>店铺wifi</label>
                            <input name="shopwifi" type="text" class="form-control" value="${(shop.wifi)}"/>
                        </div>

                        <div class="form-group">
                            <label>店铺电话</label>
                            <input name="shopphone" type="text" class="form-control" value="${(shop.phone)}"/>
                        </div>

                        <div class="form-group">
                            <label>商铺展示图</label>
                            <input name="shopdetails" type="file" class="form-control" multiple/>
                        </div>

                        <div class="form-group">
                            <label>商铺轮播图</label>
                            <input name="shopbanner" type="file" class="form-control" multiple/>
                        </div>
                        <input hidden type="text" name="userType" value="${userType}">
                        <input hidden type="text" name="shopId" value="${shopId}">
                        <input hidden type="text" name="details" value="${(shop.details)}">
                        <input hidden type="text" name="banners" value="${shop.banner}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>