package com.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.coffee.entity.RedisUser;
 
@Service
public class RedisUserService {
 
    @Autowired
    private RedisTemplate redisTemplate;
 
    //查询缓存数据
    @Cacheable(value = "users",key = "#name")
    public RedisUser findUser(String name) {
        RedisUser redisUser = new RedisUser();
        return redisUser;
    }
    //删除缓存数据
    @CacheEvict(value = "users", key = "#name")
    public int removeUser(String name) {
        return 0;
    }
    //更新或者是增加数据
    @CachePut(value = "users",key="#redisUser.getName()" )
    public RedisUser saveUser(RedisUser redisUser) {
 
        return redisUser;
    }
 
}

