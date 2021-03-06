# actuator_test
### precedence
- application.properties
management.endpoints.web.exposure.include=*

### test
- http://localhost:8000/actuator/beans
    - 查看所有bean 及依赖, 如JdbcTemplateTest
```json
  {
        "aliases": [],
        "scope": "singleton",
        "type": "com.zhyyu.learn.learnspringboot.jdbc.JdbcTemplateTest",
        "resource": "file [C:\\juror\\eclipse-workspace\\zhyyu-learn-workspace\\learn-springboot\\target\\classes\\com\\zhyyu\\learn\\learnspringboot\\jdbc\\JdbcTemplateTest.class]",
        "dependencies": ["jdbcTemplate"]
    }
```

- http://localhost:8000/actuator/env
    - 查看servlet 参数, 系统变量, 环境变量, 配置变量
```json
[{
    "name": "server.ports",
    "properties": {
        "local.server.port": {
            "value": 8000
        }
    }
},
{
    "name": "servletContextInitParams",
    "properties": {}
},
{
    "name": "systemProperties",
    "properties": {
        "java.runtime.name": {
            "value": "Java(TM) SE Runtime Environment"
        },
        "spring.output.ansi.enabled": {
            "value": "always"
        },
        "sun.boot.library.path": {
            "value": "C:\\juror\\tech\\Java\\jdk1.8.0_201\\jre\\bin"
        },
        "java.vm.version": {
            "value": "25.201-b09"
        }}},
{
    "name": "systemEnvironment",
    "properties": {
        "configsetroot": {
            "value": "C:\\Windows\\ConfigSetRoot",
            "origin": "System Environment Property \"configsetroot\""
        },
        "USERDOMAIN_ROAMINGPROFILE": {
            "value": "DESKTOP-I9V3DMB",
            "origin": "System Environment Property \"USERDOMAIN_ROAMINGPROFILE\""
        },
        "LOCALAPPDATA": {
            "value": "C:\\Users\\juror\\AppData\\Local",
            "origin": "System Environment Property \"LOCALAPPDATA\""
        },
        "PROCESSOR_LEVEL": {
            "value": "6",
            "origin": "System Environment Property \"PROCESSOR_LEVEL\""
        }}},
{
    "name": "applicationConfig: [classpath:/application.properties]",
    "properties": {
        "server.port": {
            "value": "8000",
            "origin": "class path resource [application.properties]:2:13"
        },
        "spring.datasource.url": {
            "value": "jdbc:mysql://localhost/my_db?serverTimezone=Asia/Shanghai&characterEncoding=utf8",
            "origin": "class path resource [application.properties]:5:23"
        },
        "spring.datasource.username": {
            "value": "root",
            "origin": "class path resource [application.properties]:6:28"
        },
        "spring.datasource.password": {
            "value": "******",
            "origin": "class path resource [application.properties]:7:28"
        },
        "profile-default-properties1": {
            "value": "pdp1",
            "origin": "class path resource [application.properties]:11:29"
        },
        "management.endpoints.web.exposure.include": {
            "value": "*",
            "origin": "class path resource [application.properties]:14:43"
        }
    }
}]
```

- http://localhost:8000/actuator/env/spring.datasource.url
    - 查看指定变量
```json
{
	"property": {
		"source": "applicationConfig: [classpath:/application.properties]",
		"value": "jdbc:mysql://localhost/my_db?serverTimezone=Asia/Shanghai&characterEncoding=utf8"
	},
	"activeProfiles": [],
	"propertySources": [{
			"name": "server.ports"
		}, {
			"name": "servletConfigInitParams"
		}, {
			"name": "servletContextInitParams"
		}, {
			"name": "systemProperties"
		}, {
			"name": "systemEnvironment"
		}, {
			"name": "random"
		}, {
			"name": "applicationConfig: [classpath:/application.properties]",
			"property": {
				"value": "jdbc:mysql://localhost/my_db?serverTimezone=Asia/Shanghai&characterEncoding=utf8",
				"origin": "class path resource [application.properties]:5:23"
			}
		}, {
			"name": "Management Server"
		}
	]
}
```

- http://localhost:8000/actuator/configprops
    - 查看所有配置项, 可参考后自定义application.properties
