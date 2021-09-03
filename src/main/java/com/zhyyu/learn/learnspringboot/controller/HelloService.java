package com.zhyyu.learn.learnspringboot.controller;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Service
public class HelloService {

    public String hello() {
        return "helloService ret";
    }

    public String hello2(){
        String rpcRet = "";
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://localhost:8001/hello/hello4");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();

            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());
            String rsp = writer.toString();
            rpcRet = rsp;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "helloService ret2" + " _ " + rpcRet;
    }

}
