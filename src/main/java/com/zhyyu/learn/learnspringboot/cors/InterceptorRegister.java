package com.zhyyu.learn.learnspringboot.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author juror
 * @datatime 2019/9/3 20:49
 */
//@Configuration
public class InterceptorRegister implements WebMvcConfigurer {

    @Autowired
    @Qualifier("CORSHandlerInterceptor")
    private HandlerInterceptor corsHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsHandlerInterceptor);
    }
}
