package com.mesut.filter;



import org.slf4j.MDC;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
public class MdcLogEnhancerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MdcLogEnhancerFilter doFilter.");
        try {
            String mdcData = String.format("[userId:%s | requestId:%s] ", user(), requestId());
            MDC.put("mdcData", mdcData); //Referenced from logging configuration.
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    private String requestId() {
        return UUID.randomUUID().toString();
    }

    private String user() {
        //Authentication authentication = SecurityContext.getContext().getAuthentication();
        //return authentication == null ? null : authentication.getName();
        return "tux";
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MdcLogEnhancerFilter init.");
    }

    @Override
    public void destroy() {
        System.out.println("MdcLogEnhancerFilter destroy.");
    }
}

