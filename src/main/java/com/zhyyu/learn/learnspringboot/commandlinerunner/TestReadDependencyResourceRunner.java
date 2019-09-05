package com.zhyyu.learn.learnspringboot.commandlinerunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

/**
 * 测试 CommandLineRunner, 顺带测试读取dependency jar 稳健
 * <pre>
 *     1. ResourcePatternResolver 可读取依赖 jar resources 文件与.class 和 META-INF 中文件, 但必须 classpath*: 开头
 *     2. 若 classpath:/ 开头, 则仅能读取本jar 包文件
 * </pre>
 *
 * @author juror
 * @datatime 2019/9/5 23:04
 */
//@Component
@Slf4j
public class TestReadDependencyResourceRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ClassLoader cl = this.getClass().getClassLoader();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
//        Resource[] resources = resolver.getResources("classpath*:/**/*.txt") ;
//        Resource[] resources = resolver.getResources("classpath:/**/*.txt") ;
        Resource[] resources = resolver.getResources("classpath:/**") ;
        for (Resource resource: resources){
            log.info(resource.getFilename());
        }
    }
}

/**
 * C:/juror/eclipse-workspace/zhyyu-learn-workspace/learn-springcloud-provider-api/target/classes/myresource1.txt
 * URL [jar:file:/C:/Users/juror/.m2/repository/org/springframework/spring-context/5.1.8.RELEASE/spring-context-5.1.8.RELEASE.jar!/META-INF/notice.txt]
 * C:/juror/eclipse-workspace/zhyyu-learn-workspace/learn-springboot/target/classes/com/zhyyu/learn/learnspringboot/LearnSpringbootApplication.class
 *
 */