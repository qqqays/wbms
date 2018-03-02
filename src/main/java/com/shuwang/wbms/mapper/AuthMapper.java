package com.shuwang.wbms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shuwang.wbms.entity.AuthEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthMapper extends BaseMapper<AuthEntity>{
    List<AuthEntity> noneAuthList(@Param("roleName") String roleName);
}
