package com.shuwang.wbms.service;

import com.baomidou.mybatisplus.service.IService;
import com.shuwang.wbms.entity.LogEntity;
import org.apache.ibatis.annotations.Param;

public interface ILogService extends IService<LogEntity> {
    int apiLogInsert(String user, String ip, String api, String reqMethod, String classMethod, String note);
    int simpleLogInsert(String user, String ip, String note);
}
