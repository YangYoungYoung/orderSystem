package com.ruoyi.system.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ShopFrom {
    //id
    private Integer id;
    //店铺id
    private Integer shopId;
    //店铺名称
    private String shopName;
    //店铺头像
    private MultipartFile avatar;
    //店铺经度
    private String longitude;
    //店铺纬度
    private String latitude;
    //店铺地址
    private String shopaddress;
    //wifi密码
    private String shopwifi;
    //店铺手机号
    private String shopphone;
    //商铺展示图
    private List<MultipartFile> shopdetails;

    private String details;
    //商铺轮播图
   private  List<MultipartFile>  shopbanner;

   private String banners;
   //user类型
   private Integer userType;
    //机构号
    private String orgNo;
    //商家号
    private String mercId;
    //设备号
    private String  trmNo;
    //小程序appId
    private String appId;
    //小程序key值
    private String  secret;
}
