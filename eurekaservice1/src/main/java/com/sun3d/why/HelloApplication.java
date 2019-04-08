package com.sun3d.why;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Created by xiech on 2019/3/27 0027.
 *@EnableDiscoveryClient 激活Eureka中的DiscoveryClient实现
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class,args);
    }
}
