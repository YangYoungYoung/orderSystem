package com.ruoyi.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.base.Result;
import com.ruoyi.system.domain.Dish;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.form.PriceForm;
import com.ruoyi.system.mapper.OrderMapper;
import com.ruoyi.system.mapper.TableMapper;
import com.ruoyi.system.service.BossService;
import com.ruoyi.system.service.IOrderService;
import com.ruoyi.system.service.TableService;
import com.ruoyi.system.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * 老板报表模块
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/boss")
public class BossController {

    @Autowired
    BossService bossService;

    @Autowired
    TableService tableService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    IOrderService orderService;

    @Autowired
    TableMapper tableMapper;

    @Autowired
    private UserService userService;


    /**
     * 当天收益
     * @param map
     * @return
     */
    @RequestMapping("/today")
    public ModelAndView selectpresent(@RequestParam("shopId") Integer shopId,
                                      @RequestParam("userType")Integer userType,
                                      Map<String,Object> map){
        Double price= bossService.selectpresent(shopId);
        if (price==null){
            price=0.00;
        }
        PriceForm priceForm=new PriceForm();
        priceForm.setPrice(price);
        map.put("shopId",shopId);
        map.put("userType",userType);
        map.put("priceForm",priceForm);
        return new ModelAndView ("/boss/today",map);
    }

    /**
     * 这周收益
     * @param map
     * @return
     */
    @RequestMapping("/week")
    public ModelAndView selectweek(@RequestParam("shopId") Integer shopId,
                                   @RequestParam("userType")Integer userType,
                                   Map<String,Object>map){
        Double price= bossService.selectweek(shopId);
        if (price==null){
            price=0.00;
        }
        PriceForm priceForm=new PriceForm();
        priceForm.setPrice(price);
        map.put("shopId",shopId);
        map.put("userType",userType);
        map.put("priceForm",priceForm);
        return new ModelAndView ("/boss/week",map);
    }

    /**
     * 当月收益
     * @param map
     * @return
     */
    @RequestMapping("/month")
    public ModelAndView selectmonth(@RequestParam("shopId") Integer shopId,
                                    @RequestParam("userType")Integer userType,
                                    Map<String,Object>map){
        Double price= bossService.selectmonth(shopId);
        if (price==null){
            price=0.00;
        }
        PriceForm priceForm=new PriceForm();
        map.put("shopId",shopId);
        priceForm.setPrice(price);
        map.put("userType",userType);
        map.put("priceForm",priceForm);
        return new ModelAndView ("/boss/month",map);
    }


    /**
     *@描述 跳转添加页面
     *@参数 null
     *@返回值
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("/bossskip")
    public ModelAndView skip(Map<String,Object>map){
        return new ModelAndView("/admin/userAdd",map);
    }


    /**
     *@描述 老板列表
     *@参数   usertype
     *@返回值  bossuserlist
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("/bossuserlist")
    public ModelAndView bosslins(Map<String,Object>map){
        List<User> userList=bossService.selectboss();
        map.put("userList",userList);
        return new ModelAndView("/admin/userList",map);

    }

    /**
     *@描述 添加老板账户
     *@参数  账户，密码，店铺id,权限
     *@返回值  bosslis
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("/insertBoss")
    public ModelAndView insertBoss(@RequestParam("userName")String userName,
                                   @RequestParam("password")String password,
                                   @RequestParam("shopId")Integer shopId,
                                   @RequestParam("usertype") Integer userType,
                                   Map<String,Object>map){
        Integer bossnub = userService.seleteOne(userName);
        if (bossnub == null){
            //账户添加
            Integer nub=userService.insertBoss(userName,password,shopId,userType);
            List<User> userList =userService.allfinboss(userType);
            map.put("userList",userList);
            return new ModelAndView("/admin/userList",map);
        }else {
            //以存在
            String url="/userList";
            int msg=200;
            map.put("url", url);
            map.put("msg",msg);
            return new ModelAndView("/common/error",map);
        }
    }

    /**
     * 修改老板账户单个查询数据渲染
     * @param userId
     * @param map
     * @return
     */
    @GetMapping("/oneboss")
    public ModelAndView Oneselete(@RequestParam("userId")Integer userId,
                                  Map<String,Object>map){
        User user=userService.finallboss(userId);
        map.put("user",user);
        return  new ModelAndView("/admin/userUpdate",map);
    }


