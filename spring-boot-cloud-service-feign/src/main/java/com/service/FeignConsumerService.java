package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient 请求的目标服务名或应用名
 * 
 * @author jettang
 *
 */
@FeignClient(value = "service-ribbon-simple-consumer")
@Service
public interface FeignConsumerService {
		
	/**
	 * @RequestMapping value 目标的请求路径
	 * @param name 传递的参数
	 * @return
	 */
	@RequestMapping(value = "/consumer",method = RequestMethod.GET)
	public String consumerTest(@RequestParam(value = "name") String name);
	
	
	/**
	 * @RequestMapping value 目标的请求路径
	 * @param name 传递的参数
	 * @return
	 */
	@RequestMapping(value = "/ribbon",method = RequestMethod.GET)
	public String ribbonTest(@RequestParam(value = "name") String name);
	
}
