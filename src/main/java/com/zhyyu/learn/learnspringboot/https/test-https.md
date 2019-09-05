# 测试https

- 如下配置
 ```
    server.port=443
    server.ssl.key-store-type=PKCS12
    server.ssl.key-store=classpath:keystore/zhyyu.p12
    server.ssl.key-store-password=123456   
  ```
- chrome
    - https://localhost/test/hello 可直接访问, 无需填写端口号 (chrome 会有安全提示, 因为该证书无CA 认证)
    - 修改server.port=8000
        - https://localhost/test/hello 不能访问
        - https://localhost:8000/test/hello 若配置server.port 非443, 则需要填写端口号, 可以访问
    - http://localhost:8000/test/hello 访问http 协议
        ```text
        Bad Request
        This combination of host and port requires TLS.
        ```
      
- wireshark 抓包分析
    - tcp.port == 443 && tls (tlsv1.2)
    - "图解http" p154 (有出入)
    - tcp 三次握手, keep-Alive, fin 之后分析