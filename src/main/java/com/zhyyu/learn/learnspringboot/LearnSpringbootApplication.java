package com.zhyyu.learn.learnspringboot;

import com.zhyyu.learn.learnspringboot.cors.CORSHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * LearnSpringbootApplication
 * <pre>
 *      @SpringBootApplication javadoc:
 *      This is a convenience annotation that is equivalent to declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.
 * </pre>
 */
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