```json
{
	"contexts": {
		"application": {
			"beans": {
				"spring.transaction-org.springframework.boot.autoconfigure.transaction.TransactionProperties": {
					"prefix": "spring.transaction",
					"properties": {}
				},
				"management.trace.http-org.springframework.boot.actuate.autoconfigure.trace.http.HttpTraceProperties": {
					"prefix": "management.trace.http",
					"properties": {
						"include": ["REQUEST_HEADERS", "TIME_TAKEN", "COOKIE_HEADERS", "RESPONSE_HEADERS"]
					}
				},
				"management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties": {
					"prefix": "management.endpoints.web",
					"properties": {
						"pathMapping": {},
						"exposure": {
							"include": ["*"],
							"exclude": []
						},
						"basePath": "/actuator"
					}
				},
				"spring.jdbc-org.springframework.boot.autoconfigure.jdbc.JdbcProperties": {
					"prefix": "spring.jdbc",
					"properties": {
						"template": {
							"fetchSize": -1,
							"maxRows": -1
						}
					}
				},
				"spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties": {
					"prefix": "spring.jackson",
					"properties": {
						"serialization": {},
						"visibility": {},
						"parser": {},
						"deserialization": {},
						"generator": {},
						"mapper": {}
					}
				},
				"spring.http-org.springframework.boot.autoconfigure.http.HttpProperties": {
					"prefix": "spring.http",
					"properties": {
						"encoding": {
							"charset": "UTF-8",
							"force": false,
							"forceRequest": false,
							"forceResponse": false
						},
						"logRequestDetails": false
					}
				},
				"spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties": {
					"prefix": "spring.info",
					"properties": {
						"build": {
							"location": {},
							"encoding": "UTF-8"
						},
						"git": {
							"location": {},
							"encoding": "UTF-8"
						}
					}
				},
				"spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties": {
					"prefix": "spring.datasource",
					"properties": {
						"password": "******",
						"initializationMode": "EMBEDDED",
						"generateUniqueName": false,
						"xa": {
							"properties": {}
						},
						"separator": ";",
						"url": "jdbc:mysql://localhost/my_db?serverTimezone=Asia/Shanghai&characterEncoding=utf8",
						"platform": "all",
						"continueOnError": false,
						"username": "root"
					}
				},
				"management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties": {
					"prefix": "management.endpoint.health",
					"properties": {
						"showDetails": "NEVER",
						"roles": []
					}
				},
				"spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties": {
					"prefix": "spring.resources",
					"properties": {
						"addMappings": true,
						"chain": {
							"cache": true,
							"htmlApplicationCache": false,
							"compressed": false,
							"strategy": {
								"fixed": {
									"enabled": false,
									"paths": ["/**"]
								},
								"content": {
									"enabled": false,
									"paths": ["/**"]
								}
							}
						},
						"cache": {
							"cachecontrol": {}
						},
						"staticLocations": ["classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"]
					}
				},
				"management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties": {
					"prefix": "management.metrics",
					"properties": {
						"distribution": {
							"percentilesHistogram": {},
							"percentiles": {},
							"sla": {},
							"minimumExpectedValue": {},
							"maximumExpectedValue": {}
						},
						"web": {
							"client": {
								"requestsMetricName": "http.client.requests",
								"maxUriTags": 100
							},
							"server": {
								"autoTimeRequests": true,
								"requestsMetricName": "http.server.requests",
								"maxUriTags": 100
							}
						},
						"enable": {},
						"useGlobalRegistry": true,
						"tags": {}
					}
				},
				"spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties": {
					"prefix": "spring.mvc",
					"properties": {
						"contentnegotiation": {
							"favorPathExtension": false,
							"favorParameter": false,
							"mediaTypes": {}
						},
						"servlet": {
							"path": "/",
							"loadOnStartup": -1
						},
						"staticPathPattern": "/**",
						"dispatchOptionsRequest": true,
						"dispatchTraceRequest": false,
						"ignoreDefaultModelOnRedirect": true,
						"logResolvedException": false,
						"async": {},
						"view": {},
						"localeResolver": "ACCEPT_HEADER",
						"pathmatch": {
							"useSuffixPattern": false,
							"useRegisteredSuffixPattern": false
						},
						"throwExceptionIfNoHandlerFound": false
					}
				},
				"management.info-org.springframework.boot.actuate.autoconfigure.info.InfoContributorProperties": {
					"prefix": "management.info",
					"properties": {
						"git": {
							"mode": "SIMPLE"
						}
					}
				},
				"spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties": {
					"prefix": "spring.task.execution",
					"properties": {
						"pool": {
							"queueCapacity": 2147483647,
							"coreSize": 8,
							"maxSize": 2147483647,
							"allowCoreThreadTimeout": true,
							"keepAlive": {
								"units": ["SECONDS", "NANOS"]
							}
						},
						"threadNamePrefix": "task-"
					}
				},
				"management.health.status-org.springframework.boot.actuate.autoconfigure.health.HealthIndicatorProperties": {
					"prefix": "management.health.status",
					"properties": {
						"httpMapping": {}
					}
				},
				"management.server-org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties": {
					"prefix": "management.server",
					"properties": {
						"servlet": {
							"contextPath": ""
						}
					}
				},
				"management.endpoint.configprops-org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointProperties": {
					"prefix": "management.endpoint.configprops",
					"properties": {}
				},
				"management.endpoints.jmx-org.springframework.boot.actuate.autoconfigure.endpoint.jmx.JmxEndpointProperties": {
					"prefix": "management.endpoints.jmx",
					"properties": {
						"staticNames": {},
						"exposure": {
							"include": [],
							"exclude": []
						},
						"domain": "org.springframework.boot"
					}
				},
				"spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties": {
					"prefix": "spring.task.scheduling",
					"properties": {
						"pool": {
							"size": 1
						},
						"threadNamePrefix": "scheduling-"
					}
				},
				"management.endpoints.web.cors-org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties": {
					"prefix": "management.endpoints.web.cors",
					"properties": {
						"allowedHeaders": [],
						"allowedMethods": [],
						"allowedOrigins": [],
						"maxAge": {
							"units": ["SECONDS", "NANOS"]
						},
						"exposedHeaders": []
					}
				},
				"management.metrics.export.simple-org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties": {
					"prefix": "management.metrics.export.simple",
					"properties": {
						"mode": "CUMULATIVE",
						"step": {
							"units": ["SECONDS", "NANOS"]
						}
					}
				},
				"management.endpoint.env-org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointProperties": {
					"prefix": "management.endpoint.env",
					"properties": {}
				},
				"management.endpoint.logfile-org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointProperties": {
					"prefix": "management.endpoint.logfile",
					"properties": {}
				},
				"server-org.springframework.boot.autoconfigure.web.ServerProperties": {
					"prefix": "server",
					"properties": {
						"undertow": {
							"maxHttpPostSize": {},
							"eagerFilterInit": true,
							"accesslog": {
								"enabled": false,
								"pattern": "common",
								"prefix": "access_log.",
								"suffix": "log",
								"dir": "C:\\juror\\eclipse-workspace\\zhyyu-learn-workspace\\logs",
								"rotate": true
							}
						},
						"port": 8000,
						"maxHttpHeaderSize": {},
						"tomcat": {
							"accesslog": {
								"enabled": false,
								"pattern": "common",
								"directory": "logs",
								"prefix": "access_log",
								"suffix": ".log",
								"rotate": true,
								"renameOnRotate": false,
								"fileDateFormat": ".yyyy-MM-dd",
								"requestAttributesEnabled": false,
								"buffered": true
							},
							"internalProxies": "10\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}|192\\.168\\.\\d{1,3}\\.\\d{1,3}|169\\.254\\.\\d{1,3}\\.\\d{1,3}|127\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}|172\\.1[6-9]{1}\\.\\d{1,3}\\.\\d{1,3}|172\\.2[0-9]{1}\\.\\d{1,3}\\.\\d{1,3}|172\\.3[0-1]{1}\\.\\d{1,3}\\.\\d{1,3}|0:0:0:0:0:0:0:1|::1",
							"protocolHeaderHttpsValue": "https",
							"portHeader": "X-Forwarded-Port",
							"backgroundProcessorDelay": {
								"units": ["SECONDS", "NANOS"]
							},
							"maxThreads": 200,
							"minSpareThreads": 10,
							"maxHttpPostSize": {},
							"maxHttpHeaderSize": {},
							"maxSwallowSize": {},
							"redirectContextRoot": true,
							"uriEncoding": "UTF-8",
							"maxConnections": 10000,
							"acceptCount": 100,
							"additionalTldSkipPatterns": [],
							"resource": {
								"allowCaching": true
							}
						},
						"servlet": {
							"contextParameters": {},
							"applicationDisplayName": "application"
						},
						"jetty": {
							"accesslog": {
								"enabled": false,
								"retentionPeriod": 31,
								"append": false,
								"extendedFormat": false,
								"dateFormat": "dd/MMM/yyyy:HH:mm:ss Z",
								"timeZone": "GMT",
								"logCookies": false,
								"logServer": false,
								"logLatency": false
							},
							"maxHttpPostSize": {},
							"acceptors": -1,
							"selectors": -1
						},
						"error": {
							"path": "/error",
							"includeException": false,
							"includeStacktrace": "NEVER",
							"whitelabel": {
								"enabled": true
							}
						}
					}
				},
				"spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties": {
					"prefix": "spring.servlet.multipart",
					"properties": {
						"fileSizeThreshold": {},
						"maxFileSize": {},
						"maxRequestSize": {},
						"enabled": true,
						"resolveLazily": false
					}
				},
				"dataSource": {
					"prefix": "spring.datasource.hikari",
					"properties": {
						"initializationFailTimeout": 1,
						"validationTimeout": 5000,
						"hikariPoolMXBean": {},
						"readOnly": false,
						"registerMbeans": false,
						"healthCheckProperties": {},
						"isolateInternalQueries": false,
						"leakDetectionThreshold": 0,
						"maxLifetime": 1800000,
						"minimumIdle": 10,
						"password": "******",
						"metricsTrackerFactory": {},
						"allowPoolSuspension": false,
						"idleTimeout": 600000,
						"dataSourceProperties": {},
						"driverClassName": "com.mysql.cj.jdbc.Driver",
						"jdbcUrl": "jdbc:mysql://localhost/my_db?serverTimezone=Asia/Shanghai&characterEncoding=utf8",
						"loginTimeout": 30,
						"maximumPoolSize": 10,
						"autoCommit": true,
						"connectionTimeout": 30000,
						"username": "root",
						"poolName": "HikariPool-1"
					}
				},
				"diskSpaceHealthIndicatorProperties": {
					"prefix": "management.health.diskspace",
					"properties": {
						"path": "C:\\juror\\eclipse-workspace\\zhyyu-learn-workspace\\.",
						"threshold": {}
					}
				}
			},
			"parentId": null
		}
	}
}

```

