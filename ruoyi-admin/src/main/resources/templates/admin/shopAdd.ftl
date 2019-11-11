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
                    <form role="form" method="post" action="/admin/addShop" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>店铺名称</label>
                            <input name="shopName" type="text" class="form-control" />
                        </div>
                       <#-- <div class="form-group">
                            <label>店铺头像</label>
                            <input name="avatar" type="file" class="form-control" />
                        </div>-->
                        <div class="form-group">
                            <label>商铺地址</label>
                            <input name="shopaddress" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>商铺WiFi</label>
                            <input name="shopwifi" type="text" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>商铺电话</label>
                            <input name="shopphone" type="text" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>店铺经度</label>
                            <input name="longitude" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>商铺纬度</label>
                            <input name="latitude" type="text" class="form-control" />
                        </div>
                        <#--<div class="form-group">
                            <label>商铺展示图</label>
                            <input name="shopdetails" type="file" class="form-control" multiple/>
                        </div>
                        <div class="form-group">
                            <label>商铺轮播图</label>
                            <input name="shopbanner" type="file" class="form-control" multiple/>
                        </div>-->
                        <div class="form-group">
                            <label>机构号</label>
                            <input name="orgNo" type="text" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>商家号</label>
                            <input name="mercId" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>设备号</label>
                            <input name="trmNo" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>appId</label>
                            <input name="appId" type="text" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>secret</label>
                            <input name="secret" type="text" class="form-control"/>
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