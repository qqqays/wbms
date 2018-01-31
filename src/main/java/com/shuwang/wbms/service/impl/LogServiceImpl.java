package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.LogEntity;
import com.shuwang.wbms.mapper.LogMapper;
import com.shuwang.wbms.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-31-2018 10:43
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogEntity> implements ILogService {

    @Autowired
    private LogMapper logMapper;

    public int apiLogInsert(String user, String ip, String api, String reqMethod, String classMethod, String note){
        return logMapper.apiLogInsert(user, ip, api, reqMethod, classMethod, note);
    }

    @Override
    public int simpleLogInsert(String user, String ip, String note) {
        return logMapper.apiLogInsert(user,ip,"","","",note);
    }
}
