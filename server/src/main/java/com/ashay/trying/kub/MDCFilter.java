package com.ashay.trying.kub;

import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MDCFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Optional<String> mayBeReqId = Optional.ofNullable(((HttpServletRequest) request).getHeader("X-ReqId"));
        MDC.put("ReqId", mayBeReqId.orElse(UUID.randomUUID().toString()));

        chain.doFilter(request, response);
    }
}
