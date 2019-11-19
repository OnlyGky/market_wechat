package com.in.market.commons.until;

import io.protostuff.ProtostuffIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author TheSevenSky
 */
@Component
public class RedisTemplatePlusUtil {


    private static RedisTemplate redisTemplate = null;

    @Autowired
    RedisTemplatePlusUtil(RedisTemplate redisTemplate) {
        RedisTemplatePlusUtil.redisTemplate = redisTemplate;
    }

    public static <T> void put(Object cacheName, Object key, T t) {
        redisTemplate.opsForHash().put(cacheName,key,ProtoSerializerUntil.serialize(t));
    }

    public static <T> T get(Object cacheName, Object key, Class<T> clazz) {
        return ProtoSerializerUntil.deserialize((byte[]) redisTemplate.opsForHash().get(cacheName, key), clazz);
    }

    public static void remove(Object cacheName, Object key) {
        redisTemplate.opsForHash().delete(cacheName, key);
    }

    public static void remove(Object cacheName) {
        redisTemplate.opsForHash().delete(cacheName);

    }

    public static Boolean hasKey(Object cacheName, Object key) {
        return redisTemplate.opsForHash().hasKey(cacheName, key);
    }
}
