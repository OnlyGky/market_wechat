package com.in.market.commons.scheduleds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author TheSevenSky
 */
@Component
public class ClearCacheScheduled {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RedisTemplate redisTemplate = null;

    @Scheduled(cron = "0 0 0 * * ?")
    public void clearCache() {
        clearHot();
        clearGoodsDetail();
        clearPageAndGoods();
        clearGoods();
    }

    @CacheEvict(cacheNames = "hot",allEntries=true,beforeInvocation = true)
    public void clearHot() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(new Date()) + "  clear RedisCache ==> cacheNames : hot");
        logger.info("[ clear RedisCache ] ==> cacheNames : hot ");
    }

    @CacheEvict(cacheNames = "goodsDetail", allEntries = true, beforeInvocation = true)
    public void clearGoodsDetail() {
        logger.info("[ clear RedisCache ] ==> cacheNames : goodsDetail ");
    }

    @CacheEvict(cacheNames = "pageAndGoods", allEntries = true, beforeInvocation = true)
    public void clearPageAndGoods() {
        logger.info("[ clear RedisCache ] ==> cacheNames : pageAndGoods ");
    }

    @CacheEvict(cacheNames = "goods", allEntries = true, beforeInvocation = true)
    public void clearGoods() {
        logger.info("[ clear RedisCache ] ==> cacheNames : goods ");
    }
}
