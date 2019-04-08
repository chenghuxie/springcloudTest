package com.sun3d.why;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Created by xiech on 2019/4/1 0001.
 */
@EnableFeignClients //指定服务名来绑定服务
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class,args);
    }
}
