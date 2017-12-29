package com.shuwang.wbms.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-29-2017 9:42
 */
public class MyRealm1 implements Realm {

    @Override
    public String getName() {
        return "what the fuck name";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if (!token.getUsername().equals("luguo")) {
            throw new UnknownAccountException();
        }

        if (!new String((char[]) token.getCredentials()).equals("aaa")) {
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), getName());
    }
}
