package com.shuwang.wbms.service;

import com.baomidou.mybatisplus.service.IService;
import com.shuwang.wbms.entity.DetailEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Q-ays.
 * 12-11-2017 13:04
 */
public interface IDetailService extends IService<DetailEntity>{
    int click(String id);
}
