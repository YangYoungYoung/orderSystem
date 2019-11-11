<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                boss管理系统
            </a>
        </li>
       <li>
            <a href="/order/list?shopId=${shopId}&userType=${userType}"><i class="fa fa-fw fa-list-alt"></i>订单</a>
        </li>
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <i class="fa fa-fw fa-plus"></i> 菜品管理 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="/menu/list?shopId=${shopId}&userType=${userType}">菜品列表</a></li>
                <li><a href="/menu/goAddMenu?shopId=${shopId}&userType=${userType}">新增菜品</a></li>
            </ul>
        </li>
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <i class="fa fa-fw fa-plus"></i> 菜品类目管理 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="/menu/findDishType?shopId=${shopId}&userType=${userType}">菜品类目列表</a></li>
                <li><a href="/menu/goAddDishType?shopId=${shopId}&userType=${userType}">新增菜品类目</a></li>
            </ul>
        </li>

        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <i class="fa fa-fw fa-plus"></i> 店铺管理 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="/shop/list?shopId=${shopId}&userType=${userType}">店铺信息</a></li>
                <li><a href="/table/fintablelist?shopId=${shopId}&userType=${userType}">座位管理</a></li>
            </ul>
        </li>
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <i class="fa fa-fw fa-plus"></i> 财务报表 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="/boss/today?shopId=${shopId}&userType=${userType}">今日报表</a></li>
                <li><a href="/boss/week?shopId=${shopId}&userType=${userType}">本周报表</a></li>
                <li><a href="/boss/month?shopId=${shopId}&userType=${userType}">本月报表</a></li>
            </ul>
        </li>
        <li>
           <a href="/boss/selectUserList?shopId=${shopId}&userType=${userType}"> <i class="fa fa-fw fa-plus"></i>
               服务员账号管理
           </a>
        </li>
        <#if userType==0>
            <a href="/admin/list?userType=${userType}">返回管理员模式</a>
        </#if>
    </ul>
</nav>