package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Boss;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.mapper.BossMapper;
import com.ruoyi.system.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class BossServiceImpl implements BossService {

    @Autowired
    BossMapper bossMapper;


    @Override
    public Double getEarningToday(Integer shopId,String startTime,String endTime) {
        return bossMapper.getEnaringToday(shopId,startTime,endTime);
    }

    @Override
    public Double getEarningMonth(Integer shopId,String startTime,String endTime) {
        return bossMapper.getEnaringMonth(shopId,startTime,endTime);
    }

    @Override
    public Double getEarningWeek(Integer shopId,String startTime,String endTime) {
        return bossMapper.getEnaringWeek(shopId,startTime,endTime);
    }
    @Override
    public Double selectpresent(Integer shopId){
        return bossMapper.selectpresent(shopId);
    }

    @Override
   public Double selectweek(Integer shopId){
        return bossMapper.selectweek(shopId);
    }
    //查询月销售额度
    @Override
   public Double selectmonth( Integer shopId){
        return bossMapper.selectmonth(shopId);
   }

    //列表
    @Override
    public List<User> selectboss(){
        return bossMapper.selectboss();
    }
    //修改
    @Override
    public Integer updateBoss(String userName,String password,Integer userid){
        return bossMapper.updateBoss(userName,password,userid);
    }

    //查询boss是否存在
    @Override
    public Integer selectfll(String userName,String password){
        return bossMapper.selectfll(userName,password);
    }



}