- http://localhost:8000/actuator/mappings
    - 查看servlets servletFilters handlerMapping 信息
```json
{
	"contexts": {
		"application": {
			"mappings": {
				"dispatcherServlets": {
					"dispatcherServlet": [{
							"handler": "ResourceHttpRequestHandler [class path resource [META-INF/resources/], class path resource [resources/], class path resource [static/], class path resource [public/], ServletContext resource [/], class path resource []]",
							"predicate": "/**/favicon.ico",
							"details": null
						}, {
							"handler": "Actuator web endpoint 'auditevents'",
							"predicate": "{GET /actuator/auditevents, produces [application/vnd.spring-boot.actuator.v2+json || application/json]}",
							"details": {
								"handlerMethod": {
									"className": "org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping.OperationHandler",
									"name": "handle",
									"descriptor": "(Ljavax/servlet/http/HttpServletRequest;Ljava/util/Map;)Ljava/lang/Object;"
								},
								"requestMappingConditions": {
									"consumes": [],
									"headers": [],
									"methods": ["GET"],
									"params": [],
									"patterns": ["/actuator/auditevents"],
									"produces": [{
											"mediaType": "application/vnd.spring-boot.actuator.v2+json",
											"negated": false
										}, {
											"mediaType": "application/json",
											"negated": false
										}
									]
								}
							}
						}, {
							"handler": "Actuator web endpoint 'beans'",
							"predicate": "{GET /actuator/beans, produces [application/vnd.spring-boot.actuator.v2+json || application/json]}",
							"details": {
								"handlerMethod": {
									"className": "org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping.OperationHandler",
									"name": "handle",
									"descriptor": "(Ljavax/servlet/http/HttpServletRequest;Ljava/util/Map;)Ljava/lang/Object;"
								},
								"requestMappingConditions": {
									"consumes": [],
									"headers": [],
									"methods": ["GET"],
									"params": [],
									"patterns": ["/actuator/beans"],
									"produces": [{
											"mediaType": "application/vnd.spring-boot.actuator.v2+json",
											"negated": false
										}, {
											"mediaType": "application/json",
											"negated": false
										}
									]
								}
							}
						}, {
							"handler": "public java.lang.String com.zhyyu.learn.learnspringboot.controller.RestControllerTest.hello()",
							"predicate": "{ /test/hello}",
							"details": {
								"handlerMethod": {
									"className": "com.zhyyu.learn.learnspringboot.controller.RestControllerTest",
									"name": "hello",
									"descriptor": "()Ljava/lang/String;"
								},
								"requestMappingConditions": {
									"consumes": [],
									"headers": [],
									"methods": [],
									"params": [],
									"patterns": ["/test/hello"],
									"produces": []
								}
							}
						}
					]
				},
				"servletFilters": [{
						"urlPatternMappings": ["/*"],
						"servletNameMappings": [],
						"name": "webMvcMetricsFilter",
						"className": "org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter"
					}, {
						"urlPatternMappings": ["/*"],
						"servletNameMappings": [],
						"name": "requestContextFilter",
						"className": "org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter"
					}, {
						"urlPatternMappings": ["/*"],
						"servletNameMappings": [],
						"name": "Tomcat WebSocket (JSR356) Filter",
						"className": "org.apache.tomcat.websocket.server.WsFilter"
					}, {
						"urlPatternMappings": ["/*"],
						"servletNameMappings": [],
						"name": "hiddenHttpMethodFilter",
						"className": "org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter"
					}, {
						"urlPatternMappings": ["/*"],
						"servletNameMappings": [],
						"name": "characterEncodingFilter",
						"className": "org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter"
					}, {
						"urlPatternMappings": ["/*"],
						"servletNameMappings": [],
						"name": "httpTraceFilter",
						"className": "org.springframework.boot.actuate.web.trace.servlet.HttpTraceFilter"
					}, {
						"urlPatternMappings": ["/*"],
						"servletNameMappings": [],
						"name": "formContentFilter",
						"className": "org.springframework.boot.web.servlet.filter.OrderedFormContentFilter"
					}
				],
				"servlets": [{
						"mappings": [],
						"name": "default",
						"className": "org.apache.catalina.servlets.DefaultServlet"
					}, {
						"mappings": ["/"],
						"name": "dispatcherServlet",
						"className": "org.springframework.web.servlet.DispatcherServlet"
					}
				]
			}
		}
	}
}
```

