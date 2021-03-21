package com.zhyyu.learn.learnspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("hello1")
    public String hello1() throws InterruptedException {
        Thread.sleep(100L);
        return "hello1";
    }

}
