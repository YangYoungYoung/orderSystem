package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Shop;
import com.ruoyi.system.form.ShopFrom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {

    //添加商家
    Integer addShop(ShopFrom shopFrom);

    //修改店铺信息
    Integer updateShop(Shop shop);

    //查询商家列表
    List<Shop>  selectAll();

    //查看商家详情
    Shop shopDetails(Integer id);

    //删除商家
    Integer deleteShop(Integer id);

    List<Shop> Allselect(Integer shoppId);

    //展示商家信息*
    List<Shop>finselectshop(Integer shopId);

    //单个查询
    Shop finselectshopone(@Param("shopId") Integer shopId, @Param("shopName") String shopName);

    //更新
    Integer updateshops(ShopFrom shopFrom);

}
