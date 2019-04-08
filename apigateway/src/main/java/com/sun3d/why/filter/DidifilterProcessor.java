package com.sun3d.why.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Created by xiech on 2019/4/2 0002.
 */
public class DidifilterProcessor extends FilterProcessor {
    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        }catch (ZuulException e){
            RequestContext context=RequestContext.getCurrentContext();
            context.set("failed.filter",filter);
            throw  e;
        }
    }
}
