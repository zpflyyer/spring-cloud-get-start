package com.springcloud.gatewayzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zpf
 * @date 2019/8/12 11:41
 */
@Component
@Slf4j
public class TokenFilter extends ZuulFilter {
    private static final String ACCESS_TOKEN = "fsd87fsdfs9fd7sfdf7990f";

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
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();

        log.info("send msg{} to {}", req.getMethod(), req.getRequestURL().toString());

        String accessToken = req.getParameter("token");
        if (!ACCESS_TOKEN.equals(accessToken)) {
            log.warn("access token check failed");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token check failed");
        }

        return null;
    }
}
