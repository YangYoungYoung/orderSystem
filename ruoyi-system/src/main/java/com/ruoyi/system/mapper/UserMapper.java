package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //查询用户列表
    List<User> findAll();

    //删除用户
    int deleteById(int userId);

    //添加用户
    int add(User user);

    //验证账户密码
    User selectUser(@Param("userName") String userName, @Param("password") String password);



    //查询服务员账号密码
    List<User> seletewaitrt(Integer shopId);
    //添加服务员账号密码
    Integer insertwaiter(@Param("userName") String  userName,
                         @Param("password") String password,
                         @Param("shopId") Integer shopId);
    //修改服务员账号密码
    Integer  updatewaiter(@Param("waitername") String waitername,
                          @Param("waiterword") String waiterword,
                          @Param("userId") Integer shopId);
    //删除服务员账号密码
    Integer  deletewaiter(@Param("userId") Integer shopId);
    //单个查询
    Integer  seleteOne(@Param("waitername") String waitername);

    Integer insertBoss(@Param("userName") String userName,
                       @Param("password") String password,
                       @Param("shopId") Integer shopId,
                       @Param("userType") Integer userType);

    List<User> allfinboss(@Param("userType") Integer userType);

    User finallboss(@Param("userId") Integer userId);

    Integer finboss(@Param("username") String usernam, @Param("password") String password);

    Integer insertwaiterone(@Param("username") String username);

    Integer inswaiter(@Param("userName") String userName,
                      @Param("password") String password,
                      @Param("shopId") Integer shopId);

    Integer selectName(String userName);

}
