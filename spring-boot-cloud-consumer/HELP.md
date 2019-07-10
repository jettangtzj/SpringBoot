# Spring Cloud Consumer

## 消费者

*   一般的消费者使用http://localhost:2018/consumer?name=jettang调用
*   支持ribbon的使用http://localhost:2018/ribbon?name=jettang调用
*   支持Hystrix的使用http://localhost:2018/hystrixTest?name=jettang调用



## ribbon
* 是一种LoadBalanced的解决方案


## Hystrix
*  是一种断路器，当微服务中目标的服务不可用时，提供@HystrixCommand的fallbackMethod和@Hystrix的fallback提供错误处理的解决方案

