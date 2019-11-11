package com.zhyyu.learn.learnspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author juror
 * @datatime 2019/11/11 11:08
 */
@RestController
@RequestMapping("WildcardAndPlaceholderTest")
public class WildcardAndPlaceholderTest {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("test1")
    public String test1() {
        System.out.println(httpServletRequest.getContextPath());
        System.out.println(httpServletRequest.getHttpServletMapping());
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getRequestURL());
        System.out.println(httpServletRequest.getServletPath());
        System.out.println(httpServletRequest.getPathInfo());

        return "hello";
    }

    /**
     * 临时加上ctp contextpath
     * /
     * ctp
     * org.apache.catalina.core.ApplicationMapping$MappingImpl@5894de6
     * /ctp/WildcardAndPlaceholderTest/test1
     * http://127.0.0.1:8000/ctp/WildcardAndPlaceholderTest/test1
     * /WildcardAndPlaceholderTest/test1
     * null
     */

    @RequestMapping("test2/**")
    public String test2() {
        System.out.println(httpServletRequest.getContextPath());
        System.out.println(httpServletRequest.getHttpServletMapping());
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getRequestURL());
        System.out.println(httpServletRequest.getServletPath());
        System.out.println(httpServletRequest.getPathInfo());

        return "hello2";
    }

    /**
     * 去除 ctp contextpath
     * org.apache.catalina.core.ApplicationMapping$MappingImpl@16e88f7c
     * /WildcardAndPlaceholderTest/test2/abc
     * http://127.0.0.1:8000/WildcardAndPlaceholderTest/test2/abc
     * /WildcardAndPlaceholderTest/test2/abc
     * null
     */

    @RequestMapping("test3/{path1}/**")
    public String test3(@PathVariable String path1) {
        System.out.println(path1);

        System.out.println(httpServletRequest.getContextPath());
        System.out.println(httpServletRequest.getHttpServletMapping());
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getRequestURL());
        System.out.println(httpServletRequest.getServletPath());
        System.out.println(httpServletRequest.getPathInfo());

        return "hello3";
    }

    /**
     * abc
     *
     * org.apache.catalina.core.ApplicationMapping$MappingImpl@86a7aa3
     * /WildcardAndPlaceholderTest/test3/abc/def
     * http://127.0.0.1:8000/WildcardAndPlaceholderTest/test3/abc/def
     * /WildcardAndPlaceholderTest/test3/abc/def
     * null
     */

}
