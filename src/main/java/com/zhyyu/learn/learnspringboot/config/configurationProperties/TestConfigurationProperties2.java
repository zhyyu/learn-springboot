package com.zhyyu.learn.learnspringboot.config.configurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author juror
 * @datatime 2019/9/9 10:40
 */
//@Component
//@EnableConfigurationProperties(MyConfigurationProperties.class)
public class TestConfigurationProperties2 implements CommandLineRunner {

    @Autowired
    private MyConfigurationProperties myConfigurationProperties;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(args);
        System.out.println(Arrays.asList(args));

        System.out.println("TestConfigurationProperties2============" + myConfigurationProperties.getKey1());
        System.out.println("TestConfigurationProperties2============" + myConfigurationProperties.getKey2());

    }

}

/**
 * TestConfigurationProperties @EnableConfigurationProperties(MyConfigurationProperties.class) 后, TestConfigurationProperties2 依然可以注入 MyConfigurationProperties
 *
 * TestConfigurationProperties2============value1
 * TestConfigurationProperties2============value2
 */
