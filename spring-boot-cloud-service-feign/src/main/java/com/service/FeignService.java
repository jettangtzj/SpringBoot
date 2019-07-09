package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
@Service
public interface FeignService {
		
	
	@RequestMapping(value = "/product",method = RequestMethod.GET)
	public String callName(@RequestParam(value = "name") String name);
	
}
