package com.zhyyu.learn.learnspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestControllerTest
 * <pre>
 *     1. 访问 http://localhost:8000/test/hello, 返回 hello 字符串
 *     2. starter-web 自动帮配置好DispatcherServlet 等
 * </pre>
 */
@RestController
@RequestMapping("/test")
public class RestControllerTest {

    @RequestMapping("/hello")
    public String hello() {
        return "hello!";
    }

}
