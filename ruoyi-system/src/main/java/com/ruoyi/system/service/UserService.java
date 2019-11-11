package com.ruoyi.system.service;

import com.ruoyi.system.domain.User;

import java.util.List;

public interface UserService {

    //查询用户列表
    List<User> findAll();

    //删除用户
    int deleteById(int userId);

    //添加用户
    int add(User user);

    //登录
    User selectUser(String userName, String password);


    //查询服务员账号列表
    List<User> seletewaitrt(Integer shopId);
    //单个查询
    Integer seleteOne(String waiterusername);
    //添加服务员账号
    Integer insertwaiter(String waitername, String waiterword, Integer shopId);
    //修改服务员账号密码
    Integer  updatewaiter(String waitername, String waiterword, Integer userId);
    //删除服务员账号密码
    Integer  deletewaiter(Integer userId);
    //添加老板
    Integer insertBoss(String userName, String password, Integer shopId, Integer userType);
    //查询老板账户
    List<User> allfinboss(Integer userType);
    //单个查询查询老板
    User finallboss(Integer userId);
    Integer finboss(String usernam,String password);
    //查询账户
    Integer insertwaiterone(String username);
    //*添加服务员
    Integer inswaiter(String userName,String password,Integer shopId);
}
