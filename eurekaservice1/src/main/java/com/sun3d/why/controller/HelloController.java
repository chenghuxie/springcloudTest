package com.sun3d.why.controller;



import com.sun3d.why.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by xiech on 2019/3/28 0028.
 */
@RestController
public class HelloController {

    private final Logger logger= LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET )
    public String index() throws InterruptedException {
        ServiceInstance instance=client.getLocalServiceInstance();
        //让处理线程等待几秒钟
    /*   int sleepTime=new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);*/
        logger.info("hello,host:"+instance.getHost()+",service.id:"+instance.getServiceId());
        return "Hello world";
    }

    @RequestMapping(value = "hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        ServiceInstance instance=client.getLocalServiceInstance();
        //让处理线程等待几秒钟
       /* int sleepTime=new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        logger.info("hello,host:"+instance.getHost()+",service.id:"+instance.getServiceId());
        return "hello"+name;
    }

    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    public User hello2(@RequestHeader String name,@RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return "hello"+user.getName()+","+ user.getAge();
    }
}
