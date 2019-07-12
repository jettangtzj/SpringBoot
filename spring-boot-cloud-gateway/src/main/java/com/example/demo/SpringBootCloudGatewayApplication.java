package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.filter.HostAddrKeyResolver;
import com.example.demo.filter.RequestTimeFilter;
import com.example.demo.filter.TokenFilter;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringBootCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudGatewayApplication.class, args);
		System.out.println("=======service-gateway==============");
	}
	
	/**
	 * 定义路由/get 或 /testHystrix 的请求路径会被进行路由处理
	 * @param builder
	 * @return
	 */
	@Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		String httpUri = "http://www.google.com:80";
        return builder.routes()
            .route(p -> p
                .path("/get")
                .filters(f -> f.filter(new RequestTimeFilter()).addRequestHeader("Hello", "World"))
                .uri(httpUri))
            .route(p -> p
            		.path("/testHystrix")
                .filters(f -> f
                    .hystrix(config -> config
                        .setName("mycmd")
                        .setFallbackUri("forward:/fallback")))
                .uri(httpUri))
            .build();
	}
	
	@RequestMapping(value="/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}
	
	/**
	 * 全局filter
	 * @return
	 */
	@Bean
	public TokenFilter tokenFilter(){
	        return new TokenFilter();
	}
	
	/**
	 * 限流filter
	 * @return
	 */
	@Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

	
}
