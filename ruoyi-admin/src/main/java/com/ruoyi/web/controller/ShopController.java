package com.ruoyi.web.controller;
import	java.util.concurrent.locks.ReentrantLock;

import com.ruoyi.common.base.AliOssUtil;
import com.ruoyi.common.base.Result;
import com.ruoyi.system.domain.Menu;
import com.ruoyi.system.domain.Shop;
import com.ruoyi.system.form.ShopFrom;
import com.ruoyi.system.service.ShopService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("shop")
public class ShopController {

    @Value("${oss.endpoint}")
    private String endpoint;

    @Value("${oss.accessId}")
    private String accessId;

    @Value("${oss.accessKey}")
    private String accessKey;

    @Value("${oss.bucket1}")
    private String bucket;


    @Autowired
    ShopService shopService;


    //后台接口

    /**
     * 店铺i信息
     *
     * @param shopId
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView fllshop(@RequestParam("shopId") Integer shopId,
                                @RequestParam("userType")Integer userType,
                                Map<String, Object> map) {
        List<Shop> shopList = shopService.finselectshop(shopId);
        map.put("userType",userType);
        map.put("shopList", shopList);
        map.put("shopId", shopId);
        return new ModelAndView("/shop/shopinformation", map);
    }

    /**
     * 单个查询数据填充
     *
     * @param shopId
     * @param map
     * @return
     */
    @RequestMapping("/updatelist")
    public ModelAndView fllshopc(@RequestParam("shopId") Integer shopId,
                                 @RequestParam("shopName") String shopName,
                                 @RequestParam("userType")Integer userType,
                                 Map<String, Object> map) {
        Shop shop = shopService.finselectshopone(shopId, shopName);
        map.put("userType",userType);
        map.put("shopId", shopId);
        map.put("shop", shop);
        return new ModelAndView("/shop/update", map);
    }

//----------------------------------------------------------------------------------------------------------------

    /**
     * 提交店铺信息更新
     *
     * @param shopfrom
     * @param map
     * @return
     */
    @RequestMapping("/addshop")
    public ModelAndView addshop(@Valid ShopFrom shopfrom,
                                Map<String, Object> map) throws IOException {
        int shopId=shopfrom.getShopId();
        String ossPath1="";
        String ossPath2="";
        List<MultipartFile> shopdetailsList=shopfrom.getShopdetails();
        if (shopdetailsList.size()!=0){
            for (MultipartFile file : shopdetailsList) {
                InputStream inputStream = file.getInputStream();
                String[] suffix = file.getOriginalFilename().split("\\.");
                int suffixIndex = suffix.length - 1;
                ossPath1 += AliOssUtil.uploadFile(inputStream, bucket, endpoint, accessId, accessKey,  "details"+"/"+shopId+"/"+new Date().getTime() + "." + suffix[suffixIndex])+";";
            }
        }else {
            ossPath1 += shopfrom.getDetails();
        }
        List<MultipartFile> shopbannerList=shopfrom.getShopbanner();
        if (shopbannerList.size()!=0){
            for (MultipartFile file : shopbannerList) {
                InputStream inputStream = file.getInputStream();
                String[] suffix = file.getOriginalFilename().split("\\.");
                int suffixIndex = suffix.length - 1;
                ossPath2  += AliOssUtil.uploadFile(inputStream, bucket, endpoint, accessId, accessKey,  "banner"+"/"+shopId+"/"+new Date().getTime() + "." + suffix[suffixIndex])+";";
            }
        }else {
            ossPath2 += shopfrom.getBanners();
        }
        Shop shop=new Shop();
        shop.setId(shopfrom.getShopId());
        shop.setName(shopfrom.getShopName());
        shop.setWifi(shopfrom.getShopwifi());
        shop.setPhone(shopfrom.getShopphone());
        shop.setLongitude(shopfrom.getLongitude());
        shop.setLatitude(shopfrom.getLatitude());
        shop.setAddress(shopfrom.getShopaddress());
        shop.setDetails(ossPath1);
        shop.setBanner(ossPath2);
        Integer nub = shopService.updateShop(shop);
        if (nub > 0) {
            List<Shop> shopList = shopService.finselectshop(shopfrom.getShopId());
            map.put("userType",shopfrom.getUserType());
            map.put("shopList", shopList);
            map.put("shopId", shopfrom.getShopId());
            return new ModelAndView("/shop/shopinformation", map);
        } else {
            String url = "shop/shopinformation";
            map.put("url", url);
            map.put("msg", 200);
            return new ModelAndView("common/error", map);
            //添加失败
        }
    }







    //----------------------------------------------------------------------------------------------------------

    /**
     * 查询商家列表
     *
     * @return
     */
    @GetMapping("selectAll")
    public Result selectAll() {
        List<Shop> shopList = shopService.selectAll();
        if (shopList.isEmpty()) {
            return new Result(202, "尚未接入商家");
        }
        List<Map<String, Object>> list = new ArrayList<>();
        for (Shop shop : shopList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", shop.getId());
            map.put("name", shop.getName());
            map.put("avatar", shop.getAvatar());
            map.put("address", shop.getAddress());
            map.put("wifi", shop.getWifi());
            map.put("phone", shop.getPhone());
            map.put("longitude", shop.getLongitude());
            map.put("latitude", shop.getLatitude());
            list.add(map);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        return new Result(200, jsonArray, "商家列表已发送");
    }

    /**
     * 查询商家列表
     *
     * @return
     */
    @GetMapping("shopDetails")
    public Result shopDetails(HttpServletRequest request) {
        Integer shopid = Integer.parseInt(request.getParameter("shopId"));
        Shop shop = shopService.shopDetails(shopid);
        if (StringUtils.isEmpty(shop)) {
            return new Result(202, "未查询到该商家信息");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id", shop.getId()==null?"":shop.getId());
        map.put("name", shop.getName()==null?"":shop.getName());
        map.put("avatar", shop.getAvatar()==null?"":shop.getAvatar());
        map.put("address", shop.getAddress()==null?"":shop.getAddress());
        map.put("wifi", shop.getWifi()==null?"":shop.getWifi());
        map.put("phone", shop.getPhone()==null?"":shop.getPhone());
        map.put("longitude", shop.getLongitude()==null?"":shop.getLongitude());
        map.put("latitude", shop.getLatitude()==null?"":shop.getLatitude());
        map.put("details", shop.getDetails().split(";")==null?"":shop.getDetails().split(";"));
        map.put("banner", shop.getBanner().split(";")==null?"":shop.getBanner().split(";"));
        map.put("orgNo",shop.getOrgNo()==null?"":shop.getOrgNo());
        map.put("mercId",shop.getMercId()==null?"":shop.getMercId());
        map.put("trmNo",shop.getTrmNo()==null?"":shop.getTrmNo());
        return new Result(200, JSONObject.fromObject(map), "商家详情已发送");
    }

    /**
     * 删除商家
     *
     * @param request
     * @return
     */
    @GetMapping("delete")
    public Result deleteShop(HttpServletRequest request) {
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        if (shopService.deleteShop(shopId) > 0) {
            return new Result(200, "删除成功");
        } else {
            return new Result(203, "删除失败");
        }
    }

}
