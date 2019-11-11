package com.ruoyi.web.controller;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import com.ruoyi.common.base.Result;
import com.ruoyi.common.base.StringToObject;
import com.ruoyi.system.domain.Order;
import com.ruoyi.system.domain.Shop;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.form.PriceForm;
import com.ruoyi.system.form.UserForm;
import com.ruoyi.system.mapper.UserMapper;
import com.ruoyi.system.service.BossService;
import com.ruoyi.system.service.IOrderService;
import com.ruoyi.system.service.ShopService;
import com.ruoyi.system.service.UserService;

import com.ruoyi.web.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private BossService bossService;

    @Autowired
    UserMapper userMapper;

    //go登陆页面
    @GetMapping("/go")
    public ModelAndView go(){
        return new ModelAndView("/index/login");
    }

//    //go登陆页面
//    @GetMapping("/go")
//    public Result go(){
//        return new Result(200,"/index/login");
//    }



    //验证用户身份 跳转页面（跳到微信端）
    @PostMapping("/skip")
    public Result skip(HttpServletRequest request,
                               Map<String,Object> map){
        JSONObject json= StringToObject.StringToJSon(request);
        if(userMapper.selectName(json.getString("userName"))<=0){
            return new Result(202,"该用户不存在");
        }
        User alluser=userService.selectUser(json.getString("userName"),json.getString("password"));
        if (alluser==null){
            return new Result(202,"密码错误");
        }else {
            net.sf.json.JSONObject jsonObject=new net.sf.json.JSONObject();
            jsonObject.put("alluser",alluser);
            return new Result(200,jsonObject,"成功");
        }

    }




        //验证用户身份 跳转页面
   @PostMapping("/skips")
                 public ModelAndView skip(@Valid UserForm userform,
                                          Map<String,Object> map,
                                          HttpSession session){
         List<User> userList=userService.findAll();
        for (User user : userList) {
            if (user.getUserName().equals(userform.getUserName())&&user.getPassword().equals(userform.getPassword())){
                if (user.getUserType()==2){
                    //服务员账号登录
                    //跳转服务员管理界面（显示订单）
                    List<Order> orderList=orderService.findAll(user.getSid());
                    map.put("orderList",orderList);
                    map.put("shopId",user.getSid());
                    map.put("userType",user.getUserType());
                    session.setAttribute("shopId",user.getSid());
                    return new ModelAndView("order/list",map);
                } else if (user.getUserType()==1){
                    Double price= bossService.selectpresent(user.getSid());
                    if (price==null){
                        price=0.00;
                    }
                    PriceForm priceForm=new PriceForm();
                    priceForm.setPrice(price);
                    map.put("shopId",user.getSid());
                    map.put("priceForm",priceForm);
                    map.put("userType",user.getUserType());
                    session.setAttribute("shopId",user.getSid());
                    return new ModelAndView("/boss/today",map);
                }else {
                    List<Shop>shopList=shopService.selectAll();
                    map.put("userType",user.getUserType());
                    map.put("shopList",shopList);
                    return new ModelAndView("/admin/shopAdmin",map);
                }
            }
        }
        String url="go";
        String msg="账号密码有误";
        map.put("msg",msg);
        map.put("url",url);
        return new ModelAndView("/common/error",map);
    }
}
