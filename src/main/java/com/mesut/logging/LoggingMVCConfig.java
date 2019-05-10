package com.mesut.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoggingMVCConfig implements WebMvcConfigurer {

    @Autowired
    private RequestResponseLogInterceptor requestResponseLogInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestResponseLogInterceptor)
                .addPathPatterns("/**/customer/**/");
    }
}