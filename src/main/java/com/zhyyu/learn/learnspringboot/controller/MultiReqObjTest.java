package com.zhyyu.learn.learnspringboot.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author juror
 * @datatime 2019/8/12 18:26
 */
@RestController
@RequestMapping("/test")
public class MultiReqObjTest {

    @RequestMapping("/multiObjReq")
    public String multiObjReq(MyObj1 myObj1, MyObj2 myObj2, String key5) {
        return myObj1.toString() + "___" + myObj2.toString() + "___" + key5;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class MyObj1 {
        private String key1;
        private String key2;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class MyObj2 {
        private String key3;
        private String key4;
    }

}
