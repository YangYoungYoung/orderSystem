package com.ruoyi.system.form;

import lombok.Data;

@Data
public class StatusForm {

    private Integer tableId;

    private Integer tableStatus;

    private Integer dishId;

    //订单id
    private Integer id;

    private Integer shopId;

    private Integer userType;

    private String orderId;

    private Integer dishStatus;

    private Integer population;
}
