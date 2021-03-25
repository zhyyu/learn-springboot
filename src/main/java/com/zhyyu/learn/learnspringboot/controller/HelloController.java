package com.zhyyu.learn.learnspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@Slf4j
public class HelloController {

    @RequestMapping("hello1")
    public String hello1() throws InterruptedException {
        Thread.sleep(100L);
        log.info("hello1 info log");
        return "hello1";
    }

    @RequestMapping("hello2")
    public String hello2() throws InterruptedException {
        log.error("hello2 error log");
        throw new RuntimeException("myexp");
    }

}
