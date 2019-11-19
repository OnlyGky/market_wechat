package com.in.market.commons.until;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.serializer.SerializationException;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 序列化和反序列化工具
 * @author TheSevenSky
 */
public class ProtoSerializerUntil {


    private static class ProtostuffSerializerUntilHolder{
        private static Map<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap<>();
    }


    public static<T> byte[] serialize(T o) throws SerializationException {
        Class<T> clazz = (Class<T>) o.getClass();
        Schema<T> schema = getSchema(clazz);
        return ProtostuffIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }


    public static<T> T deserialize(byte[] data,Class<T> clazz) throws SerializationException {
        //Protostuff 不支持序列化/反序列化数组、集合等对象,特殊处理

        Schema<T> schema = getSchema(clazz);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data, obj, schema);
        return obj;
    }

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        if(!ProtostuffSerializerUntilHolder.schemaCache.containsKey(clazz)) {
            Schema<T> schema = RuntimeSchema.getSchema(clazz);
            if (Objects.nonNull(schema)) {
                ProtostuffSerializerUntilHolder.schemaCache.put(clazz, schema);
            }
        }
        return (Schema<T>) ProtostuffSerializerUntilHolder.schemaCache.get(clazz);
    }

    static class SerializeDeserializeWrapper<T> {

        private T data;

        public static <T> SerializeDeserializeWrapper<T> builder(T data) {
            SerializeDeserializeWrapper<T> wrapper = new SerializeDeserializeWrapper<>();
            wrapper.setData(data);
            return wrapper;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }



}
