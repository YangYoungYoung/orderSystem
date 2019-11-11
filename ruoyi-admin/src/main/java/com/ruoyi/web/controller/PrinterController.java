package com.ruoyi.web.controller;

import com.ruoyi.common.base.Result;
import com.ruoyi.common.base.StringToObject;
import com.ruoyi.common.base.print.Config;
import com.ruoyi.common.base.print.Request;
import com.ruoyi.system.domain.Order;
import com.ruoyi.system.mapper.TableMapper;
import com.ruoyi.system.service.IOrderService;
import com.ruoyi.system.service.ShopService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

//佳博云打印机API接口
//文档地址 ： http://cloud.poscom.cn/index.php?catid=18
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/print")
public class PrinterController {

    @Autowired
    ShopService shopService;

    @Autowired
    IOrderService orderService;

    @Autowired
    TableMapper tableMapper;


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat mon = new SimpleDateFormat("yyyy-MM");


    /**
     * 获取打印机状态
     * online
     * 0	离线。
     * 1	在线。
     * status
     * 1 正常 2 缺纸 3 其他异常 4 过热 5 开盖 8 暂停 9 打印中
     *
     * @return
     */
    @GetMapping("/getStatus")
    public String getStatus() {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);
        params.put("deviceID", Config.receiptDeviceNo);

        System.out.println("=====请求参数 START=====\r\n" + "---> getStatus <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendPost("http://api.poscom.cn/apisc/getStatus", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }

    /**
     * 以订单Id打印全部数据
     * <p>
     * 0	正常。
     * -1	IP 地址不允许。
     * -2	关键参数为空或请求方式不对。
     * -3	客户编码不对。
     * -4	安全校验码不正确。
     * -5	请求时间失效。
     * -6	订单内容格式不对。
     * -7	消息号（msgNo）重复。
     * -8	消息模式不对。
     * -9	服务器错误。
     * -10	服务器内部错误。
     * -111	使用的佳博云打印机不属于该账户。
     *
     * @return
     */
    @GetMapping("/sendMsgAll")
    public Result SendMsgToReceiptAll(HttpServletRequest request) {

        String orderId = request.getParameter("orderId");
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);
        params.put("deviceID", Config.receiptDeviceNo);

        System.out.println("=====请求参数 START=====\r\n" + "---> getStatus <---\r\n" + params + "\r\n=====请求参数 END=====");

        String str = Request.sendPost("http://api.poscom.cn/apisc/getStatus", params);

        System.out.println("=====请求返回 START=====\r\n" + str + "\r\n=====请求返回 END=====");

        JSONObject jsonObject = JSONObject.fromObject(Request.sendPost("http://api.poscom.cn/apisc/getStatus", params));
        JSONObject json = JSONObject.fromObject(jsonObject.getString("statusList").replaceAll("[\\[\\]]", ""));

        /**
         * 获取打印机状态
         * online
         * 0	离线。
         * 1	在线。
         * status
         * 1 正常 2 缺纸 3 其他异常 4 过热 5 开盖 8 暂停 9 打印中
         *
         * @return
         */

        if (Integer.parseInt(json.getString("online")) == 0) {
            return new Result(205, "打印机已离线,请联系服务员");
        }
        if (Integer.parseInt(json.getString("status")) != 1) {
            String msg = null;
            switch (Integer.parseInt(json.getString("status"))) {
                case 2:
                    msg = "缺纸";
                    break;
                case 3:
                    msg = "其他异常";
                    break;
                case 4:
                    msg = "过热";
                    break;
                case 5:
                    msg = "开盖";
                    break;
                case 8:
                    msg = "暂停";
                    break;
                case 9:
                    msg = "打印中";
                    break;
            }
            return new Result(205, "打印机" + str + ",请联系服务员");
        }

        //============================================================================
        Map<String, String> params1 = new HashMap<String, String>();

        String reqTime1 = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params1.put("reqTime", reqTime1);

        String securityCode1 = DigestUtils.md5Hex(Config.memberCode + Config.receiptDeviceNo + reqTime1 + reqTime1 + Config.apiKey);
        params1.put("securityCode", securityCode1);

        params1.put("memberCode", Config.memberCode);
        params1.put("deviceID", Config.receiptDeviceNo);

        //-----票据打印机 格式类型:2
        params1.put("mode", "2");

        //Todo
        List<Order> orderList = orderService.selectByOrderId(orderId, shopId);

        //票据的模板
        StringBuffer ReceiptData2 = new StringBuffer();
        ReceiptData2.append("<gpWord Align=0 Bold=1 Wsize=1 Hsize=1 Reverse=0 Underline=0>桌 号:" + orderList.get(0).getTableName() + "</gpWord>\r\n");
        ReceiptData2.append("<gpWord Align=0 Bold=0 Wsize=0 Hsize=0 Reverse=0 Underline=0>订单号:" + orderList.get(0).getOrderId() + "</gpWord>\r\n");
        ReceiptData2.append("<gpWord Align=0 Bold=0 Wsize=0 Hsize=0 Reverse=0 Underline=0>下单时间:" + sdf.format(orderList.get(0).getOrderTime()) + "</gpWord>\r\n");
        ReceiptData2.append("<gpTR2 Type=0><td>菜单名称</td><td>数量</td></gpTR2>");
        ReceiptData2.append("<gpBr/>");
        for (Order order : orderList) {
            ReceiptData2.append("<gpTR2 Type=0><td>" + order.getDishName() + "</td><td>" + order.getNumber() + "</td></gpTR2>");
        }
        ReceiptData2.append("<gpCut/>");
        ReceiptData2.append("<gpBr/>");
        ReceiptData2.append("<gpBr/>");
        params1.put("msgDetail", ReceiptData2.toString());
        params1.put("charset", "1"); //Default:1, 1:GB18030, 2:GB2312, 3:GBK, 4:UTF-8, 5:Unicode, 6:ISO8859-1, 7:BIG5
        params1.put("msgNo", reqTime1);

        System.out.println("=====请求参数 START=====\r\n" + "---> sendMsg <---\r\n" + params1 + "\r\n=====请求参数 END=====");
        String result = Request.sendPost("http://api.poscom.cn/apisc/sendMsg", params1);
        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        if (Integer.parseInt(JSONObject.fromObject(result).getString("code"))==0) {
            //修改订单为已打印状态
            orderService.printEcho(orderId, shopId);
            //批量修改菜品状态为正在做
            orderService.changeStatusByOrderId(1,shopId,orderId);
        return new Result(200, result);
        } else {
            return new Result(206, JSONObject.fromObject(result).getString("msg"));
        }
    }


