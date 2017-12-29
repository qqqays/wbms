package com.shuwang.wbms.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.entity.UserEntity;
import com.shuwang.wbms.entity.UserRoleEntity;
import com.shuwang.wbms.service.IUserRoleService;
import com.shuwang.wbms.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.soap.SOAPBinding;
import java.util.Set;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-27-2017 16:21
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    /**
     * Fucking the authentication
     *
     * @param authenticationToken token
     * @return AuthenticationInfo
     * @throws AuthenticationException ?
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        UserEntity user = userService.selectById(token.getUsername());

        if (user == null) {
            throw new UnknownAccountException();
        }

        if (!user.getPassword().equals(new String((char[]) token.getCredentials()))) {
            throw new IncorrectCredentialsException();
        }

        if (!user.isState()) {
            throw new LockedAccountException();
        }

//        ByteSource byteSource = ByteSource.Util.bytes(token.getUsername());

        return new SimpleAuthenticationInfo(user, token.getCredentials(), getName());
//        return null;
    }

    /**
     * Fucking the authorization
     *
     * @param principalCollection co
     * @return authorization
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        UserEntity user = (UserEntity) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Set<String> roles = userRoleService.findRolesByUid(user.getUserName());

        info.setRoles(roles);

        return info;
    }
}