- http://localhost:8000/actuator/metrics
    - 程序运行时情况可查key
```json
{
	"names": ["jvm.memory.max", "jvm.threads.states", "http.server.requests", "jvm.gc.memory.promoted", "jvm.memory.used", "jvm.gc.max.data.size", "jdbc.connections.max", "jdbc.connections.min", "jvm.gc.pause", "jvm.memory.committed", "system.cpu.count", "logback.events", "tomcat.global.sent", "jvm.buffer.memory.used", "tomcat.sessions.created", "jvm.threads.daemon", "system.cpu.usage", "jvm.gc.memory.allocated", "tomcat.global.request.max", "hikaricp.connections.idle", "hikaricp.connections.pending", "tomcat.global.request", "tomcat.sessions.expired", "hikaricp.connections", "jvm.threads.live", "jvm.threads.peak", "tomcat.global.received", "hikaricp.connections.active", "hikaricp.connections.creation", "process.uptime", "tomcat.sessions.rejected", "process.cpu.usage", "tomcat.threads.config.max", "jvm.classes.loaded", "hikaricp.connections.max", "hikaricp.connections.min", "jvm.classes.unloaded", "tomcat.global.error", "tomcat.sessions.active.current", "tomcat.sessions.alive.max", "jvm.gc.live.data.size", "hikaricp.connections.usage", "tomcat.threads.current", "hikaricp.connections.timeout", "jvm.buffer.count", "jvm.buffer.total.capacity", "tomcat.sessions.active.max", "hikaricp.connections.acquire", "tomcat.threads.busy", "process.start.time"]
}

```

