package com.coffee.configuration;

import java.lang.reflect.Method;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
	/*@Bean
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        RedisCacheManager rm = new RedisCacheManager(redisTemplate);
        rm.setDefaultExpiration(30l);// 设置缓存时间
        return rm;
    }*/
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
	    RedisCacheManager cacheManager = RedisCacheManager.create(factory);
	    return cacheManager;
	}

	 
	 @Bean
     public KeyGenerator wiselyKeyGenerator(){
	     return new KeyGenerator() {
	         @Override
	         public Object generate(Object target, Method method, Object... params) {
	        	 StringBuilder sb = new StringBuilder();
	             sb.append(target.getClass().getName());
	             sb.append(method.getName());
	             for (Object obj : params) {
	                  sb.append(obj.toString());
	              }
	              return sb.toString();
	            }
	        };
	 }
	 
	 @Bean
	    public RedisTemplate<String, String> redisTemplate(
	            RedisConnectionFactory factory) {
	        StringRedisTemplate template = new StringRedisTemplate(factory);
	        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
	        ObjectMapper om = new ObjectMapper();
	        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	        jackson2JsonRedisSerializer.setObjectMapper(om);
	        template.setValueSerializer(jackson2JsonRedisSerializer);
	        template.afterPropertiesSet();
	        return template;
	    }


}