    /**
     *@描述 修改boss账户
     *@参数   username，password,id
     *@返回值  bossLis
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("/updateBoss")
    public ModelAndView deleteOne(@RequestParam("userName")String userName,
                                  @RequestParam("password") String password,
                                  @RequestParam("userId") Integer userId,
                                  Map<String,Object>map){
        Integer nub= bossService.updateBoss(userName,password,userId);
        if(nub !=0){
            List<User>userList =bossService.selectboss();
            map.put("userList", userList);
            return new ModelAndView("/admin/userList",map);
        }else {
            //添加失败
            String url="/userList";
            int msg=200;
            map.put("url", url);
            map.put("msg",msg);
            return new ModelAndView("/common/error",map);
        }
    }


    /**
     * 删除老板账户
     * @param userId
     * @param map
     * @return
     */
    @RequestMapping("/deleteboss")
    public  ModelAndView deleteBoss(@RequestParam("userId") Integer userId,
                                    Map<String,Object>map){
        Integer nub = userService.deleteById(userId);
        if (nub !=0){
            List<User> userList = bossService.selectboss();
            map.put("userList", userList);
            return new ModelAndView("/admin/userList",map);
        }else {
            //添加失败
            String url="/userList";
            int msg=200;
            map.put("url", url);
            map.put("msg",msg);
            return new ModelAndView("/common/error",map);
        }

    }



    /**
     *@描述 查询服务员列表
     *@参数  shopId
     *@返回值
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("/selectUserList")
    public ModelAndView seleteUserList(@RequestParam("shopId")Integer shopId,
                                       @RequestParam("userType") Integer userType,
                                       Map<String,Object>map){
        List<User> userList=userService.seletewaitrt(shopId);
        map.put("userList",userList);
        map.put("userType",userType);
        map.put("shopId",shopId);
        return new ModelAndView("/boss/waiterlist",map);
    }


    /**
     *@描述 添加服务员账户跳转页面
     *@参数   userType（权限id）
     *@返回值  添加页面
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("/insertwaiter")
    public  ModelAndView bossskip(@RequestParam("userType")Integer userType,
                                  @RequestParam("shopId")Integer shopId,
                                  Map<String,Object> map){
        map.put("shopId",shopId);
        map.put("userType",userType);
        return new ModelAndView("/boss/userAdd",map);
    }


    /**
     *@描述 添加服务员方法
     *@参数    userName,password,userid,shopid,userType
     *@返回值
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("/seletwaiter")
    public ModelAndView insertwaiter(@RequestParam("userName")String userName,
                                     @RequestParam("password")String password,
                                     @RequestParam("shopId") Integer shopId,
                                     @RequestParam("userType") Integer userType,
                                     Map<String,Object>map){
        Integer nub = userService.seleteOne(userName);
        if ( nub == null){
            Integer nubce =userService.inswaiter(userName,password,shopId);
            List<User> userList= userService.seletewaitrt(shopId);
            map.put("userList",userList);
            map.put("shopId",shopId);
            map.put("userType",userType);
            return new ModelAndView("/boss/waiterlist",map);

        }else {
            String url="/boss/upskip";
            int msg=200;
            map.put("userType",userType);
            map.put("url", url);
            map.put("msg",msg);
            return new ModelAndView("/common/error",map);
        }

    }

    /**
     *@描述
     *@参数 修改跳转
     *@返回值
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("/upskip")
    public ModelAndView upskip(@RequestParam("userType") Integer userType,
                               @RequestParam("userId") Integer userId,
                               @RequestParam("shopId")Integer shopId,
                               Map<String,Object>map){
        User user=userService.finallboss(userId);
        map.put("user",user);
        map.put("userType",userType);
        map.put("userId",userId);
        map.put("shopId",shopId);
        return  new ModelAndView("/boss/userUpdate",map);
    }



    /**
     * 修改服务员账户密码
     * @param waitername   账户
     * @param waiterword    密码
     * @param userId        id
     * @param shopId        店铺id
     * @param map
     * @return
     */
    @RequestMapping("/updatemaiter")
    public ModelAndView updatemaiter(@RequestParam("userName")String waitername,
                                     @RequestParam("password")String waiterword,
                                     @RequestParam("userId")Integer userId,
                                     @RequestParam("shopId") Integer shopId,
                                     @RequestParam("userType") Integer userType,
                                     Map<String,Object>map){
        Integer backnub=userService.updatewaiter(waitername,waiterword,userId);
        if (backnub !=0){
            //修改成功
            List<User> userList = userService.seletewaitrt(shopId);
            map.put("userList", userList);
            map.put("userType", userType);
            map.put("shopId",shopId);
            return new ModelAndView("/boss/waiterlist",map);
        }else {
            //添加失败
            String url="/boss/upskip";
            int msg=200;
            map.put("msg", msg);
            map.put("url",url);
            return new ModelAndView("/common/error",map);
        }
    }


