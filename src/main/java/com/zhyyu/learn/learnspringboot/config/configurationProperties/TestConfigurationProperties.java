package com.zhyyu.learn.learnspringboot.config.configurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 测试 ConfigurationProperties
 * <pre>
 *     0. 要使用 ConfigurationProperties 需引入 spring-boot-configuration-processor maven 构件 (不引也可? 可以启动, 但idea 提示异常 "Spring Boot Configuration Annotation Processor not found in classpath)
 *     1. @ConfigurationProperties(prefix = "my") 可把properties 文件中对应配置注入到配置bean
 *     2. 若想@Autowired 被注解配置bean, 两种方法, @EnableConfigurationProperties(MyConfigurationProperties.class) 在要使用bean 上, 或者配置bean 上加上@Configuration
 *          - 两种生效均为全局生效, 配置bean 放入springContext 中, 即使是 有一bean @EnableConfigurationProperties(MyConfigurationProperties.class) , 其他bean 也可注入 MyConfigurationProperties
 *     3. properties 中配置会覆盖 MyConfigurationProperties 中默认配置
 * </pre>
 *
 * @author juror
 * @datatime 2019/9/9 10:40
 */
//@Component
//@EnableConfigurationProperties(MyConfigurationProperties.class)
public class TestConfigurationProperties implements CommandLineRunner {

    @Autowired
    private MyConfigurationProperties myConfigurationProperties;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(args);
        System.out.println(Arrays.asList(args));

        System.out.println(myConfigurationProperties.getKey1());
        System.out.println(myConfigurationProperties.getKey2());

    }

}

/**
 * 未设置properties 文件
 * null
 * value222
 *
 * 设置properties 文件
 * my.key1=value1
 * my.key2=value2
 *
 * 结果:
 * value1
 * value2
 */
