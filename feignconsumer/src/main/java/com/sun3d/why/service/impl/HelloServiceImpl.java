package com.sun3d.why.service.impl;

import com.sun3d.why.model.User;
import com.sun3d.why.service.HelleService;
import org.springframework.stereotype.Component;

/**
 * Created by xiech on 2019/4/1 0001.
 */
@Component
public class HelloServiceImpl implements HelleService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error1";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知",0);
    }

    @Override
    public User hello(User user) {
        return new User("未知1",0);
    }
}
