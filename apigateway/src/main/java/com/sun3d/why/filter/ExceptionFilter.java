package com.sun3d.why.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiech on 2019/4/2 0002.
 */

public class ExceptionFilter extends ZuulFilter {
    private Logger logger= LoggerFactory.getLogger(ExceptionFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("this is a pre filter ,it will throw RuntimeException ");
        //doSomething();
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("exist some errors...");
    }
}
