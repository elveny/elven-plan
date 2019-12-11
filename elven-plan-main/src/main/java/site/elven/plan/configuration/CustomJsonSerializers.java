package site.elven.plan.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectSerializer;
import site.elven.plan.web.rest.test.TestUser;

import java.io.IOException;

@JsonComponent
public class CustomJsonSerializers {
    public static class TestUserSerializer extends JsonObjectSerializer<TestUser> {

        @Override
        protected void serializeObject(TestUser value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            value.setBodyFatRate(getBodyFatRate(value));
            jgen.writeObject(value);
        }

        private double getBodyFatRate(TestUser testUser){
            float bmi = testUser.getWeight() / testUser.getHeight();
            double bodyFatRate = (1.2 * bmi) + (0.23 * testUser.getAge()) - 5.4 - 10.8 * testUser.getSex();

            return bodyFatRate;
        }
    }
}
