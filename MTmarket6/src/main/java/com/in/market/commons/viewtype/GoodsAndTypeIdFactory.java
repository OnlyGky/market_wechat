package com.in.market.commons.viewtype;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GoodsAndTypeIdFactory {
    private static class GoodsAndTypeIdHolder{
        private static final Map<String, Integer> map = new ConcurrentHashMap<>();
    }

    public GoodsAndTypeIdFactory() {
        throw new AssertionError();
    }

    static {
        init();
    }

    private static final String FILE_NAME = "goodsAndTypeId.properties";

    private static void init() {
        readFile();
    }

    private static void readFile() {

        Properties properties = new ReadFile().read();
        if (properties == null) throw new NullPointerException();
        for(Object s : properties.keySet()) {
            String str = (String) s;
            GoodsAndTypeIdHolder.map.put(str, Integer.parseInt(properties.getProperty(str)));
        }
    }

    public static Map<String,Integer> getMap() {
        return GoodsAndTypeIdHolder.map;
    }

    public static Integer get(String key) {
        return GoodsAndTypeIdHolder.map.get(key);
    }

    public static void update() {
        GoodsAndTypeIdHolder.map.clear();
        readFile();
    }

    private static class ReadFile{
        private Properties read() {
            InputStream resource = null;
            Properties properties = null;
            try {
                properties = new Properties();
                resource = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
                properties.load(resource);
                return properties;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    resource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
