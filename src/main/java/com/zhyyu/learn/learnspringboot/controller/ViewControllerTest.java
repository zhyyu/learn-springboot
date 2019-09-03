package com.zhyyu.learn.learnspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author juror
 * @datatime 2019/9/3 18:46
 */
@Controller
@RequestMapping("view-test")
public class ViewControllerTest {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

}
