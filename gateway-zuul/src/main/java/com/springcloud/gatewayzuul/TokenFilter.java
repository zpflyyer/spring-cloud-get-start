package com.springcloud.gatewayzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zpf
 * @date 2019/8/12 11:41
 */
@Component
@RefreshScope
@Slf4j
public class TokenFilter extends ZuulFilter {

    @Value("${access-token}")
    private String accessToken;

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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();

        log.info("send msg{} to {}", req.getMethod(), req.getRequestURL().toString());

        String token = req.getParameter("token");
        if (!accessToken.equals(token)) {
            log.warn("access token check failed");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token check failed");
        }

        return null;
    }
}
