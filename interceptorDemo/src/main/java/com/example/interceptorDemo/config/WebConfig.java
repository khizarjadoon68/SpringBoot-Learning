package com.example.interceptorDemo.config;

import com.example.interceptorDemo.interceptor.AuthenticationInterceptor;
import com.example.interceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private LoggingInterceptor loggingInterceptor ;
    private AuthenticationInterceptor authenticationInterceptor ;


    public WebConfig (LoggingInterceptor loggingInterceptor ,
                      AuthenticationInterceptor authenticationInterceptor){
        this.loggingInterceptor = loggingInterceptor ;
        this.authenticationInterceptor =authenticationInterceptor ;

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**");
        registry.addInterceptor(loggingInterceptor) ;
    }
}
