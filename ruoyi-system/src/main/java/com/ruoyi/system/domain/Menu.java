package com.ruoyi.system.domain;

import lombok.Data;

@Data
public class Menu {
    Integer id;
    Integer shopId;
    String  dishName;
    Integer typeId;
    Integer dishType;
    double dishPrice;
    String  dishImage;
    String dishTypeName;
    Integer number;
}
