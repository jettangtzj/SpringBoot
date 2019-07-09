package com;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.*")
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class SpringBootCloudServiceFeignApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(
				SpringBootCloudServiceFeignApplication.class)
				.web(true).run(args);
		
		System.out.println("=======service feign========");
	}
}
