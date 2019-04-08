package com.sun3d.why;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiech on 2019/3/28 0028.
 *
 * @SpringCloudApplication等价于@EnableCircuitBreaker ，@EnableDiscoveryClient，@SpringBootApplication
 */
/*@EnableCircuitBreaker //开启断路器功能
@EnableDiscoveryClient
@SpringBootApplication*/
@SpringCloudApplication
public class ConsumerApplication {

    @Bean
    @LoadBalanced //开启客服端负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
