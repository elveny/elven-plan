package site.elven.plan.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@JsonComponent
public class CustomJsonDeserializers {
    public static class DateDeserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            if(jsonParser != null && StringUtils.isNotBlank(jsonParser.getText())){
                try {
                    DateUtils.parseDate(jsonParser.getText());
                } catch (ParseException e) {
                    return null;
                }
            }
            return null;
        }
    }
}