- http://localhost:8000/actuator/metrics/system.cpu.usage
    - 给定key 对应值
```json
{
	"name": "system.cpu.usage",
	"description": "The \"recent cpu usage\" for the whole system",
	"baseUnit": null,
	"measurements": [{
			"statistic": "VALUE",
			"value": 1.0
		}
	],
	"availableTags": []
}

```

- http://localhost:8000/actuator/httptrace
    - http 跟踪
 ```json
{
	"traces": [{
			"timestamp": "2019-06-28T01:57:56.981Z",
			"principal": null,
			"session": null,
			"request": {
				"method": "GET",
				"uri": "http://localhost:8000/test/hello",
				"headers": {
					"cookie": ["Idea-c343e724=3e5ef155-f065-4953-951c-ff94b86b9c66"],
					"accept-language": ["zh-CN,zh;q=0.9"],
					"upgrade-insecure-requests": ["1"],
					"host": ["localhost:8000"],
					"connection": ["keep-alive"],
					"accept-encoding": ["gzip, deflate, br"],
					"accept": ["text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"],
					"user-agent": ["Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36"]
				},
				"remoteAddress": null
			},
			"response": {
				"status": 200,
				"headers": {
					"Content-Length": ["6"],
					"Date": ["Fri, 28 Jun 2019 01:57:56 GMT"],
					"Content-Type": ["text/html;charset=UTF-8"]
				}
			},
			"timeTaken": 13
		}, {
			"timestamp": "2019-06-28T01:57:51.359Z",
			"principal": null,
			"session": null,
			"request": {
				"method": "GET",
				"uri": "http://localhost:8000/test",
				"headers": {
					"cookie": ["Idea-c343e724=3e5ef155-f065-4953-951c-ff94b86b9c66"],
					"accept-language": ["zh-CN,zh;q=0.9"],
					"upgrade-insecure-requests": ["1"],
					"host": ["localhost:8000"],
					"connection": ["keep-alive"],
					"accept-encoding": ["gzip, deflate, br"],
					"accept": ["text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"],
					"user-agent": ["Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36"]
				},
				"remoteAddress": null
			},
			"response": {
				"status": 404,
				"headers": {}
			},
			"timeTaken": 4
		}, {
			"timestamp": "2019-06-28T01:57:40.162Z",
			"principal": null,
			"session": null,
			"request": {
				"method": "GET",
				"uri": "http://localhost:8000/hello",
				"headers": {
					"cookie": ["Idea-c343e724=3e5ef155-f065-4953-951c-ff94b86b9c66"],
					"accept-language": ["zh-CN,zh;q=0.9"],
					"upgrade-insecure-requests": ["1"],
					"host": ["localhost:8000"],
					"connection": ["keep-alive"],
					"accept-encoding": ["gzip, deflate, br"],
					"accept": ["text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"],
					"user-agent": ["Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36"]
				},
				"remoteAddress": null
			},
			"response": {
				"status": 404,
				"headers": {}
			},
			"timeTaken": 16
		}
	]
}
```

