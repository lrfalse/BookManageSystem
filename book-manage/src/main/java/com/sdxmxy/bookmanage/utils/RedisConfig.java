package com.sdxmxy.bookmanage.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    /*
    <beans>
        <bean id="jedis" class="redis.clients.jedis.Jedis">
            <property name="host" value="192.168.67.210"></property>
            <property name="port" value="6379"></property>
        </bean>
    </beans>
     */
    // 在类中先获得host，port，database ，将其放入配置文件中

    @Value("${spring.redis.host:disabled}") // :disabled 表示给一个默认值
    private String host;  // host=192.168.67.210
    // 取得port
    @Value("${spring.redis.port:0}")
    private int port;

    @Value("${spring.redis.database:0}")
    private int database;

    // RedisUtil 注入到容器中
    @Bean
    public RedisUtil getRedisUtil(){
        // 做一个判断
        if ("disabled".equals(host)){
            return  null;
        }

        RedisUtil redisUtil = new RedisUtil();
        redisUtil.initJedisPool(host,port,database);
        return redisUtil;
    }
}
