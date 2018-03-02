package com.shuwang.wbms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shuwang.wbms.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<RoleEntity>{

    List<RoleEntity> noneRoleList(@Param("username") String username);
}
