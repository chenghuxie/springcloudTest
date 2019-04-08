package com.sun3d.why.controller;

import com.sun3d.why.service.FeignApiHelloService;
import com.sun3d.why.service.HelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiech on 2019/4/1 0001.
 */
@RestController
public class HelloController {
    @Autowired
    HelleService helleService;
    @Autowired
    FeignApiHelloService feignApiHelloService;

    /**
     * 声明式服务调用
     * @return
     */
    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String  hello(){
        return helleService.hello();
    }

    /**
     * 声明式服务调用 携带参数
     * @return
     */
    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String  hello2(){
        StringBuffer sb =new StringBuffer();
        sb.append(helleService.hello()).append("\n");
        sb.append(helleService.hello("xiexie1")).append("\n");
        sb.append(helleService.hello("xiexie2",30)).append("\n");
        //sb.append(helleService.hello(new User("xiexie3",50))).append("\n");
        return sb.toString();
    }

    /**
     * 声明式服务调用 继承特性
     * @return
     */
    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String  hello3(){
        StringBuffer sb =new StringBuffer();
        sb.append(feignApiHelloService.hello("xiexie1")).append("\n");
        sb.append(feignApiHelloService.hello("xiexie2",30)).append("\n");
        return sb.toString();
    }

    /**
     * 声明是服务调用 重试机制 ribbon
     * @return
     */
    @RequestMapping(value = "/feign-consumer4",method = RequestMethod.GET)
    public String  hello4(){
        StringBuffer sb =new StringBuffer();
        sb.append(feignApiHelloService.hello("xiexie1")).append("\n");
        return sb.toString();
    }

    /**
     * 声明式服务调用 服务降级  重写实现类 @FeignClient指定实现类
     * @return
     */
    @RequestMapping(value = "/feign-consumer5",method = RequestMethod.GET)
    public String  hello5(){
        StringBuffer sb =new StringBuffer();
        sb.append(helleService.hello("hehe")).append("\n");
        return sb.toString();
    }
}
