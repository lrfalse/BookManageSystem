package com.sdxmxy.bookmanage.utils;

import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

public class RedisUtil {
    // 创建连接池对象
    private JedisPool jedisPool =null;
    // 给JedisPool 做一个初始化方法
    // jedis.select(1) 选择redis的几号库
    public void initJedisPool(String host,int port,int database){
        // 初始化jedisPool 的过程中，可以需要配置初始化的参数
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置参数 ,总数
        jedisPoolConfig.setMaxTotal(100);
        // 等待时间
        jedisPoolConfig.setMaxWaitMillis(10*1000);

        jedisPoolConfig.setMinIdle(10);
        // 设置一下如果达到最大连接数，需要等待
        jedisPoolConfig.setBlockWhenExhausted(true);
        // 当线程得到连接的时候，需要自检{检查当前的连接是否可以使用}
        jedisPoolConfig.setTestOnBorrow(true);

        jedisPool = new JedisPool(jedisPoolConfig,host,port,20*1000);
    }

    // 获取jedis 对象
    public Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }


}
