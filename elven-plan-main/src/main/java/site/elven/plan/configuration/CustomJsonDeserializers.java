package site.elven.plan.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import site.elven.plan.web.rest.test.TestUser;

import java.io.IOException;

@JsonComponent
public class CustomJsonDeserializers {
    public static class TestUserDeserializer extends JsonObjectDeserializer<TestUser>{

        @Override
        protected TestUser deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
            return codec.readValue(jsonParser, TestUser.class);
        }
    }
}
