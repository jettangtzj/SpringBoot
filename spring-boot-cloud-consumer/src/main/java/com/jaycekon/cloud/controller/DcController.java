package com.jaycekon.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jaycekon on 2017/9/20.
 */
@RestController
public class DcController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer(@RequestParam String name) {
        String url = "http://eureka-client/product?name="+name;
//        return new RestTemplate().getForObject(url, String.class);
        return restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/ribbon")
    public String ribbon(@RequestParam String name) {
        return restTemplate.getForObject("http://eureka-client/product?name="+name, String.class);
    }


}
