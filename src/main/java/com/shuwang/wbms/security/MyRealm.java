package com.shuwang.wbms.security;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.net.Authenticator;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-27-2017 16:21
 */
public class MyRealm extends AuthorizingRealm {

    /**
     * Fucking the authentication
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if (!token.getUsername().equals("qays")) {
            throw new UnknownAccountException();
        }

        if (!new String(token.getPassword()).equals("123")) {
            throw new IncorrectCredentialsException();
        }

//        ByteSource byteSource = ByteSource.Util.bytes(token.getUsername());

        return new SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(), getName());
//        return null;
    }

    /**
     * Fucking the authorization
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
