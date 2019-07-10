# Spring Cloud Consumer

## 服务消费者

*   Provider或Consumer没有明确的区分，根据具体的业务而来
*   测试地址：
http://localhost:2019/feigntest?name=jettang
http://localhost:2019/feignribbontest?name=jettang
http://localhost:2019/feignhystrixtest?name=jettang
http://localhost:2019/producttest?name=jettang

### feign
####    通过@EnableFeignClients、@FeignClient(value）方式实现feign的客户端功能，@RequestMapping实现目标服务的请求地址
*   使用http://localhost:2019/feigntest?name=jettang
*   feign同时支持Hystrix，处理fallback
*   支持ribbon
*   可根据情况实现多个FeignClient





## zipkin
*   进行链路的跟踪
*   启动java -jar zipkin-server-2.9.4-exec.jar


