package com.jaycekon.cloud.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jaycekon on 2017/9/20.
 */

@RestController
public class DcController {

	/**
	 * 配置文件中的spring应用/服务名
	 */
	@Value("${spring.application.name}")
	String springApplicationName;

	/**
	 * 配置文件中设置的端口号
	 */
    @Value("${server.port}")
    String port;

    /**
     * @RequestMapping value 请求路径
     * @param name
     * @return
     */
    @RequestMapping("/product")
    public String product(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port 
        		+ "<br/>message transmit by " + springApplicationName 
        		+ "<br/>time:" + new Date();
    }

}
