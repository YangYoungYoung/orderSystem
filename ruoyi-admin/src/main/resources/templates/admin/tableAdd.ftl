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
                    <form role="form" method="post" action="/admin/addTable">
                        <div class="form-group">
                            <label>楼层</label>
                            <select name="floorId">
                                <#list floors as floor>
                                    <option value="${floor.id}">${floor.floor}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>区域</label>
                            <select name="areaId">
                                <#list tableAreas as tableArea>
                                    <option value="${tableArea.id}">${tableArea.area}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>桌子规格</label>
                           <select name="specificationId">
                               <#list specifications as specification>
                                   <option value="${specification.id}">${specification.specification}</option>
                               </#list>
                           </select>
                        </div>
                        <div class="form-group">
                            <label>桌子数量</label>
                            <input name="number" type="text" class="form-control"/>
                        </div>
                        <input hidden type="text" name="shopId" value="${shopId}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>