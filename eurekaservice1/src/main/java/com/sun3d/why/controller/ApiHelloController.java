package com.sun3d.why.controller;

import com.sun3d.why.service.ApiHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by xiech on 2019/4/1 0001.
 */
@RestController
public class ApiHelloController implements ApiHelloService {

    private Logger logger= LoggerFactory.getLogger(ApiHelloController.class);

    @Autowired
    private DiscoveryClient client;

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        ServiceInstance instance=client.getLocalServiceInstance();
        //让处理线程等待几秒钟
        int sleepTime=new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("hello,host:"+instance.getHost()+",service.id:"+instance.getServiceId());
        return "apihello"+name;
    }

    @Override
    public String hello(@RequestHeader(value = "name") String name, @RequestHeader(value = "age") Integer age) {
        return "apihello"+name+","+age;
    }
}
