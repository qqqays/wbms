package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.UserRoleEntity;
import com.shuwang.wbms.mapper.UserRoleMapper;
import com.shuwang.wbms.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:31
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements IUserRoleService{

    @Override
    public Set<String> findRolesByUid(String userName) {

        List<UserRoleEntity> list = this.selectList(new EntityWrapper<UserRoleEntity>().eq("userName", userName));

        Set<String> set = new HashSet<>();
        for (UserRoleEntity ur : list) {
            set.add(ur.getRoleName());
        }
        return set;
    }

    @Override
    public boolean insertBatch(List<UserRoleEntity> entityList) {
        String username = entityList.get(0).getUserName();
        super.delete(new EntityWrapper<UserRoleEntity>().eq("userName", username));
        return super.insertBatch(entityList);
    }
}
