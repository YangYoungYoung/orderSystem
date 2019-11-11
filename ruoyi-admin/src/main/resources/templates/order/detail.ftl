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
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>订单总金额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${orderDTO.orderId}</td>
                            <td>${orderDTO.orderAmount}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            <#--订单详情表数据-->
                <div class="col-md-12 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>菜品编号</th>
                            <th>菜品名称</th>
                            <th>菜品状态</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>总额</th>
                            <th>整改菜品状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderList as order>
                        <tr>
                            <td>${order.dishId}</td>
                            <td>${order.dishName}</td>
                            <#if order.dishStatus==0>
                                <td>已出单</td>
                                <#elseif order.dishStatus==1>
                                <td>制作中</td>
                                <#elseif order.dishStatus==2>
                                <td>已上菜</td>
                                <#else>
                                <td>已退菜</td>
                            </#if>
                            <td>${order.dishPrice}</td>
                            <td>${order.number}</td>
                            <td>${order.totalPrice}</td>
                            <#if order.dishStatus!=3>
                                <td>
                                    <form role="form" method="post" action="/order/updateDishStatus">
                                        <select name="dishStatus">
                                           <option value="0">已出单</option>
                                           <option value="1">制作中</option>
                                           <option value="2">已上菜</option>
                                           <option value="3">已退菜</option>
                                        </select>
                                        <input hidden type="text" name="orderId" value="${order.orderId}">
                                        <input hidden type="text" name="dishId" value="${order.dishId}">
                                        <input hidden type="text" name="userType" value="${userType}">
                                        <input hidden type="text" name="shopId" value="${shopId}">
                                        <button type="submit" class="btn btn-default">提交</button>
                                    </form>
                                </td>
                                <#else>
                                <td>已退菜，无法更改</td>
                            </#if>

                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <a href="/order/list?shopId=${shopId}&userType=${userType}" type="button" class="btn btn-default btn-primary">返回</a>
                </div>
            <#--操作-->
                <#--<div class="col-md-12 column">
                <#if orderDTO.getOrderStatusEnum().message == "新订单">
                    <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
                    <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
                </#if>
                </div>-->
            </div>
        </div>
    </div>
</div>

</body>
</html>