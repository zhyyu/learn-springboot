package com.zhyyu.learn.learnspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
    public String hello(HttpServletResponse response) {
//        Cookie cookie = new Cookie("cookie-key", "cookie-value");
//        cookie.setPath("xpath");
//        cookie.setDomain("google.com");

//        response.addCookie(cookie);
        return "hello!";
    }

    @RequestMapping("/multipartFile")
    public String multipartFile(MultipartFile file, MultipartFile pic, String field1) {
        return "name: " + file.getName() + ", filename: " + file.getOriginalFilename() + ", field1: " + field1 + ", pic filename:" + pic.getOriginalFilename();
    }

}
