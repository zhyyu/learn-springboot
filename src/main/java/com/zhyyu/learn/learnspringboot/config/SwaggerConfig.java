package com.zhyyu.learn.learnspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 测试
 * http://localhost:8000/v2/api-docs
 * http://localhost:8000/swagger-ui.html#/
 *
 * <pre>
 *     参考 https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api, 例子中 "http://localhost:8080/spring-security-rest/api/v2/api-docs" 替换为
 *      http://localhost:8000/api/v2/api-docs 404 异常
 *
 *      解决步骤
 *      1. 使用actuator, http://localhost:8000/actuator/mappings, 查找 api-docs (未找到), 但找到 /swagger-resources
 *      2. 尝试请求 http://localhost:8000/swagger-resources 返回
 *          [
         *     {
         *         "name": "default",
         *         "url": "/v2/api-docs",
         *         "swaggerVersion": "2.0",
         *         "location": "/v2/api-docs"
         *     }
         * ]
 *      3. 尝试访问2 中返回url, http://localhost:8000/v2/api-docs (无api 前缀), 得到结果, (但为何 api-docs 未在actuator/mappings 中展示??)
 * </pre>
 *
 * @author juror
 * @datatime 2019/8/26 12:25
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
