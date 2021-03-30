package com.task.ratemanagementsystem.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping(value = "/health")
    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        return "Welcome Hystrix";
    }
    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }
}
