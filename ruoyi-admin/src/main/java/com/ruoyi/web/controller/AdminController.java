package com.ruoyi.web.controller;

import com.ruoyi.common.base.AliOssUtil;
import com.ruoyi.system.domain.Shop;
import com.ruoyi.system.domain.TableArea;
import com.ruoyi.system.domain.TableFloor;
import com.ruoyi.system.domain.TableSpecification;
import com.ruoyi.system.form.*;
import com.ruoyi.system.service.ShopService;
import com.ruoyi.system.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Value("${oss.endpoint}")
    private String endpoint;

    @Value("${oss.accessId}")
    private String accessId;

    @Value("${oss.accessKey}")
    private String accessKey;

    @Value("${oss.bucket1}")
    private String bucket;

    @Autowired
    private ShopService shopService;

    @Autowired
    private TableService tableService;

    /**
     *查询全部数据
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<Shop>shopList=shopService.selectAll();
        Integer userType=0;
        map.put("userType",userType);
        map.put("shopList",shopList);
        return new ModelAndView("/admin/shopAdmin",map);
    }

    /**
     *单个查询数据填充
     * @param shopId
     * @param map
     * @return
     */
    @RequestMapping("/goUpdate")
    public ModelAndView fllshopc(@RequestParam("shopId")Integer shopId,
                                 @RequestParam("shopName")String shopName,
                                 Map<String,Object>map){
        Shop shop = shopService.finselectshopone(shopId,shopName);
        if (shop.getDetails()==null){
            shop.setDetails("");
        }
        if (shop.getBanner()==null){
            shop.setBanner("");
        }
        map.put("shopId",shopId);
        map.put("shop", shop);
        return new ModelAndView("/admin/update",map);
    }


    /**
     * 提交店铺信息更新
     * @param shopfrom
     * @param map
     * @return
     */
    @RequestMapping("/updateshop")
    public ModelAndView addshop(@Valid ShopFrom shopfrom,
                                Map<String,Object> map) throws IOException {
        int shopId=shopfrom.getShopId();
        String ossPath1="";
        String ossPath2="";
        List<MultipartFile> shopdetailsList=shopfrom.getShopdetails();
        if (shopdetailsList.size()!=0){
            for (MultipartFile file : shopdetailsList) {
                InputStream inputStream = file.getInputStream();
                String[] suffix = file.getOriginalFilename().split("\\.");
                int suffixIndex = suffix.length - 1;
                if (suffixIndex==0) {
                    continue;
                }
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
                if (suffixIndex==0) {
                    continue;
                }
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
        if(nub>0){
            List<Shop> shopList=shopService.selectAll();
            Integer userType=0;
            map.put("userType",userType);
            map.put("shopList",shopList);
            map.put("shopId",shopfrom.getShopId());
            return new ModelAndView ("/admin/shopAdmin",map);
        }else {
            String url="/shopAdmin";
            map.put("url",url);
            map.put("msg", 200);
            return new ModelAndView("common/error",map);
            //添加失败
        }
    }
    /**
     * 删除店铺信息
     * @param shopId
     * @param map
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("shopId")Integer shopId,
                               Map<String,Object>  map) {
        Integer result = shopService.deleteShop(shopId);
        //TODO 删除所有shop有关信息
        if (result > 0) {
            List<Shop> shopList = shopService.selectAll();
            Integer userType=0;
            map.put("userType",userType);
            map.put("shopList", shopList);
            return new ModelAndView("/admin/shopAdmin", map);
        } else {
            String url = "/shopAdmin";
            map.put("url", url);
            map.put("msg", 200);
            return new ModelAndView("common/error", map);
            //删除失败
        }
    }

    /**
     * 跳转添加店铺信息
     * @return
     */

    @GetMapping("/goAdd")
    public ModelAndView goAdd(){
        return new ModelAndView("admin/shopAdd");
    }

     /**
      * 添加店铺信息
      * @return
      */
    @PostMapping("/addShop")
    public ModelAndView addShop(@Valid ShopFrom shopfrom,
                                Map<String,Object> map) throws IOException {
        Integer result=shopService.addShop(shopfrom);
        if (result > 0) {
            List<Shop> shopList = shopService.selectAll();
            Integer userType=0;
            map.put("userType",userType);
            map.put("shopList", shopList);
            return new ModelAndView("/admin/shopAdmin", map);
        } else {
            String url = "/shopAdmin";
            map.put("url", url);
            map.put("msg", 200);
            return new ModelAndView("common/error", map);
            //删除失败
        }
    }

    /**
     * 跳转添加店铺楼层信息
     * @return
     */

    @GetMapping("/goAddFloor")
    public ModelAndView goAddFloor(@RequestParam("shopId") Integer shopId,
                                   Map<String,Object>map){
       map.put("shopId",shopId);
       return new ModelAndView("/admin/floorAdd",map);
    }

     /**
       * 添加店铺楼层信息
       * @return
     */

     @PostMapping("/addFloor")
     public ModelAndView addFloor(@Valid FloorForm floorForm,
                                  Map<String,Object>map){
         int result=tableService.addFloor(floorForm.getShopId(),floorForm.getFloor());
         if (result>0){
            List<Shop> shopList = shopService.selectAll();
             Integer userType=0;
             map.put("userType",userType);
            map.put("shopList", shopList);
            return new ModelAndView("/admin/shopAdmin", map);
         }   else {
                  String url = "/shopAdmin";
                  map.put("url", url);
                  map.put("msg", 200);
                  return new ModelAndView("common/error", map);
                  //添加失败
         }
     }

    /**
     * 跳转添加店铺桌位规格信息
     * @return
     */

    @GetMapping("/goAddspecification")
    public ModelAndView goAddspecification(@RequestParam("shopId")Integer shopId,
                                           Map<String,Object>map){
        map.put("shopId",shopId);
        return new ModelAndView("/admin/specification",map);
    }

    /**
      * 添加店铺桌位规格信息
      * @return
    */
    @PostMapping("/addSpecification")
    public ModelAndView addSpecification(@Valid SpecificationForm specificationForm,
                                         Map<String,Object>map){
        int result=tableService.addSpecification(specificationForm.getShopId(),specificationForm.getSpecification());
        if (result>0){
           List<Shop> shopList = shopService.selectAll();
            Integer userType=0;
            map.put("userType",userType);
           map.put("shopList", shopList);
           return new ModelAndView("/admin/shopAdmin", map);
        }   else {
                 String url = "/shopAdmin";
                 map.put("url", url);
                 map.put("msg", 200);
                 return new ModelAndView("common/error", map);
                 //添加失败
         }
    }

    /**
     * 跳转添加店铺桌位信息
     * @return
     */

      @GetMapping("/goAddTable")
      public ModelAndView addTable(@RequestParam("shopId")Integer shopId,
                                   Map<String,Object>map){
          List<TableFloor> tableFloorList=tableService.selectFloor(shopId);
          List<TableSpecification> tableSpecificationList=tableService.selectSpecification(shopId);
          List<AreaForm> tableAreaList=tableService.selectListArea();
          map.put("shopId",shopId);
          map.put("floors",tableFloorList);
          map.put("tableAreas",tableAreaList);
          map.put("specifications",tableSpecificationList);
          return new ModelAndView("/admin/tableAdd",map);
      }

       /**
        * 添加店铺桌位信息
        * @return
        */
        @PostMapping("/addTable")
        public ModelAndView goAddTable(@Valid TableForm tableForm,
                                       Map<String,Object>map){
            String tableName="";
            tableService.addArea(tableForm.getShopId(),tableForm.getFloorId(),tableForm.getAreaId());
            for (int i = 1; i <= tableForm.getNumber(); i++) {
                if (i<10){
                    tableName="00"+i;
                }else if (i>=10&&i<100)
                {
                    tableName="0"+i;
                }else {
                    tableName=""+i;
                }
               int result=tableService.addTable(tableForm.getShopId(),tableForm.getFloorId(),tableForm.getAreaId(),tableForm.getSpecificationId(),tableName) ;
                if (result<=0){
                       String url = "/shopAdmin";
                       map.put("url", url);
                       map.put("msg", 200);
                       return new ModelAndView("common/error", map);
                }
            }
              List<Shop> shopList = shopService.selectAll();
              Integer userType=0;
              map.put("userType",userType);
              map.put("shopList", shopList);
              return new ModelAndView("/admin/shopAdmin", map);     
      }
}
