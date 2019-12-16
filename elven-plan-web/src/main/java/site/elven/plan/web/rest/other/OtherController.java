package site.elven.plan.web.rest.other;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuqs
 * @Date 2019/12/13 17:32
 */
@RestController
@RequestMapping("/web/rest/other")
public class OtherController {
    @RequestMapping("exception")
    public String exception() throws Exception {
        throw new Exception("Zzzzzzzzzzz");
    }
}