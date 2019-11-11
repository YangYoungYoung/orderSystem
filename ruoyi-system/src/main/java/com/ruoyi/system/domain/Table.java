package com.ruoyi.system.domain;

import lombok.Data;

@Data
public class Table {
    // 餐桌id
    Integer id;
    //店铺id
    Integer sid;
    //餐桌名
    String tableName;
    //状态
    Integer status;
    //楼层
    Integer floor;
    String floorName;
    //规格
    Integer specification;
    String specificationName;
    Double price;
    //区域
    Integer area;
    String areaName;
    //人数
    Integer population;

    Integer userType;
}
