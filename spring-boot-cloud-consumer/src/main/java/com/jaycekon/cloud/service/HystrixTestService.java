package com.jaycekon.cloud.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixTestService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//目标服务名或应用名
    public final String targetName = "eureka-client-simple-provider";
    
    /**
	 * 配置文件中的spring应用/服务名
	 */
	@Value("${spring.application.name}")
	String springApplicationName;
	
    /**
     * @HystrixCommand 申请断路并提供处理方法名
     * @param name
     * @return
     */
	@HystrixCommand(fallbackMethod = "errorHandle")
	public String hystrixTest(String name) {
		return restTemplate.getForObject("http://"+targetName+"/product?name="+name, String.class) 
				+ "<br/>message transmit by " + springApplicationName
				+ "<br/>time:" + new Date();
    }
	
	/**
	 * 错误处理方法
	 * @param name
	 * @return
	 */
	public String errorHandle(String name) {
		return "Hystrix: Sorry, it has an error" 
	+ "<br/>message transmit by " + springApplicationName
	+ "<br/>time:" + new Date();
	}
		
}
