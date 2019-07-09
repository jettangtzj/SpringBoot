package com.service;

import org.springframework.beans.factory.annotation.Autowired;
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
     * @HystrixCommand 申请断路并提供处理方法名
     * @param name
     * @return
     */
	@HystrixCommand(fallbackMethod = "errorHandle")
	public String hystrixTest(String name) {
		return restTemplate.getForObject("http://"+targetName+"/product?name="+name, String.class);
    }
	
	/**
	 * 错误处理方法
	 * @param name
	 * @return
	 */
	public String errorHandle(String name) {
		return "Sorry, it has an error";
	}
		
}
