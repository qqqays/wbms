package com.shuwang.wbms.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-04-2018 15:49
 */
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher {

    private static final Logger log = LoggerFactory.getLogger(RetryLimitCredentialsMatcher.class);


    private Cache<String, AtomicInteger> loginRetryCache;

    private int maxRetryCount = 5;

    private String loginRetryCacheName;

    public void setMaxRetryCount(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    public RetryLimitCredentialsMatcher(CacheManager cacheManager, String loginRetryCacheName) {
        this.loginRetryCacheName = loginRetryCacheName;
        loginRetryCache = cacheManager.getCache(loginRetryCacheName);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();
        //retry count + 1
        AtomicInteger retryCount = loginRetryCache.get(username);
        if (null == retryCount) {
            retryCount = new AtomicInteger(0);
            loginRetryCache.put(username, retryCount);
        }

        if (retryCount.incrementAndGet() > maxRetryCount) {
            log.warn("username: " + username + " tried to login more than 5 times in period");
            throw new ExcessiveAttemptsException("username: " + username + " tried to login more than 5 times in period"
            );
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //clear retry data
            loginRetryCache.remove(username);
        }
        return matches;
    }

}
