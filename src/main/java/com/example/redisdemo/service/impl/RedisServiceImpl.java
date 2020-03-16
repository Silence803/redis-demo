package com.example.redisdemo.service.impl;

import com.example.redisdemo.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Creat by ZhangXueRong on 2019/12/5
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    JedisPool jedisPool;

    /**
     * 处理jedis请求
     *
     * @param f 处理逻辑，通过lambda行为参数化
     * @return 处理结果
     */
    private Object excuteByJedis(Function<Jedis, Object> f) {
        try (Jedis jedis = jedisPool.getResource()) {
            return f.apply(jedis);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, int time) {
        return (String) this.excuteByJedis(j-> j.set(key, value, nxxx, expx, time));
    }

    @Override
    public Object eval(String script, List<String> keys, List<String> args) {
        return this.excuteByJedis(j -> j.eval(script, keys, args));
    }
}
