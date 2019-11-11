package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.User;
import com.ruoyi.system.mapper.UserMapper;
import com.ruoyi.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int deleteById(int userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User selectUser(String userName,String password){
     return userMapper.selectUser(userName,password);
    }



    //----------------------------------------------------------------------------------
        //多个查询
    @Override
    public List<User> seletewaitrt(Integer shopId) {
        return userMapper.seletewaitrt(shopId);
    }
    //单个查询
    @Override
    public Integer seleteOne(String waiterusername) {
        return userMapper.seleteOne(waiterusername);
    }

    //插入
    @Override
    public Integer insertwaiter(String waitername, String waiterword, Integer shopId) {
        return userMapper.insertwaiter(waitername,waiterword,shopId);
    }
    //修改
    @Override
    public Integer updatewaiter(String waitername, String waiterword, Integer userId) {
        return userMapper.updatewaiter(waitername,waiterword,userId);
    }
    //删除
    @Override
    public Integer deletewaiter(Integer userId) {
        return userMapper.deletewaiter(userId);
    }

    //添加老板
    @Override
    public  Integer insertBoss(String userName,String password,Integer shopId,Integer userType){
        return  userMapper.insertBoss(userName,password,shopId,userType);
    }

    //查询所有老板账户
    @Override
    public List<User> allfinboss( Integer userType){
        return userMapper.allfinboss(userType);
    }
    //单个老板
    @Override
    public User finallboss(Integer userId){
        return userMapper.finallboss(userId);
    }

    @Override
    public Integer finboss(String usernam, String password) {
        return userMapper.finboss(usernam,password);
    }

    @Override
    public Integer insertwaiterone(String username){
        return  userMapper.insertwaiterone(username);
    }

    @Override
    public Integer inswaiter(String userName, String password, Integer shopId){
        return userMapper.inswaiter(userName,password,shopId);
    }
}
