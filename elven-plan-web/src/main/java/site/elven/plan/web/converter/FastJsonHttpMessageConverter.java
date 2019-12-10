/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.web.converter;

import org.springframework.http.converter.json.AbstractJsonHttpMessageConverter;
import site.elven.plan.plugin.json.fastjson.JSONUtils;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Filename FastJsonHttpMessageConverter.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/4 23:50</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class FastJsonHttpMessageConverter extends AbstractJsonHttpMessageConverter {

    public FastJsonHttpMessageConverter(){
        super();
    }

    @Override
    protected Object readInternal(Type resolvedType, Reader reader) throws Exception {
        logger.info("fastjson.readInternal...");
        return JSONUtils.parseObject(reader, resolvedType);
    }

    @Override
    protected void writeInternal(Object o, Type type, Writer writer) throws Exception {
        logger.info("fastjson.writeInternal...");
        JSONUtils.writeJSONString(writer, o);
    }
}