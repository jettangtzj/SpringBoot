package com.jaycekon.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * Ribbon is a client side load balancer which gives you a lot of control over the behaviour of HTTP and TCP clients
 * ribbon+restTemplate
 * @author jettang
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
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
	}
}
