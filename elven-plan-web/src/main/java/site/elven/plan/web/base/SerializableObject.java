package site.elven.plan.web.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import site.elven.plan.plugin.json.fastjson.JSONUtils;

import java.io.Serializable;

public class SerializableObject implements Serializable {

    private final static long serialVersionUID = 122333444455555L;

    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String toJSONString(){
        return JSONUtils.toJSONString(this);
    }

}
