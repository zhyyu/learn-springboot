package com.zhyyu.learn.learnspringboot.config;

/**
 * boot 配置优先级(可同时使用多种方式配置, 但高优先级覆盖低优先级, 如1 覆盖 2
 * <pre>
 *     1. 命令行参数                     // java -jar .\learn-springboot-0.0.1-SNAPSHOT.jar --server.port=9999
 *     2. java:comp/env里的JNDI属性     // TBD
 *     3. JVM系统属性                   // TBD
 *     4. 操作系统环境变量              // TBD
 *     5. 随机生成的带random.*前缀的属性（在设置其他属性时，可以引用它们，比如${random.long}）  // TBD
 *     6. 应用程序以外的application.properties或者appliaction.yml文件
 *          - 6.1 learn-springboot-0.0.1-SNAPSHOT.jar 当前目录 ./config/application.properties  // 6.1 > 6.2
 *          - 6.2.learn-springboot-0.0.1-SNAPSHOT.jar 当前目录 ./application.properties
 *     7. 打包在应用程序内的application.properties或者appliaction.yml文件
 *          - 7.1 resources 目录 config/application.properties    // 7.1 > 7.2
 *          - 7.2 resources 目录 application.properties
 *     8. 通过@PropertySource标注的属性源   // TBD
 *     9. 默认属性, 如server.port 默认为8080
 *
 * </pre>
 */
public class ConfigPrecedenceTest {
}
