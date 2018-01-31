package com.shuwang.wbms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shuwang.wbms.entity.LogEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-31-2018 10:04
 */
public interface LogMapper extends BaseMapper<LogEntity>{
    int apiLogInsert(@Param("user") String user, @Param("ip") String ip, @Param("api") String api,
                     @Param("reqMethod") String reqMethod, @Param("classMethod") String classMethod,
                     @Param("note") String note);
}