    /**
     * 通过菜品对象(数组)打印部分订单
     * <p>
     * 0	正常。
     * -1	IP 地址不允许。
     * -2	关键参数为空或请求方式不对。
     * -3	客户编码不对。
     * -4	安全校验码不正确。
     * -5	请求时间失效。
     * -6	订单内容格式不对。
     * -7	消息号（msgNo）重复。
     * -8	消息模式不对。
     * -9	服务器错误。
     * -10	服务器内部错误。
     * -111	使用的佳博云打印机不属于该账户。
     *
     * @return
     */
//    @PostMapping("/sendMsgPart")
    public Result SendMsgToReceipt(List<Order> orderList,String orderId,Integer shopId,Integer tableId,Integer type) {

//        com.alibaba.fastjson.JSONObject jsonObject1 = StringToObject.StringToJSon(request);
//        List<Order> orderList = (List<Order>) JSONArray.toList(JSONArray.fromObject(jsonObject1.getString("dishArray")), Order.class);
//        Integer type=Integer.parseInt(jsonObject1.getString("type"));
//        String orderId = request.getParameter("orderId");
//        Integer shopId = Integer.parseInt(request.getParameter("shopId"));

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);
        params.put("deviceID", Config.receiptDeviceNo);

        System.out.println("=====请求参数 START=====\r\n" + "---> getStatus <---\r\n" + params + "\r\n=====请求参数 END=====");

        String str = Request.sendPost("http://api.poscom.cn/apisc/getStatus", params);

        System.out.println("=====请求返回 START=====\r\n" + str + "\r\n=====请求返回 END=====");

        JSONObject jsonObject = JSONObject.fromObject(Request.sendPost("http://api.poscom.cn/apisc/getStatus", params));
        JSONObject json = JSONObject.fromObject(jsonObject.getString("statusList").replaceAll("[\\[\\]]", ""));

        /**
         * 获取打印机状态
         * online
         * 0	离线。
         * 1	在线。
         * status
         * 1 正常 2 缺纸 3 其他异常 4 过热 5 开盖 8 暂停 9 打印中
         *
         * @return
         */

        if (Integer.parseInt(json.getString("online")) == 0) {
            return new Result(205, "打印机已离线,请联系服务员");
        }
        if (Integer.parseInt(json.getString("status")) != 1) {
            String msg = null;
            switch (Integer.parseInt(json.getString("status"))) {
                case 2:
                    msg = "缺纸";
                    break;
                case 3:
                    msg = "其他异常";
                    break;
                case 4:
                    msg = "过热";
                    break;
                case 5:
                    msg = "开盖";
                    break;
                case 8:
                    msg = "暂停";
                    break;
                case 9:
                    msg = "打印中";
                    break;
            }
            return new Result(205, "打印机" + str + ",请联系服务员");
        }

