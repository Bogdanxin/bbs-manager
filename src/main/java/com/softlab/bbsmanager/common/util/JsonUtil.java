package com.softlab.bbsmanager.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JsonUtil
 * @Description Json处理工具类，将字符串处理为json，或者将任意一类的数据处理为json
 * @Author gwx
 * @Date 2020/2/22 16:50
 * @Version 1.0
 */
public class JsonUtil {

    private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将json文件处理成该泛型
     * @param stringJson
     * @param valueType
     * @param <T>
     * @return
     */
    public static <T> T getObjFromJson(String stringJson, Class<T> valueType){
        T rtv = null;
        try {
            rtv = objectMapper.readValue(stringJson, valueType);
        }catch (IOException e){
            logger.error(e.getLocalizedMessage());
        }
        return rtv;
    }

    /**
     * 将实体类转换为Json
     * @param object
     * @return
     */
    public static String getJsonFromObj(Object object) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            logger.error(e.getLocalizedMessage());
        }
        return json;
    }

    /**
     * 将传入的json文件转变为Map类
     * @param json
     * @return
     */
    public static Map<String, Object> getMapFromJson(String json){
        Map<String, Object> map = getObjFromJson(json, Map.class);

        if (map == null){
            return new HashMap<>(0);
        }
        return map;
    }
}
