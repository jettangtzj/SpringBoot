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
	 * 定义一个本服务端口号的常量
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
        return "hi "+name+",i am from port:" +port + " " + new Date();
    }

}
