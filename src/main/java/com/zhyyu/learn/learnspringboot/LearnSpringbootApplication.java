package com.zhyyu.learn.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * LearnSpringbootApplication
 * <pre>
 *      @SpringBootApplication javadoc:
 *      This is a convenience annotation that is equivalent to declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.
 * </pre>
 */
@EnableAsync
@EnableRetry
@SpringBootApplication
public class LearnSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringbootApplication.class, args);
        /*System.out.println("==========classloader==========" + LearnSpringbootApplication.class.getClassLoader());
        System.out.println("==========classloader==========" + HandlerInterceptor.class.getClassLoader());
        System.out.println("==========classloader==========" + CORSHandlerInterceptor.class.getClassLoader());
        System.out.println("==========classloader==========" + String.class.getClassLoader());*/
    }

}
