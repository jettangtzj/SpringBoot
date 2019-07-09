package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.FeignConsumerService;
import com.service.FeignProviderService;

@RestController
public class FeignController {

	@Autowired
	private FeignConsumerService feignConsumerService;
	
	@Autowired
	private FeignProviderService feignProviderService;
	
	/**
	 * @GetMapping value 本应用的请求路径
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/feigntest")
	public String feignTest(@RequestParam String name) {
		return feignConsumerService.consumerTest(name);
	}
	
	/**
	 * @GetMapping value 本应用的请求路径
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/feignribbontest")
	public String feignRibbonTest(@RequestParam String name) {
		return feignConsumerService.ribbonTest(name);
	}
	
	
	
	/**
	 * @GetMapping value 本应用的请求路径
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/producttest")
	public String productTest(@RequestParam String name) {
		return feignProviderService.productTest(name);
	}
	
	
	
}
