package com.ruoyi.system.service;

import com.ruoyi.common.base.Result;
import com.ruoyi.system.domain.Order;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 打印服务层
 */
public class PrintService {

    @Autowired
    IOrderService orderService;

@GetMapping("/print")
    public Result print(String orderId,Integer shopId){
        List<Order> order = orderService.selectByOrderId(orderId,shopId);
        if (order.isEmpty()){
            return new Result(205,"该订单查无信息");
        }
        Double allPrice = 0.00;
        for (int i = 0; i < order.size(); i++) {
            Double price = order.get(i).getTotalPrice();
            allPrice += price;
        }
        List<Map<String, Object>> list = new ArrayList<>();
        for (Order or : order) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("orderId", or.getOrderId());
            map.put("dishId", or.getDishId());
            map.put("dishName", or.getDishName());
            map.put("dishImages", or.getDishImage());
            map.put("dishPrice", or.getDishPrice());
            map.put("number", or.getNumber());
            map.put("totalPrice", or.getTotalPrice());
            map.put("status", or.getDishStatus());
            list.add(map);
        }
        JSONArray jsonarr = JSONArray.fromObject(list);
        net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
        jsonObject.put("jsonArray", list);
        jsonObject.put("totalPrice", allPrice);
        return new Result(200, jsonObject, "成功");
    }
}
