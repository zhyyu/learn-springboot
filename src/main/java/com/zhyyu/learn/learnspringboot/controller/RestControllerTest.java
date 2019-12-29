package com.zhyyu.learn.learnspringboot.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * maven package error (该key 在外部properties 配置)
     * Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'outer.config.key1' in value " ${outer.config.key1} "
     */
//    @Value(" ${outer.config.key1} ")
    private String key1;

    @Autowired
    private Environment environment;

    /**
     * 热替换不可; 外部配置文件无法注入key1, maven package 报错
     */
    @RequestMapping("/outerFromValue")
    public String outerFromValue() {
        return key1;
    }

    /**
     * 热替换不可; 修改外部配置文件 uter.config.key1, outerFromEnv 依然返回修改前值
     */
    @RequestMapping("/outerFromEnv")
    public String outerFromEnv() {
        return environment.getProperty("outer.config.key1");
    }



    @RequestMapping("/hello")
    public String hello(HttpServletResponse response) throws InterruptedException {
//        Cookie cookie = new Cookie("cookie-key", "cookie-value");
//        cookie.setPath("xpath");
//        cookie.setDomain("google.com");

//        response.addCookie(cookie);
        Thread.sleep(6000);
        return "hello!";
    }

    // http code 500
    /**
     * HTTP/1.1 500
     * Content-Type: text/html;charset=ISO-8859-1
     * Content-Language: zh-CN
     * Content-Length: 318
     * Date: Wed, 07 Aug 2019 01:13:13 GMT
     * Connection: close
     *
     * @param response
     * @return
     */
    @RequestMapping("/hello2")
    public String hello2(HttpServletResponse response) {
        throw new RuntimeException();
//        return "hello!";
    }

    @RequestMapping("/multipartFile")
    public String multipartFile(MultipartFile file, MultipartFile pic, String field1) {
        return "name: " + file.getName() + ", filename: " + file.getOriginalFilename() + ", field1: " + field1 + ", pic filename:" + pic.getOriginalFilename();
    }

    /**
     * 测试mvc boolean 转换
     * <pre>
     *      * 2        ->> 异常
     *      * 1        ->> true
     *      * 0        ->> false
     *      * -1       ->> 异常
     *      * -2       ->> 异常
     *      *
     *      * 'true'   ->> true
     *      * 'false'  ->> false
     *      * ''       ->> 异常
     * </pre>

     * @param aBool
     * @return
     */
    @RequestMapping("/test-boolean")
    public String testBoolean(Boolean aBool) {
        return aBool.toString();
    }

    /**
     * 请求内容:
     * Content-Type: application/x-www-form-urlencoded
     * key1=value1&key2=value2
     *
     * Content-Type: text/plain
     * Content-Type: application/json
     * {
     *  "key1":"value1",
     *  "key2":"value2"
     * }
     *
     * 结论:
     * 1. 若不加 @RequestBody  注解, application/x-www-form-urlencoded, text/plain, application/json 均无报错, 但仅 application/x-www-form-urlencoded 传入数据
     * 2. 若加 @RequestBody  注解, application/x-www-form-urlencoded, text/plain 异常, application/json 正常且传入数据
     */
    @RequestMapping("/formOrJson")
    public String formOrJson(MyObj myObj) {
//    public String formOrJson(@RequestBody MyObj myObj) {
        return myObj.toString();
    }
    /**
     * 未添加 @RequestBody
     * - Content-Type: application/x-www-form-urlencoded
     *      RestControllerTest.MyObj(key1=value1, key2=value2)
     * - Content-Type: text/plain
     *      RestControllerTest.MyObj(key1=null, key2=null)
     * - Content-Type: application/json
     *      RestControllerTest.MyObj(key1=null, key2=null)
     *
     *
     *  添加 @RequestBody 后
     *  - Content-Type: application/x-www-form-urlencoded
     * {
     *     "timestamp": "2019-08-07T04:13:59.536+0000",
     *     "status": 415,
     *     "error": "Unsupported Media Type",
     *     "message": "Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported",
     *     "path": "/test/formOrJson"
     * }
     * - Content-Type: text/plain
     * {
     *     "timestamp": "2019-08-07T04:16:00.832+0000",
     *     "status": 415,
     *     "error": "Unsupported Media Type",
     *     "message": "Content type 'text/plain;charset=UTF-8' not supported",
     *     "path": "/test/formOrJson"
     * }
     * - Content-Type: application/json
     * RestControllerTest.MyObj(key1=value1, key2=value2)
     */

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MyObj {
        private String key1;
        private String key2;
    }

    /**
     * * Content-Type: text/plain
     *      * {
     *      *  "key1":"value1",
     *      *  "key2":"value2"
     *      * }
     * @return
     *
     *
     *
     * 无异常, 值注入myStr, @RequestBody 接受text/plain body, 需使用String 类型接受
     */
    @RequestMapping("/testTextPlain")
    public String testTextPlain(@RequestBody String myStr) {
        return myStr;
    }

}
