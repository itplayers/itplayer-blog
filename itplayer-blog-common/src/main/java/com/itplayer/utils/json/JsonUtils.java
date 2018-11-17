package com.itplayer.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.SerializationException;

import java.io.File;
import java.io.IOException;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class JsonUtils {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final ObjectMapper INDENT_OUTPUT_OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.enable(MapperFeature.USE_GETTERS_AS_SETTERS);
        OBJECT_MAPPER.enable(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS);
        OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        INDENT_OUTPUT_OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        INDENT_OUTPUT_OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        INDENT_OUTPUT_OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);
    }

    private JsonUtils() {
    }

    /**
     * 将对象转换为字符转
     *
     * @param object
     * @return
     */
    public static String obj2Str(Object object) {
        String str = "";
        try {
            str = OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 将字符串转换为对象
     *
     * @param str
     * @param cls
     * @return
     */
    public static <T> T str2Obj(String str, Class<T> cls) {
        T object = null;
        try {
            object = OBJECT_MAPPER.readValue(str, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 对象存Json字符串于文件
     *
     * @param file   保存文件
     * @param object 数据存储对象
     */
    public static void writeValue(File file, Object object) {
        try {
            if (null != object) {
                INDENT_OUTPUT_OBJECT_MAPPER.writeValue(file, object);
            }
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    /**
     * 对象转为json字符串，不输出空属性
     * @param object
     */
    public static void writeValueWithoutNullValue(Object object) {
        try {
            if (null != object) {
                INDENT_OUTPUT_OBJECT_MAPPER.writeValueAsString(object);
            }
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }


    /**
     * 读取文件(json格式)并反序列化未指定对象
     *
     * @param file  读取文件
     * @param clazz 序列化对象
     * @return
     */
    public static <T> T readValue(File file, Class<T> clazz) {
        try {
            if (null != file) {
                return OBJECT_MAPPER.readValue(file, clazz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