    /**
     *@描述 删除服务员账户
     *@参数  userId,shopId,usertype
     *@返回值
     *@创建人 C
     *@创建时间 2019/11/7
     *@修改人和其它信息
     */
    @RequestMapping("deletewaiter")
    public ModelAndView deletewaiter(@RequestParam("shopId") Integer shopId,
                                     @RequestParam("userId")Integer userId,
                                     @RequestParam("userType") Integer userType,
                                     Map<String,Object>map){
        Integer backnub=userService.deleteById(userId);
        if (backnub !=0){
            //删除成功
            List<User> userList=userService.seletewaitrt(shopId);
            map.put("userType",userType);
            map.put("shopId", shopId);
            map.put("userList", userList);
            return new ModelAndView("/boss/waiterlist",map);
        }else {
            //删除失败
            String url="/waiterlist";
            int msg=200;
            map.put("userType",userType);
            map.put("url" , url);
            map.put("msg" , msg);
            return new ModelAndView("/common/error",map);
        }

    }










    /**
     * @param request
     * @return 今日收益
     */
    @GetMapping("/selectAll")
    public Result selectAll(HttpServletRequest request) {
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        String startTime = request.getParameter("startTime")==null?null:request.getParameter("startTime");
        String endTime = request.getParameter("endTime")==null?null:request.getParameter("endTime");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("today", bossService.getEarningToday(shopId, startTime, endTime));
        jsonObject.put("hotList", orderMapper.dishHot(shopId,startTime,endTime));
        jsonObject.put("maxInCome", orderMapper.maxInCome(shopId,startTime,endTime));
        jsonObject.put("month", bossService.getEarningMonth(shopId, startTime, endTime));
        jsonObject.put("week", bossService.getEarningWeek(shopId, startTime, endTime));
        if (jsonObject.isEmpty()) {
            return new Result(203, "暂无收益");
        } else {
            return new Result(200, jsonObject, "收益统计信息已发送");
        }
    }


    /**
     * @param request
     * @return 今日收益
     */
    @GetMapping("/income/today")
    public Result incomeToday(HttpServletRequest request) {
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        String startTime = request.getParameter("startTime")==null?null:request.getParameter("startTime");
        String endTime = request.getParameter("endTime")==null?null:request.getParameter("endTime");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("today", bossService.getEarningToday(shopId, startTime, endTime));
        jsonObject.put("hotList", orderMapper.dishHot(shopId,startTime,endTime));
        jsonObject.put("totalTurnover", orderMapper.maxInCome(shopId,startTime,endTime));
        if (jsonObject.isEmpty()) {
            return new Result(203, "暂无收益");
        } else {
            return new Result(200, jsonObject, "当天收益");
        }
    }


