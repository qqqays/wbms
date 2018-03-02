package com.shuwang.wbms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shuwang.wbms.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<UserEntity> {

    boolean updateProfile(@Param("newName") String newName, @Param("desc") String desc, @Param("avadar") String avadar, @Param("originName") String originName);
}
