package com.zhyyu.learn.learnspringboot.config.configurationProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author juror
 * @datatime 2019/9/9 10:31
 */
//@ConfigurationProperties(prefix = "my")
@Data
//@Configuration
public class MyConfigurationProperties {

    private String key1;
    private String key2 = "value222";

}
