package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Boss;
import com.ruoyi.system.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BossMapper {
    Double getEnaringToday(@Param("shopId") Integer shopId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Double getEnaringMonth(@Param("shopId") Integer shopId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Double getEnaringWeek(@Param("shopId") Integer shopId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //日
    Double selectpresent(Integer shopId);
    //周
    Double selectweek(Integer shopId);
    //月
    Double selectmonth( Integer shopId);
    //boss猎豹
    List<User> selectboss ();
    //修改
    Integer updateBoss(@Param("userName") String userName,
                       @Param("password") String password,
                       @Param("userId") Integer userId);
    //查询
    Integer  selectfll( @Param("userName") String userName,
                        @Param("password") String password);

}
