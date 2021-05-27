package com.zhyyu.learn.learnspringboot.cors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试跨域拦截器
 * <pre>
 *     templates/index.html
 *     http://localhost:8000 -->> http://localhost:8050
 *
 *     配置 Access-Control-Allow-Origin: http://localhost:8000  or Access-Control-Allow-Origin: *
 *     则浏览器无跨域异常
 *
 *GET /test/hello HTTP/1.1
 * Host: localhost:8050
 * Connection: keep-alive
 * Pragma: no-cache
 * Cache-Control: no-cache
 * Sec-Fetch-Mode: cors
 * Origin: http://localhost:8000
 * User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36
 * Accept: ______ (注释问题
        *Sec-Fetch-Site:same-site
        *Referer:http://localhost:8000/view-test/index
        *Accept-Encoding:gzip,deflate,br
        *Accept-Language:zh-CN,zh;q=0.9
        *
        *
 *HTTP/1.1 200
 * Access-Control-Allow-Origin: *
 * Content-Type: text/plain;charset=UTF-8
 * Content-Length: 6
 * Date: Tue, 03 Sep 2019 12:57:22 GMT
 *
 * hello
 *
 * </pre>
 * @author juror
 * @datatime 2019/9/3 20:42
 */
@Component
public class CORSHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String origin = request.getHeader("Origin");
        if ("http://localhost:8000".equals(origin)) {
            // 配置跨域成功
            // 注意 options 方法可能需要添加 Access-Control-Allow-Headers:*
//            response.setHeader("Access-Control-Allow-Origin", "*");

            // 配置跨域成功
//            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8000");

            /**
             * Access to XMLHttpRequest at 'http://localhost:8050/test/hello' from origin 'http://localhost:8000' has been blocked by CORS policy: The 'Access-Control-Allow-Origin' header has a value 'http://localhost:8001' that is not equal to the supplied origin.\
             * 配置跨域失败
             */
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8001");
            return true;
        }

        return false;
    }
}
