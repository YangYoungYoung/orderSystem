package com.ruoyi.system.form;

import lombok.Data;

/**
 * @创建人 陈
 * @创建时间 2019/11/8
 * @描述      桌子总信息
 */
@Data
public class TableGross {
    //桌子id
    Integer id;
    //店铺id
    Integer sid;
    //桌子名称
    String tableName;
    //规格
    String specificationName;
    //楼层
    Integer floor;
    //区域
    Integer area;
    //状态 0:空闲 1: 已开桌 2:用餐 3:待清理
    Integer status;
    //用餐人数
    Integer population;


}
