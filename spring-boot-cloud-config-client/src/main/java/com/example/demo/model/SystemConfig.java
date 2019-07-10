package com.example.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 本地配置文件类 systemconfig的配置前缀
 * @author jettang
 *
 */
@Component
@ConfigurationProperties(prefix = "sc")
@PropertySource("classpath:systemconfig.properties")
public class SystemConfig {
	
	private String testcontent;

	public String getTestcontent() {
		return testcontent;
	}

	public void setTestcontent(String testcontent) {
		this.testcontent = testcontent;
	}
	
	

}
