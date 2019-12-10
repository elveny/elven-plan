/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.plugin.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/**
 * @Filename JSONUtils.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/4 22:58</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class JSONUtils {

    public static String toJSONString(Object object, Set<String> includes, Set<String> excludes, boolean writeDateUseDateFormat){

        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter();
        if(CollectionUtils.isNotEmpty(includes)){
            simplePropertyPreFilter.getIncludes().addAll(includes);
        }

        if(CollectionUtils.isNotEmpty(excludes)){
            simplePropertyPreFilter.getExcludes().addAll(excludes);
        }

        if(writeDateUseDateFormat){
            return JSON.toJSONString(object, simplePropertyPreFilter, SerializerFeature.WriteDateUseDateFormat);
        }
        else {
            return JSON.toJSONString(object, simplePropertyPreFilter);
        }
    }

    public static String toJSONString(Object object, Set<String> excludes, boolean writeDateUseDateFormat){
        return toJSONString(object, null, excludes, writeDateUseDateFormat);
    }

    public static String toJSONString(Object object, Set<String> excludes){
        return toJSONString(object, excludes, true);
    }

    public static String toJSONString(Object object){
        return toJSONString(object, null);
    }

    public static JSONObject parseObject(String text){
        return JSON.parseObject(text);
    }

    public static <T> T parseObject(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

    public static JSONArray parseArray(String text){
        return JSON.parseArray(text);
    }

    public static <T> List<T> parseArray(String text, Class<T> clazz){
        return JSON.parseArray(text, clazz);
    }

    public static Object parseObject(Reader reader, Type type){
        try {
            String text = IOUtils.toString(reader);
            return JSON.parseObject(text, type);
        } catch (IOException e) {
            return null;
        }
    }

    public static void writeJSONString(Writer writer, Object object){
        writeJSONString(writer, object, true);
    }

    public static void writeJSONString(Writer writer, Object object, boolean writeDateUseDateFormat){
        if(writeDateUseDateFormat){
            JSON.writeJSONString(writer, object, SerializerFeature.WriteDateUseDateFormat);
        }
        else{
            JSON.writeJSONString(writer, object);

        }
    }

}