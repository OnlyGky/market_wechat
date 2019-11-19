package com.in.market.commons.cache.rediscache;


import com.in.market.commons.until.RedisTemplatePlusUtil;
import com.in.market.commons.until.SpelUtil;
import org.apache.el.lang.EvaluationContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RedisCacheAspect {

    ExpressionParser parser = new SpelExpressionParser();
    LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();


    @Pointcut("execution(public * com.in.market.suibian.*.*(..))")
    public void point(){}

//    @Around("point()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
//        Object[] args = proceedingJoinPoint.getArgs();
//        Class<?>[] argTypes = new Class[args.length];
//        for(int i = 0; i < args.length; i++) {
//            argTypes[i] = args[i].getClass();
//        }
//        Method method = proceedingJoinPoint
//                .getTarget().getClass().getMethod(proceedingJoinPoint.getSignature().getName(), argTypes);
//        DefaultParameterNameDiscoverer discover = new DefaultParameterNameDiscoverer();
//        String[] arr = discover.getParameterNames(method);
//        RedisCacheable annotation = method.getAnnotation(RedisCacheable.class);
//        String key = annotation.key();
//        System.out.println("cacheName --- " + annotation.cacheNames()[0].toString());
//        argeForKey(key, arr, args);
//        if(annotation != null) {
//            if(RedisMethodEnum.GETANDFIND.equals(annotation.method())) {
//                Object object = findObjectForCache(annotation);
//                if(object == null) {
//                    object = proceed(proceedingJoinPoint);
//                    saveObjectForCache(annotation,object);
//                }
//                return object;
//            }
//        }
//
//        return proceed(proceedingJoinPoint);
//    }
//
//    private String argeForKey(String key,String[] argsName, Object[] args) {
//        String[] keys = key.split("#");
//        StringBuilder stringBuilder = new StringBuilder(keys[0]);
//        System.out.println("这里进来了 " + key + " " + keys.length);
//        if(keys.length == 2) {
//            getKeyArge(keys[1],argsName,args);
//        }
//        return null;
//    }

//    @Around("@annotation(RedisCacheable)")
//    public Object invoked(ProceedingJoinPoint pjp,RedisCacheable redisCacheable) throws Throwable {
//        Object[] args = pjp.getArgs();
//        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
//        String spel = log.spel();
//        String[] params = discoverer.getParameterNames(method);
//        EvaluationContext context = new StandardEvaluationContext();
//
//        for (int len = 0; len < params.length; len++) {
//            context.setVariable(params[len], args[len]);
//        }
//        Expression expression = parser.parseExpression(spel);
//        if (expression.getValue(context, Boolean.class)) {
//            System.out.println(log.desc() + ",在" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "执行方法，" + pjp.getTarget().getClass() + "." + method.getName()
//                    + "(" + convertArgs(args) + ")");
//        }
//        return pjp.proceed();
//    }

    @Around("@annotation(com.in.market.commons.cache.rediscache.RedisCacheable)")
    public Object invoked(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = getRediskey(joinPoint);
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        RedisCacheable annotation = AnnotationUtils.findAnnotation(targetMethod, RedisCacheable.class);
        String[] cacheNames = annotation.cacheNames();
        Object object = null;
        List list = new ArrayList();
        int len = annotation.size()==-1?Integer.MAX_VALUE:annotation.size();
        if(annotation.isList()) {
            int num = 1;
            for(String  cacheName : cacheNames) {
                while(RedisTemplatePlusUtil.hasKey(cacheName,key + num) && num <= len) {
                    list.add(RedisTemplatePlusUtil.get(cacheName, key+num,annotation.type()));
                    num++;
                }
                if(list.size() > 0) return list;
            }
            object = proceed(joinPoint);
            List objList = (List) object;

            for(int k = 1; k <= objList.size(); k++) {
                for(String cacheName : cacheNames) {
                    RedisTemplatePlusUtil.put(cacheName, key + k,objList.get(k - 1));
                }
            }
            return object;
        }
        for(String cacheName : cacheNames) {
            if(RedisTemplatePlusUtil.hasKey(cacheName,key)) {
                object = RedisTemplatePlusUtil.get(cacheName, key, annotation.type());
                break;
            }
        }
        if(object == null) {
            object = proceed(joinPoint);
            for(String cacheName : cacheNames) {
                RedisTemplatePlusUtil.put(cacheName, key, object);
            }
        }
        return object;
    }

    private String[] getCacheNames(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Object target = joinPoint.getTarget();
        Object[] arguments = joinPoint.getArgs();
        RedisCacheable annotation = AnnotationUtils.findAnnotation(targetMethod, RedisCacheable.class);
        String[] spels = annotation.value();
        int len = spels.length;
        String[] results = new String[len];
        for(int i = 0; i < len; i++) {
            results[i] = SpelUtil.parse(target, spels[i], targetMethod, arguments);
        }
        return results;
    }

    private String getRediskey(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Object target = joinPoint.getTarget();
        Object[] arguments = joinPoint.getArgs();
        RedisCacheable annotation = AnnotationUtils.findAnnotation(targetMethod, RedisCacheable.class);
        String spel = annotation.key();
        return SpelUtil.parse(target,spel, targetMethod, arguments);
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
