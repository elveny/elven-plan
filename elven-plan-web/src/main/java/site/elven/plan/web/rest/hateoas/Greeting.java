package site.elven.plan.web.rest.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

/**
 * @author wuqs
 * @Date 2019/12/16 16:46
 */
public class Greeting extends RepresentationModel {
    private final String content;

    @JsonCreator
    public Greeting(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}