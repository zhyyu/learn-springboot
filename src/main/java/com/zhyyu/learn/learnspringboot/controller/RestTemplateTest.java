package com.zhyyu.learn.learnspringboot.controller;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLException;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author juror
 * @datatime 2019/8/10 14:21
 */
@RestController
@RequestMapping("/test-rest-template")
public class RestTemplateTest {

    @RequestMapping("getWithoutUriVariables")
    public String getWithoutUriVariables() {
        Integer HTTP_TIME_OUT_MILLISECONDS = 1_000;

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(HTTP_TIME_OUT_MILLISECONDS)
                .setConnectionRequestTimeout(HTTP_TIME_OUT_MILLISECONDS)
                .setSocketTimeout(HTTP_TIME_OUT_MILLISECONDS)
                .build();
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .setRetryHandler(new MyDefaultHttpRequestRetryHandler(3))
//                .disableAutomaticRetries()
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(client);

        RestTemplate restTemplate = new RestTemplate(requestFactory);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8000/test/hello", String.class);
        System.out.println(responseEntity);

        return responseEntity.toString();
    }

    static class MyDefaultHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {
        public MyDefaultHttpRequestRetryHandler(int retryCount) {
            super(retryCount, false, Arrays.asList(
//                    InterruptedIOException.class,
                    UnknownHostException.class,
//                    ConnectException.class,
                    SSLException.class));
        }
    }

    @RequestMapping("getWithUriVariables")
    public String getWithUriVariables() {
        RestTemplate restTemplate = new RestTemplate();

        RestControllerTest.MyObj myObj = RestControllerTest.MyObj.builder().key1("value1").key2("value2").build();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8000/test/formOrJson?key1={key1}&key2={key2}", String.class, "value1", "value2");
        System.out.println(responseEntity);

        return responseEntity.toString();
    }

    @RequestMapping("postNullWithoutUriVariables")
    public String postNullWithoutUriVariables() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8000/test/hello", null, String.class);

        return responseEntity.toString();
    }

    @RequestMapping("postNullWithUriVariables")
    public String postNullWithUriVariables() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8000/test/formOrJson?key1={key1}&key2={key2}", null, String.class, "value1", "value2");
        return responseEntity.toString();
    }

    /**
     * 测试restTemplate post content-type
     * <pre>
     *     1. 若直接post 数据对象, 则content-type 为 application/json;charset=UTF-8
     *     2. 包装 HttpEntity, 若包装数据对象(pojo), 异常: org.springframework.web.client.RestClientException: No HttpMessageConverter for com.zhyyu.learn.learnspringboot.controller.RestControllerTest$MyObj and content type "application/x-www-form-urlencoded"
     *     3. 包装 HttpEntity, 数据对象转换为 MultiValueMap<String, String>(注意不能为Map!!! 否则报错), 则content-type 为 application/x-www-form-urlencoded;charset=UTF-8
     * </pre>
     */
    @RequestMapping("postNotNullWithoutUriVariables")
    public String postNotNullWithoutUriVariables() {
        RestTemplate restTemplate = new RestTemplate();

        RestControllerTest.MyObj myObj = RestControllerTest.MyObj.builder().key1("value1").key2("value2").build();

        // Content-Type: application/json;charset=UTF-8
        // ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8000/test/formOrJson", myObj, String.class);
        // ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8000/test/formOrJson", myObj, String.class);

        // Content-Type: application/x-www-form-urlencoded;charset=UTF-8
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("key1", "value1");
        map.add("key2", "value2");

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);

        // org.springframework.web.client.RestClientException: No HttpMessageConverter for com.zhyyu.learn.learnspringboot.controller.RestControllerTest$MyObj and content type "application/x-www-form-urlencoded"
        // HttpEntity<RestControllerTest.MyObj> httpEntity = new HttpEntity<>(myObj, headers);
        // ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8000/test/formOrJson", httpEntity, String.class);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8000/test/formOrJson", httpEntity, String.class);

        return responseEntity.toString();
    }

}
