package com.ruoyi.system.service;

import com.ruoyi.system.domain.Boss;
import com.ruoyi.system.domain.User;

import java.util.List;

/**
 * 老板报表的服务层
 */
public interface BossService {
    //查询当日销售额度
    Double selectpresent(Integer shopId);
    //查询周销售额度
    Double selectweek(Integer shopId);
    //查询月销售额度
    Double selectmonth(Integer shopId);

//日
    Double getEarningToday(Integer shopId, String startTime, String endTime);
//月
    Double getEarningMonth(Integer shopId, String startTime, String endTime);
//周
    Double getEarningWeek(Integer shopId, String startTime, String endTime);
    //查询多个BOss
    List<User> selectboss();
    //修改boss
    Integer updateBoss(String userName,String password,Integer userid);
    //查询boss是否存在
    Integer selectfll(String userName,String password);

}
