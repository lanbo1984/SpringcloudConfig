package com.coolq.app.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Redis工具类
 */
@Configuration
@EnableCaching
public class RedisUtil {

    private static Log log = LogFactory.getLog(RedisUtil.class);

    @Value("${redis.ip}")
    private String ip;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.maxTotal}")
    private int maxTotal;
    @Value("${redis.maxIdle}")
    private int maxIdle;
    @Value("${redis.maxWaitMillis}")
    private int maxWaitMillis;
    @Value("${redis.maxTimeout}")
    private int maxTimeout;

    private static JedisPool jedisPool;

    private JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        return jedisPoolConfig;
    }

    private JedisPool getJedisPool() {
        if (jedisPool == null) {
            jedisPool = new JedisPool(getJedisPoolConfig(), ip, port, maxTimeout);
        }
        return jedisPool;
    }

    @Bean
    public JedisPool RedisUtil() {
        this.jedisPool = getJedisPool();
        return jedisPool;
    }

    public static void zadd(int db, String key, double score, String member) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(db);
            jedis.zadd(key, score, member);
            log.info("save data key : " + key + ", member : " + member + ", score : " + score);
        } catch (Exception e) {
            log.error("redisutil error : {}", e);
            e.printStackTrace();

            throw new JedisException(e.getMessage(), e);
        } finally {
            if (jedisPool != null && jedis != null) {
                jedisPool.returnBrokenResource(jedis);
            }
        }
    }

    public static Double zscore(int db, String key, String member) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        try {
            return jedis.zscore(key, member);
        } catch (Exception e) {
            log.error("redisutil error : {}", e);
            if (jedis != null) {
                jedisPool.returnBrokenResource(jedis);
            }
            throw new JedisException(e);
        } finally {
            if (jedisPool != null) {
                jedisPool.returnBrokenResource(jedis);
            }
        }
    }

    public static void hset(int db, String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(db);
            jedis.hset(key, field, value);
            log.info("save data key : " + key + ", field : " + field + ", value : " + value);
        } catch (Exception e) {
            log.error("redisutil error : {}", e);
            if (jedis != null) {
                jedisPool.returnBrokenResource(jedis);
            }
            throw new JedisException(e);

        } finally {
            if (jedisPool != null) {
                jedisPool.returnResource(jedis);
            }
        }
    }

    public static String hget(int db, String key, String field) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(db);
            value = jedis.hget(key, field);
            log.info("get data key : " + key + ", field : " + field);
        } catch (Exception e) {
            log.error("redisutil error : {}", e);
            if (jedis != null) {
                jedisPool.returnBrokenResource(jedis);
            }
            throw new JedisException(e);

        } finally {
            if (jedisPool != null) {
                jedisPool.returnResource(jedis);
            }
        }
        return value;
    }

}