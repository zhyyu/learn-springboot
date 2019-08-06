package com.zhyyu.learn.learnspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ValueAnnoTest
 * <pre>
 *     1. @Value 注入属性配置值, 如  @Value(" ${server.port} "), 可为, application.properties 中 server.port=8000
 *     2. @Value 在 @PostConstruct 前执行
 *
 *     -------------------
 *     1. 若本地配置文件无相关 @Value 值, 则项目mvn package 异常
 *          - Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'outer.config.key1' in value " ${outer.config.key1} "
 *          - com.zhyyu.learn.learnspringboot.controller.RestControllerTest#key1
 *     2. @Autowire environment, 引用外部文件配置, 外部文件修改, environment.getProperty 不变
 * </pre>
 */
@Component
public class ValueAnnoTest {

    @Value(" ${server.port} ")
    private String serverPort;

    @PostConstruct
    private void postConstruct() {
        System.out.println("ValueAnnoTest-serverPort: " + serverPort);
    }

}