        //============================================================================
        Map<String, String> params1 = new HashMap<String, String>();

        String reqTime1 = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params1.put("reqTime", reqTime1);

        String securityCode1 = DigestUtils.md5Hex(Config.memberCode + Config.receiptDeviceNo + reqTime1 + reqTime1 + Config.apiKey);
        params1.put("securityCode", securityCode1);

        params1.put("memberCode", Config.memberCode);
        params1.put("deviceID", Config.receiptDeviceNo);

        //-----票据打印机 格式类型:2
        params1.put("mode", "2");

        //Todo
        //票据的模板
        StringBuffer ReceiptData2 = new StringBuffer();
        if (type==1) {
            ReceiptData2.append("<gpWord Align=0 Bold=1 Wsize=1 Hsize=1 Reverse=0 Underline=0>加  菜  单</gpWord>\r\n");
            ReceiptData2.append("<gpWord Align=0 Bold=1 Wsize=1 Hsize=1 Reverse=0 Underline=0>桌 号:" + tableMapper.gettableName(tableId) + "</gpWord>\r\n");
            ReceiptData2.append("<gpWord Align=0 Bold=0 Wsize=0 Hsize=0 Reverse=0 Underline=0>订单号:" + orderId + "</gpWord>\r\n");
            ReceiptData2.append("<gpWord Align=0 Bold=0 Wsize=0 Hsize=0 Reverse=0 Underline=0>下单时间:" + sdf.format(new Date()) + "</gpWord>\r\n");
            ReceiptData2.append("<gpTR2 Type=0><td>菜单名称</td><td>数量</td></gpTR2>");
            ReceiptData2.append("<gpBr/>");
            for (Order order : orderList) {
                ReceiptData2.append("<gpTR2 Type=0><td>" + order.getDishName() + "</td><td>" + order.getNumber() + "</td></gpTR2>");
            }
            ReceiptData2.append("<gpCut/>");
            ReceiptData2.append("<gpBr/>");
            ReceiptData2.append("<gpBr/>");
        }else{
            ReceiptData2.append("<gpWord Align=0 Bold=1 Wsize=1 Hsize=1 Reverse=0 Underline=0>退  菜  单</gpWord>\r\n");
            ReceiptData2.append("<gpWord Align=0 Bold=1 Wsize=1 Hsize=1 Reverse=0 Underline=0>桌 号:" + tableMapper.gettableName(tableId) + "</gpWord>\r\n");
            ReceiptData2.append("<gpWord Align=0 Bold=0 Wsize=0 Hsize=0 Reverse=0 Underline=0>订单号:" + orderId + "</gpWord>\r\n");
            ReceiptData2.append("<gpWord Align=0 Bold=0 Wsize=0 Hsize=0 Reverse=0 Underline=0>下单时间:" + sdf.format(new Date()) + "</gpWord>\r\n");
            ReceiptData2.append("<gpTR2 Type=0><td>菜单名称</td><td>数量</td></gpTR2>");
            ReceiptData2.append("<gpBr/>");
            for (Order order : orderList) {
                ReceiptData2.append("<gpTR2 Type=0><td>" + order.getDishName() + "</td><td>" + order.getNumber() + "</td></gpTR2>");
            }
            ReceiptData2.append("<gpCut/>");
            ReceiptData2.append("<gpBr/>");
            ReceiptData2.append("<gpBr/>");
        }
        params1.put("msgDetail", ReceiptData2.toString());
        params1.put("charset", "1"); //Default:1, 1:GB18030, 2:GB2312, 3:GBK, 4:UTF-8, 5:Unicode, 6:ISO8859-1, 7:BIG5
        params1.put("msgNo", reqTime1);

