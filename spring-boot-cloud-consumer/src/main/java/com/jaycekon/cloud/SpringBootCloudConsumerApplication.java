package com.jaycekon.cloud;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * Ribbon is a client side load balancer which gives you a lot of control over the behaviour of HTTP and TCP clients
 * ribbon+restTemplate
 * @author jettang
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableHystrix
public class SpringBootCloudConsumerApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


	public static void main(String[] args) {
		new SpringApplicationBuilder(
				SpringBootCloudConsumerApplication.class)
				.web(true).run(args);
		
		System.out.println("=======consumer========");
	}
}
