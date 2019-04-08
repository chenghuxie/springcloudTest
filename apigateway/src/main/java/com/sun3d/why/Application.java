package com.sun3d.why;

import com.sun3d.why.filter.AccessFilter;
import com.sun3d.why.filter.ErrorFilter;
import com.sun3d.why.filter.ExceptionFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by xiech on 2019/4/1 0001.
 *
 * • 它作为系统的统一入口， 屏蔽了系统内部各个微服务的细节。
 * • 它可以与服务治理框架结合，实现自动化的服务实例维护以及负载均衡的路由转发。
 * • 它可以实现接口权限校验与微服务业务逻辑的解耦。
 * • 通过服务网关中的过炖器， 在各生命周期中去校验请求的内容， 将原本在对外服务层做的校验前移， 保证了微服务的无状态性， 同时降低了微服务的测试难度， 让服务本身更集中关注业务逻辑的处理
 */
@EnableZuulProxy
@SpringCloudApplication
public class Application {
    @Bean
    public ExceptionFilter exceptionFilter(){
        return new ExceptionFilter();
    }
    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
