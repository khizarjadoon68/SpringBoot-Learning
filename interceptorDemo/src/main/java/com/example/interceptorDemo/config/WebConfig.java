package com.example.interceptorDemo.config;

import com.example.interceptorDemo.interceptor.AuthenticationInterceptor;
import com.example.interceptorDemo.interceptor.AuthorizationInterceptor;
import com.example.interceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private LoggingInterceptor loggingInterceptor ;
    private AuthenticationInterceptor authenticationInterceptor ;
    private AuthorizationInterceptor authorizationInterceptor ;


    public WebConfig (LoggingInterceptor loggingInterceptor ,
                      AuthenticationInterceptor authenticationInterceptor,
                      AuthorizationInterceptor authorizationInterceptor){
        this.loggingInterceptor = loggingInterceptor ;
        this.authenticationInterceptor =authenticationInterceptor ;
        this.authorizationInterceptor =authorizationInterceptor ;

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .order(1);
        registry.addInterceptor(loggingInterceptor)
                .order(3) ;
        registry.addInterceptor(authorizationInterceptor)
                .order(2);
    }
}
