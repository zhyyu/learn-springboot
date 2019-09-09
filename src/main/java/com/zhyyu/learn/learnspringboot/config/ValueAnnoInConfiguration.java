package com.zhyyu.learn.learnspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author juror
 * @datatime 2019/8/13 14:40
 */
//@Configuration
public class ValueAnnoInConfiguration {

    @Bean
    public MyObj getMyObj(@Value("${server.port}") Integer port) {
        System.out.println("myobj port: " + port);
        return new MyObj();
    }

    public static class MyObj {
        @PostConstruct
        public void init() {
            System.out.println("MyObj inited");
        }
    }

}
