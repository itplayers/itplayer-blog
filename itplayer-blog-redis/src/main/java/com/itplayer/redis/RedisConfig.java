package com.itplayer.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author caijun.yang
 * @date 2018/10/12
 */
@Configuration
@PropertySource(value = {"classpath:redis.properties"})
public class RedisConfig {
    @Value("${redis.host}")
    private String hostName;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.pool.maxWait}")
    private Long maxWaitMillis;
    @Value("${redis.pool.maxIdle}")
    private int maxIdle;
    @Value("${redis.pool.minIdle}")
    private int minIdle;
    @Value("${redis.pool.maxTotal}")
    private int maxTotal;
    @Value("${redis.pool.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${redis.pool.testOnReturn}")
    private boolean testOnReturn;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.databasesIndex}")
    private int databasesIndex;

    @Bean
    JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        return jedisPoolConfig;
    }

    @Bean
    RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        redisStandaloneConfiguration.setDatabase(databasesIndex);
        return redisStandaloneConfiguration;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration());
        return jedisConnectionFactory;
    }

}
