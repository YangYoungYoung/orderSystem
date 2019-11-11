package com.ruoyi.system.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    Integer id;
    String orderId;
    Integer cid;
    Integer shopId;
    String openId;
    Integer tableId;
    //桌子名
    String tableName;
    //楼层名
    String floorName;
    //区域名
    Integer areaName;
    Integer dishId;
    Integer tableStatus;
    String dishName;
    Double dishPrice;
    String dishImage;
    Integer number;
    Double totalPrice;
    //订单状态  0: 未支付   1：已支付
    Integer status;
    //菜品状态  0: 已出单 1:正在做 2:已上菜 3:已退菜
    Integer dishStatus;
    Date orderTime;
    Date payTime;
    String remark;
    //是否删除  0: 未删除   1：已删除
    Integer isDelete;

    //是否已打印
    Integer isPrint;

}
