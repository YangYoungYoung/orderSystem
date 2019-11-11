package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Shop;
import com.ruoyi.system.form.ShopFrom;
import com.ruoyi.system.mapper.ShopMapper;
import com.ruoyi.system.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopMapper shopMapper;


    @Override
    public Integer addShop(ShopFrom shop) {
        return shopMapper.addShop(shop);
    }

    @Override
    public Integer updateShop(Shop shop) {
        return shopMapper.updateShop(shop);
    }

    @Override
    public List<Shop> selectAll() {
        return shopMapper.selectAll();
    }

    @Override
    public Shop shopDetails(Integer id) {
        return shopMapper.shopDetails(id);
    }

    @Override
    public Integer deleteShop(Integer id) {
        return shopMapper.deleteShop(id);
    }
    @Override
    public List<Shop> Allselect(Integer shopId){
        return shopMapper.Allselect(shopId);
    }

    @Override
    public List<Shop> finselectshop(Integer shoppId){
        return shopMapper.finselectshop(shoppId);
    }

    @Override
    public Shop finselectshopone(Integer shopId,String shopName){
        return shopMapper.finselectshopone(shopId,shopName);
    }
    //更新数据
    @Override
    public  Integer updateshops(ShopFrom shopFrom){
        return shopMapper.updateshops(shopFrom);
    }
}
