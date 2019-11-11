package com.ruoyi.system.service;


import com.ruoyi.system.domain.Order;
import org.omg.CORBA.INTERNAL;


import java.util.Date;
import java.util.List;

public interface IOrderService {


    //生成订单
    int addNew(Order order);

    //更改订单的下单时间
    Integer updateOrderTime(Integer shopId, String orderId, Date orderTime);

    List<Order> selectByOrderId(String orderId, Integer shopId);

    List<Order> selectDesc(String openId, Integer shopId);

    List<Order> getList(String openId, Integer sid);

    int deleteByTableId(Integer tableId, Integer sid);

    int updateStatusAndPayTime(Integer shopId, String orderId ,Date payTime);

    //以订单Id修改全部的状态
    Integer changeStatusByOrderId(Integer status, Integer shopId, String orderId);

    //单个修改订单状态
    Integer changeStatusByOrderIdAndDishId(Integer status, Integer shopId, Integer dishId, String orderId);

    //查看订单的状态
    List<Order> selectStatus(String orderId, Integer shopId);


    //以餐桌id查看当前的订单
    List<Order> selectByTableId(Integer shopId,Integer tableId);

    //通过orderId给某一订单加菜加菜
    Integer addDish(Order order);

    //通过tableId获取orderId
   String  getOrderIdByTableId(Integer tableId,Integer shopId);
    /**
     * 查询所有
     *
     * @return
     */
    List<Order> findAll(Integer shopId);

    /**
     * 取消订单
     */
    Integer deleteorder(Integer orderId);

    /**
     * 查看是否有新订单
     * @return
     */
    Integer findNewOrder(Integer shopId);

    //修改菜品订单状态
    Integer updateDishStatus(Integer dishStatus,Integer id);

    //打印回调(全部)
    Integer printEcho(String orderId, Integer shopId);

    //打印回调(部分)
    Integer printEchoPart(Integer dishId,String orderId, Integer shopId);
}