    /**
     * 当月收益
     *
     * @param request
     * @return
     */
    @GetMapping("/income/month")
    public Result incomeMonth(HttpServletRequest request) {
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        String startTime = request.getParameter("startTime")==null?null:request.getParameter("startTime");
        String endTime = request.getParameter("endTime")==null?null:request.getParameter("endTime");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("today", bossService.getEarningToday(shopId, startTime, endTime));
        jsonObject.put("hotList", orderMapper.dishHotMonth(shopId,startTime,endTime));
        jsonObject.put("totalTurnover", orderMapper.maxInComeMonth(shopId,startTime,endTime));
        jsonObject.put("month", bossService.getEarningMonth(shopId, startTime, endTime));
        if (jsonObject.isEmpty()) {
            return new Result(203, "暂无收益");
        } else {
            return new Result(200, jsonObject, "当月收益");
        }

    }

    /**
     * 当周收益
     *
     * @param request
     * @return
     */
    @GetMapping("/income/week")
    public Result incomeyear(HttpServletRequest request) {
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        String startTime = request.getParameter("startTime")==null?null:request.getParameter("startTime");
        String endTime = request.getParameter("endTime")==null?null:request.getParameter("endTime");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("today", bossService.getEarningToday(shopId, startTime, endTime));
        jsonObject.put("hotList", orderMapper.dishHotWeek(shopId,startTime,endTime));
        jsonObject.put("totalTurnover", orderMapper.maxInComeWeek(shopId,startTime,endTime));
        jsonObject.put("week", bossService.getEarningWeek(shopId, startTime, endTime));
        if (jsonObject.isEmpty()) {
            return new Result(203, "暂无收益");
        } else {
            return new Result(200, jsonObject, "本周收益");
        }

    }

    /**
     * @param
     * @return 餐桌号与餐桌情况
     */
    @GetMapping("/table/status")
    public Result tableStatus(HttpServletRequest request) {
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        Integer floorId = Integer.parseInt(request.getParameter("floorId") == null ? "-1" : request.getParameter("floorId"));
        Integer speId = Integer.parseInt(request.getParameter("speId") == null ? "-1" : request.getParameter("speId"));
        Integer status = Integer.parseInt(request.getParameter("status") == null ? "-1" : request.getParameter("status"));
        Integer area = Integer.parseInt(request.getParameter("area") == null ? "-1" : request.getParameter("area"));

        net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
        jsonObject.put("specification", tableService.selectSpecification(shopId));
        jsonObject.put("floor", tableService.selectFloor(shopId));
        jsonObject.put("status", tableMapper.selectStatus());
        jsonObject.put("tableList", tableService.selectTable(shopId, floorId, speId, status, area));
        return new Result(200, jsonObject, "餐桌列表已发送");
    }

    /**
     * shopId 餐桌id
     * orderId 订单id
     *
     * @param
     * @return 订单（菜品名称，餐品单价，餐品数量）
     */
    @GetMapping("/table/current")
    public Result selectbalbeid(HttpServletRequest request) {
        Integer shopId = Integer.parseInt(request.getParameter(" shopId"));
        Integer tableId = Integer.parseInt(request.getParameter(" tableId"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderDetails", orderService.selectByTableId(shopId, tableId));
        return new Result(200, jsonObject, "订单详情");
    }


    /**
     * @param
     * @return 菜单卖出排行
     * （菜品名称、菜单单价、卖出数量、总收益）
     */
    @GetMapping("/dishHot")
    public Result dishHot(HttpServletRequest request) {
        //得到商户id
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        String startTime = request.getParameter("startTime")==null?null:request.getParameter("startTime");
        String endTime = request.getParameter("endTime")==null?null:request.getParameter("endTime");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("HotList", orderMapper.dishHot(shopId,startTime,endTime));
        if (jsonObject.equals("") || jsonObject == null) {
            return new Result(1, "网络错误");
        } else {
            return new Result(200, jsonObject, "菜品排行");
        }
    }

}
