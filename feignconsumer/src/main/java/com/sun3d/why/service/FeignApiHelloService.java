package com.sun3d.why.service;


import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by xiech on 2019/4/1 0001.
 */
@FeignClient(name = "hello-service" )
public interface FeignApiHelloService extends  ApiHelloService{
}
