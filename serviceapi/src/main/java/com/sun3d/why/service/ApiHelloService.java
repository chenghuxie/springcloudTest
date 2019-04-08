package com.sun3d.why.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiech on 2019/4/1 0001.
 */
@RequestMapping("/api")
public interface ApiHelloService {

    @RequestMapping(value = "hello4",method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "hello5",method = RequestMethod.GET)
    String hello(@RequestHeader(value = "name") String name,@RequestHeader(value = "age") Integer age);


}

