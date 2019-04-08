package com.sun3d.why.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiech on 2019/4/4 0004.
 */
@RefreshScope
@RestController
public class TestController {
    @Value("${from}")
    private String from;
    @RequestMapping("from")
    public String from(){
        return this.from;
    }
}

