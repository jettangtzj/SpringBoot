/**
 * 
 */
package com.example.demo.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 自定义过滤器
 * @author jettang
 *
 */
public class RequestTimeFilter implements GatewayFilter, Ordered {
	
	/**
	 * 当前过滤器优先级 值越低，越优先
	 */
	@Override
	public int getOrder() {
		return 0;
	}

	/**
	 * 过滤实现方法
	 * 记录请求的处理时间
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		//pre处理
		exchange.getAttributes().put("requestTimeBegin", System.currentTimeMillis());
		return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                	//post处理
                    Long startTime = exchange.getAttribute("requestTimeBegin");
                    if (startTime != null) {
                    	System.out.println("====exchange.getRequest().getURI().getRawPath() : "  + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
	}

}
