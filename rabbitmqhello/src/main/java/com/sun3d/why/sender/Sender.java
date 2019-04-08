package com.sun3d.why.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by xiech on 2019/4/2 0002.
 */

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context="hello"+new Date();
        System.out.println("Sender :"+context);
        this.amqpTemplate.convertAndSend("hello",context);
    }
}
