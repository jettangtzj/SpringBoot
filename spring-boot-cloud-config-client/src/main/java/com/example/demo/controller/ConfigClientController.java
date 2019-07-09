package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
	
	@Value("${username}")
	String username;
	
	@Value("${password}")
	String password;
	
	@Value("${ip}")
	String ip;
	
	@RequestMapping(value = "/loadConfig")
	public String loadConfig() {
		return "username=" + username + 
				"<br/>"  + "password="+password + 
				"<br/>" + "ip=" + ip;
	}
	
}
