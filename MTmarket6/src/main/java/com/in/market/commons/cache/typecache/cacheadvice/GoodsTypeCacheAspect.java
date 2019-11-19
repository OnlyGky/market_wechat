package com.in.market.commons.cache.typecache.cacheadvice;


import com.in.market.pojo.goods.GoodsType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author TheSevenSky
 */
@Aspect
@Component
public class GoodsTypeCacheAspect {

    private static Map<Object, GoodsType> cacheMap = new ConcurrentHashMap<>();

    @Pointcut("execution(public * com.in.market.dao.goods.GoodsTypeDao.queryById(..))")
    public void point(){}

    @Around("point()")
    public Object typeAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] arges = proceedingJoinPoint.getArgs();
        if(!cacheMap.containsKey(arges[0])) {
            GoodsType goodsType = (GoodsType) proceed(proceedingJoinPoint);
            cacheMap.put(arges[0], goodsType);
        }
        return cacheMap.get(arges[0]);
    }

    private Object proceed(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}