package com.zhyyu.learn.learnspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("hello")
@Slf4j
public class HelloController {

    @Autowired
    private HelloService helloService;

    private HelloService2 helloService2 = new HelloService2();

    @RequestMapping("hello1")
    public String hello1() throws InterruptedException {
        log.info("hello1 info log");
        return "hello1";
    }

    @RequestMapping("hello2")
    public String hello2() throws InterruptedException {
        log.error("hello2 error log");
        throw new RuntimeException("myexp");
    }

    @RequestMapping("hello3")
    public String hello3() throws InterruptedException, ExecutionException {
        log.info("hello3 info log");
//        return "hello3" + " _ " + helloService.hello() + " _ " + helloService.hello2() + " _ " + helloService2.hello() + " _ " + helloService2.hello2();
//        return "hello3" + " _ " + helloService.hello2();
        return "hello3" + " _ " + helloService.hello() + " _ " + helloService.hello2() + " _ " + helloService2.hello() + " _ " +helloService2.hello2();
    }

    @RequestMapping("hello4")
    public String hello4() throws InterruptedException {
        return "hello4 ret";
    }

    @RequestMapping("hello5")
    public String hello5() throws InterruptedException {
        throw new RuntimeException("123");
    }

    @RequestMapping("hello6")
    public String hello6() throws InterruptedException {
        helloService.hello2();
        throw new RuntimeException("hello6_exception");
    }

}
