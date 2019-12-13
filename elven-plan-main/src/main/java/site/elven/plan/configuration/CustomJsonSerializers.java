package site.elven.plan.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.Date;

@JsonComponent
public class CustomJsonSerializers {
    public static class DateUserSerializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(DateFormatUtils.format(value, "yyyy-MM-dd HH:mm:ss.SSS"));
        }
    }
}