        System.out.println("=====请求参数 START=====\r\n" + "---> sendMsg <---\r\n" + params1 + "\r\n=====请求参数 END=====");
        String result = Request.sendPost("http://api.poscom.cn/apisc/sendMsg", params1);
        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        if (Integer.parseInt(JSONObject.fromObject(result).getString("code"))==0) {
            for(Order order:orderList){
                orderService.printEchoPart(order.getDishId(),orderId, shopId);
                if (type==1) {
                    //如果是加菜,修改菜品状态为正在做
                    orderService.changeStatusByOrderIdAndDishId(1, shopId,order.getDishId(),orderId);
                }
            }
             return new Result(200, result);
        } else {
            return new Result(206, JSONObject.fromObject(result).getString("msg"));
        }
    }


    /**
     * 打印回调
     *
     * @param request
     * @return
     */
    @GetMapping("/printEcho")
    public Result printEcho(HttpServletRequest request) {
        String orderId = request.getParameter("orderId");
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        Integer rows = orderService.printEcho(orderId, shopId);
        if (rows > 0) {
            return new Result(200, "订单打印状态修改成功");
        } else {
            return new Result(202, "订单打印状态修改失败");
        }
    }

    /**
     * 打印未打印订单
     *
     * @param request
     * @return
     */
    @GetMapping("/isPrint")
    public Result isPrint(HttpServletRequest request) {
        String orderId = request.getParameter("orderId");
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        Integer rows = orderService.findNewOrder(shopId);
        if (rows > 0) {
            return new Result(200, "订单打印状态修改成功");
        } else {
            return new Result(202, "订单打印状态修改失败");
        }
    }


    /**
     * 查看打印机任务状态
     * msgNo           订单编号
     * memberCode      商家编码
     *
     * @return
     */
    @GetMapping("/querystate")
    public static String querystate(String msgNo) {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey + msgNo);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);

        params.put("msgNo", msgNo);

        System.out.println("=====请求参数 START=====\r\n" + "---> queryState <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendGet("http://api.poscom.cn/apisc/queryState", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }


    /**
     * 添加终端（绑定打印机到平台）
     *
     * @return
     */
    public String addDev() {
        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey + Config.receiptDeviceNo);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);

        params.put("deviceID", Config.receiptDeviceNo);
        params.put("devName", "DeviceName");

        params.put("grpID", "1");
        params.put("mPhone", "1388888888");
        params.put("nPhone", "1388888888");
        params.put("cutting", "0");

        System.out.println("=====请求参数 START=====\r\n" + "---> adddev <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendPost("http://api.poscom.cn/apisc/adddev", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }

    /**
     * 删除终端
     *
     * @return
     */
    public String delDev() {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey + Config.receiptDeviceNo);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);

        params.put("deviceID", Config.receiptDeviceNo);

        System.out.println("=====请求参数 START=====\r\n" + "---> deldev <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendPost("http://api.poscom.cn/apisc/deldev", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }



    /**
     * 添加打印机分组
     *
     * @return
     */
    public String addGroup() {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);

        params.put("grpName", "GroupName");

        System.out.println("=====请求参数 START=====\r\n" + "---> addgroup <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendPost("http://api.poscom.cn/apisc/addgroup", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;

    }


    /**
     * 删除打印机分组
     *
     * @return
     */
    public String delGroup() {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey + "1");
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);

        params.put("grpID", "1");

        System.out.println("=====请求参数 START=====\r\n" + "---> delgroup <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendPost("http://api.poscom.cn/apisc/delgroup", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }


    /**
     * 查询账号下已添加的打印机信息。
     *
     * @return
     */
    public String device() {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey + Config.receiptDeviceNo);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);
        params.put("deviceID", Config.receiptDeviceNo);

        System.out.println("=====请求参数 START=====\r\n" + "---> device <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendPost("http://api.poscom.cn/apisc/device", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }

    /**
     * 修改打印机信息
     *
     * @return
     */
    public String editDev() {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey + Config.receiptDeviceNo);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);

        params.put("deviceID", Config.receiptDeviceNo);
        params.put("devName", "DeviceName");

        params.put("grpID", "1");
        params.put("mPhone", "1399999999");
        params.put("nPhone", "1399999999");
        params.put("cutting", "1");

        System.out.println("=====请求参数 START=====\r\n" + "---> editdev <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendPost("http://api.poscom.cn/apisc/editdev", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }

    /**
     * 修改打印机分组信息
     *
     * @return
     */
    public String editGroup() {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey + "1");
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);

        params.put("grpID", "1");
        params.put("grpName", "GroupName");

        System.out.println("=====请求参数 START=====\r\n" + "---> editgroup <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendPost("http://api.poscom.cn/apisc/editgroup", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }


    /**
     * 查看打印机异常信息
     * start  yyyy-MM-dd  开始时间
     * end    yyyy-MM-dd  开始时间
     *
     * @return
     */
    public String listException() {

        Map<String, String> params = new HashMap<String, String>();

        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        params.put("reqTime", reqTime);

        String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey);
        params.put("securityCode", securityCode);

        params.put("memberCode", Config.memberCode);
        params.put("deviceID", Config.receiptDeviceNo);

        params.put("start", Request.getPastDate(7));
        params.put("end", Request.getPastDate(0));

        System.out.println("=====请求参数 START=====\r\n" + "---> listException <---\r\n" + params + "\r\n=====请求参数 END=====");

        String result = Request.sendGet("http://api.poscom.cn/apisc/listException", params);

        System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");

        return result;
    }


}
