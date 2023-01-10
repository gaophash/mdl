package com.jiasu.mdl.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Description : RedisConfig. <br />
 * Create Time : 2023年1月9日 <br />
 * Copyright : Copyright (c) 2010 - 2020 All rights reserved. <br />
 * 
 * @author gaopeng
 * @version 1.0
 */
@Configuration
public class RedisConfig {
	
	private static final Logger log = LoggerFactory.getLogger(RedisConfig.class);
 
    @Value("${spring.redis.host}")
    private String host;
 
    @Value("${spring.redis.port}")
    private int port;
    
    @Value("${spring.redis.password}")
    private String password;
 
    @Value("${spring.redis.timeout}")
    private int timeout;
    
    @Value("${spring.redis.database}")
    private int database;
 
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;
 
    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;
    
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;
 
    @Bean
    public JedisPool redisPoolFactory()  throws Exception{
        log.info("Redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPoolConfig.setTestOnReturn(false);
        jedisPoolConfig.setJmxEnabled(true);
        
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(60000);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(30000);
        jedisPoolConfig.setNumTestsPerEvictionRun(10);
        
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
        log.info("JedisPool构建成功");
        return jedisPool;
    }

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
    
    
 
}