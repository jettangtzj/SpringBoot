package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SystemConfig;

@RestController
@RefreshScope
public class ConfigClientController {
	
	@Value("${username}")
	String username;
	
	@Value("${password}")
	String password;
	
	@Value("${ip}")
	String ip;
	
	@Autowired
	SystemConfig systemConfig;
	
	@RequestMapping(value = "/loadConfig")
	public String loadConfig() {
		return "username=" + username + 
				"<br/>"  + "password="+password + 
				"<br/>" + "ip=" + ip
				+ "<br/> local config file record:" + systemConfig.getTestcontent();
	}
	
	@RequestMapping(value = "/loadServerConfig")
	public String loadServerConfig() {
		return "ServerConfig:username=" + username + 
				"<br/>"  + "password="+password + 
				"<br/>" + "ip=" + ip;
	}
	
	@RequestMapping(value = "/loadLocalConfig")
	public String loadLocalConfig() {
		return "<br/> local config file record:" + systemConfig.getTestcontent();
	}
	
}