- http://localhost:8000/actuator/health
    - 程序是否运行
```json
{"status":"UP"}
```

- http://localhost:8000/actuator/threaddump
    - 查看线程堆栈
```json
 {
			"threadName": "http-nio-8000-Acceptor",
			"threadId": 44,
			"blockedTime": -1,
			"blockedCount": 0,
			"waitedTime": -1,
			"waitedCount": 0,
			"lockName": null,
			"lockOwnerId": -1,
			"lockOwnerName": null,
			"inNative": true,
			"suspended": false,
			"threadState": "RUNNABLE",
			"stackTrace": [{
					"methodName": "accept0",
					"fileName": "ServerSocketChannelImpl.java",
					"lineNumber": -2,
					"className": "sun.nio.ch.ServerSocketChannelImpl",
					"nativeMethod": true
				}, {
					"methodName": "accept",
					"fileName": "ServerSocketChannelImpl.java",
					"lineNumber": 422,
					"className": "sun.nio.ch.ServerSocketChannelImpl",
					"nativeMethod": false
				}, {
					"methodName": "accept",
					"fileName": "ServerSocketChannelImpl.java",
					"lineNumber": 250,
					"className": "sun.nio.ch.ServerSocketChannelImpl",
					"nativeMethod": false
				}, {
					"methodName": "serverSocketAccept",
					"fileName": "NioEndpoint.java",
					"lineNumber": 463,
					"className": "org.apache.tomcat.util.net.NioEndpoint",
					"nativeMethod": false
				}, {
					"methodName": "serverSocketAccept",
					"fileName": "NioEndpoint.java",
					"lineNumber": 73,
					"className": "org.apache.tomcat.util.net.NioEndpoint",
					"nativeMethod": false
				}, {
					"methodName": "run",
					"fileName": "Acceptor.java",
					"lineNumber": 95,
					"className": "org.apache.tomcat.util.net.Acceptor",
					"nativeMethod": false
				}, {
					"methodName": "run",
					"fileName": "Thread.java",
					"lineNumber": 748,
					"className": "java.lang.Thread",
					"nativeMethod": false
				}
			],
			"lockedMonitors": [{
					"className": "java.lang.Object",
					"identityHashCode": 1225015795,
					"lockedStackDepth": 2,
					"lockedStackFrame": {
						"methodName": "accept",
						"fileName": "ServerSocketChannelImpl.java",
						"lineNumber": 250,
						"className": "sun.nio.ch.ServerSocketChannelImpl",
						"nativeMethod": false
					}
				}
			],
			"lockedSynchronizers": [],
			"lockInfo": null
		}
```