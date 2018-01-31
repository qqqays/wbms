package com.shuwang.wbms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shuwang.wbms.entity.DetailEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Q-ays.
 * 12-11-2017 13:12
 */
public interface DetailMapper extends BaseMapper<DetailEntity> {
    int click(@Param("id") String id);
}
