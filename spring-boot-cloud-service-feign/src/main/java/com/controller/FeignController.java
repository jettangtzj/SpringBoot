package com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.FeignConsumerService;
import com.service.FeignProviderService;

@RestController
public class FeignController {
	
	/**
	 * 配置文件中的spring应用/服务名
	 */
	@Value("${spring.application.name}")
	String springApplicationName;

	@Autowired
	private FeignConsumerService feignConsumerService;
	
	@Autowired
	private FeignProviderService feignProviderService;
	
	/**
	 * simple test
	 * @GetMapping value 本应用的请求路径
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/feigntest")
	public String feignTest(@RequestParam String name) {
		return feignConsumerService.consumerTest(name) 
				+ "<br/>message transmit by " + springApplicationName
				+ "<br/>time:" + new Date();
	}
	
	/**
	 * ribbon test
	 * @GetMapping value 本应用的请求路径
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/feignribbontest")
	public String feignRibbonTest(@RequestParam String name) {
		return feignConsumerService.ribbonTest(name)
				+ "<br/>message transmit by " + springApplicationName
				+ "<br/>time:" + new Date();
	}
	
	/**
	 * hystrix test
	 * @GetMapping value 本应用的请求路径
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/feignhystrixtest")
	public String feignHystrixTest(@RequestParam String name) {
		return feignConsumerService.hystrixTest(name)
				+ "<br/>message transmit by " + springApplicationName
				+ "<br/>time:" + new Date();
	}
	
	
	
	/**
	 * provider test
	 * @GetMapping value 本应用的请求路径
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/producttest")
	public String productTest(@RequestParam String name) {
		return feignProviderService.productTest(name)
				+ "<br/>message transmit by " + springApplicationName
				+ "<br/>time:" + new Date();
	}
	
	
	
}
