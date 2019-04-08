package com.sun3d.why.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * Created by xiech on 2019/4/2 0002.
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {
    @Override
    public String filterType(){
        return "error";
    }
    @Override
    public int filterOrder(){
        return 30;
    }
    @Override
    public boolean shouldFilter(){
        //TODO 判断：仅处理来自post过滤器引发的异常
        RequestContext context=RequestContext.getCurrentContext();
        ZuulFilter failedFilter= (ZuulFilter) context.get("failed.filter");
        if(failedFilter!=null&&failedFilter.filterType().equals("post")){
            return true;
        }
        return false;
    }
}
