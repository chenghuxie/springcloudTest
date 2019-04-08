package com.sun3d.why.service;

import com.sun3d.why.model.User;
import com.sun3d.why.service.impl.HelloServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiech on 2019/4/1 0001.
 */
@FeignClient(name = "hello-service",fallback = HelloServiceImpl.class)
public interface HelleService {
    @RequestMapping("hello")
    String hello();

    @RequestMapping(value = "hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name")String name);

    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name")String name,@RequestHeader("age") Integer age);


    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    User hello(@RequestBody User user);


}
