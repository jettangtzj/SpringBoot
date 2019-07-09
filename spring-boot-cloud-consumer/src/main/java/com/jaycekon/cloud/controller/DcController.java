package com.jaycekon.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jaycekon.cloud.service.HystrixTestService;


/**
 * Created by Jaycekon on 2017/9/20.
 */
@RestController
public class DcController {


    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private HystrixTestService hystrixTestService;
    
    //目标服务名或应用名
    public final String targetName = "eureka-client-simple-provider";

    /**
     * 一般形式
     * @param name
     * @return
     */
    @GetMapping("/consumer")
    public String consumer(@RequestParam String name) {
        String url = "http://"+targetName+"/product?name="+name;
//        return new RestTemplate().getForObject(url, String.class);
        return restTemplate.getForObject(url, String.class);
    }
    
    /**
     * ribbon使用
     * @param name
     * @return
     */
    @GetMapping("/ribbon")
    public String ribbon(@RequestParam String name) {
        return restTemplate.getForObject("http://"+targetName+"/product?name="+name, String.class);
    }
    
    /**
     * hystrix使用
     * @param name
     * @return
     */
    @GetMapping("/hystrixTest")
    public String hystrixTest(@RequestParam String name) {
        return hystrixTestService.hystrixTest(name);
    }


}
