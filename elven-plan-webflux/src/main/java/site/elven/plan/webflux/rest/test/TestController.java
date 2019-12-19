/**
 * elven.site Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package site.elven.plan.webflux.rest.test;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @Filename TestController.java
 *
 * @description
 *
 * @Version 1.0
 *
 * @author elven
 * @History
 *
 * <li>Author: elven</li>
 * <li>Date: 2019/12/18 21:12</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Slf4j
@RestController("webfluxTestController")
@RequestMapping("/flux/rest/test")
public class TestController {

    @RequestMapping("test1")
    public Mono<String> test1(){
        return Mono.fromRunnable(() ->{
            log.info("start...");
            try {
                TimeUnit.SECONDS.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("...end");
        });
    }

    @GetMapping("test2")
    public Flux<String> test2(){

        return Flux.from((Publisher) s -> log.info("...in Publisher..."));

    }
}