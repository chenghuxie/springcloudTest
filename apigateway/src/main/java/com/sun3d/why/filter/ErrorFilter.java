package com.sun3d.why.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiech on 2019/4/2 0002.
 */
public class ErrorFilter extends ZuulFilter {

    private Logger logger= LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context=RequestContext.getCurrentContext();
        Throwable throwable=context.getThrowable();
        logger.error("this is a ErrorFilter:{}",throwable.getCause().getMessage());
        context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        context.set("error.exception",throwable.getCause());
        return null;
    }
}
