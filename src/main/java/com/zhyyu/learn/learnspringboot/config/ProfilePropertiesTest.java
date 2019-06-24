package com.zhyyu.learn.learnspringboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * ProfilePropertiesTest
 * <pre>
 *      1. 若不指定profile 则使用 default profile, 对应 application.properties
 *      2. 可在 application.properties 指定 spring.profiles.active=test1, 则添加application-test1.properties 生效 (注意会被命令行 --spring.profiles.active=test2 覆盖)
 *      3. 命令行指定profile (--spring.profiles.active=test1),application-test1.properties 生效, application.properties 依然生效, 但相同key 会被test1 覆盖
 * </pre>
 * @author juror
 * @datatime 2019/6/24 10:00
 */
@Component
public class ProfilePropertiesTest {

    @Autowired
    private Environment environment;

//    @PostConstruct
    private void testProfileProperties() {
        System.out.println(Arrays.asList(environment.getDefaultProfiles()));
        System.out.println(Arrays.asList(environment.getActiveProfiles()));

        System.out.println(environment.getProperty("profile-default-properties1"));
        System.out.println(environment.getProperty("profile-test1-properties1"));
        System.out.println(environment.getProperty("profile-test2-properties1"));
    }

}

/**
 *  java -jar .\learn-springboot-0.0.1-SNAPSHOT.jar
 *
 * [default]
 * []
 * pdp1
 * null
 * null
 *
 * ps: 如果在 application.properties 中写 spring.profiles.active=test1, 则会添加启用 application-test1.properties
 *
 * [default]
 * [test1]
 * pdp1
 * pt1p1
 * null
 *
 * =======================================================================
 * java -jar .\learn-springboot-0.0.1-SNAPSHOT.jar --spring.profiles.active=test1
 *
 * [default]
 * [test1]
 * pdp1
 * pt1p1
 * null
 *
 * ps: 如果在 application-test1.properties 中写 profile-default-properties1=pt1dp1, 则会覆盖 application.properties 中 profile-default-properties1
 *
 * [default]
 * [test1]
 * pt1dp1
 * pt1p1
 * null
 *
 * =======================================================================
 * java -jar .\learn-springboot-0.0.1-SNAPSHOT.jar --spring.profiles.active=test2
 *
 * [default]
 * [test2]
 * pdp1
 * null
 * pt2p1
 *
 */