package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.RoleAuthEntity;
import com.shuwang.wbms.entity.RoleEntity;
import com.shuwang.wbms.mapper.RoleAuthMapper;
import com.shuwang.wbms.service.IRoleAuthService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:32
 */
@Service
public class RoleAuthImpl extends ServiceImpl<RoleAuthMapper, RoleAuthEntity> implements IRoleAuthService{

    @Override
    public Set<String> findPermBySet(Set<String> set) {
        Set<String> aSet = new HashSet<>();

        for (String role : set) {
            List<RoleAuthEntity> list = this.selectList(new EntityWrapper<RoleAuthEntity>()
                    .eq("roleName", role));

            for (RoleAuthEntity roleAuth : list) {
                aSet.add(roleAuth.getAuthName());
            }
        }

        return aSet;
    }

    @Override
    public boolean insertBatch(List<RoleAuthEntity> entityList) {

        String roleName = entityList.get(0).getRoleName();

        super.delete(new EntityWrapper<RoleAuthEntity>().eq("roleName", roleName));

        return super.insertBatch(entityList);
    }
}
