package com.in.market.commons.strategy;

import com.in.market.commons.cache.CacheInterface;
import com.in.market.commons.cache.strategycache.StrategyCache;
import com.in.market.commons.cache.strategycache.impl.DefaultStrategyCache;
import com.in.market.commons.strategy.impl.DefaultStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @author TheSevenSky
 */
public class StrategyFactory {

    private static class StrategyFactoryHolder{
        private static final StrategyCache<String, Strategy<Double>> CACHE = new DefaultStrategyCache();
    }

    private static final String RESOURCE_NAME = "strategyAndClassName.properties";


    private static Strategy build(String strategyName) {

        Strategy strategy = new DefaultStrategy();

        Properties properties = new Properties();
        try {

            InputStream inputStream = StrategyFactoryHolder.class.getClassLoader().getResourceAsStream(RESOURCE_NAME);
            properties.load(inputStream);
            Class clazz = Class.forName(properties.getProperty(strategyName));
            strategy = (Strategy)clazz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strategy;
    }


    public static  Object getResult(String strategyName,Double price) {
        if(price == null) return null;
        if(!StrategyFactoryHolder.CACHE.containsKey(strategyName)) {
            StrategyFactoryHolder.CACHE.put(strategyName,build(strategyName));
        }
        return StrategyFactoryHolder.CACHE.get(strategyName).getResult(price);
    }

    public static Object getStrategy(String strategyName) {
        if(!StrategyFactoryHolder.CACHE.containsKey(strategyName)) {
            StrategyFactoryHolder.CACHE.put(strategyName,build(strategyName));
        }
        return StrategyFactoryHolder.CACHE.get(strategyName).getStrategy();
    }

    private class M{

    }

}
