package com.zhyyu.learn.learnspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ValueAnnoTest
 * <pre>
 *     1. @Value 注入属性配置值, 如  @Value(" ${server.port} "), 可为, application.properties 中 server.port=8000
 *     2. @Value 在 @PostConstruct 前执行
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
