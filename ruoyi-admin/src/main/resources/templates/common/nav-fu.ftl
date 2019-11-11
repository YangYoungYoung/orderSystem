<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                服务员管理系统
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
    </ul>
</nav>