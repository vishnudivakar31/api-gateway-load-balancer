package io.vdev.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/client")
public class ZuulLoginFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(ZuulLoginFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("Request is filtered");
        HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {} ",
                httpServletRequest, httpServletRequest.getRequestURI());
        return null;
    }
}
