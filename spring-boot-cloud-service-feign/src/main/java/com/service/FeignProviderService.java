package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient value请求的目标服务名或应用名 fallback错误处理的类
 * 
 * @author jettang
 *
 */
@FeignClient(value = "eureka-client-simple-provider" , fallback= HystrixTestService.class)
@Service
public interface FeignProviderService {
		
	/**
	 * @RequestMapping value 目标的请求路径
	 * @param name 传递的参数
	 * @return
	 */
	@RequestMapping(value = "/product",method = RequestMethod.GET)
	public String productTest(@RequestParam(value = "name") String name);
	
	
}
