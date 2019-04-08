package com.sun3d.why;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by xiech on 2019/3/28 0028.
 */
@EnableEurekaServer
@SpringBootApplication
public class Application2 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application2.class).web(true).run(args);
    }
}
