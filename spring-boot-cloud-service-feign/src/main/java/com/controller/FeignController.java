package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.FeignService;

@RestController
public class FeignController {

	@Autowired
	private FeignService feignService;
	
	@GetMapping(value = "/feigntest")
	public String call(@RequestParam String name) {
		return feignService.callName(name);
	}
}
