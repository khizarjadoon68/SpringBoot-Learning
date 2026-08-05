package com.example.interceptorDemo.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object handler) {

        System.out.println("Incoming Request -------");
        System.out.println("Http Method : "+httpServletRequest.getMethod());
        System.out.println("Request URI : "+httpServletRequest.getRequestURI());
        System.out.println("Request Parameters : "+httpServletRequest.getQueryString());
        System.out.println("Client IP : "+httpServletRequest.getRemoteAddr());
        System.out.println("Token Header : "+httpServletRequest.getHeader("token"));
        System.out.println("x-user-role Header :"+httpServletRequest.getHeader("x-user-role"));

        if (handler instanceof HandlerMethod handlerMethod){
            System.out.println("Controller Name : "+handlerMethod.getBeanType().getName());
            System.out.println("Controller Method : "+handlerMethod.getMethod().getName());
        }

        return true;
    }


        public void afterCompletion (HttpServletRequest httpServletRequest,
                HttpServletResponse httpServletResponse,
                Object handler,
                Exception ex){

            System.out.println("Response Status :"+httpServletResponse.getStatus());

        }

    }

