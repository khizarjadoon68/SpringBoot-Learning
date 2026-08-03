package com.example.interceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle (HttpServletRequest request ,
                               HttpServletResponse response ,
                               Object handler)
            throws Exception{

        String requestHeader = request.getHeader("token");

        if (requestHeader == null || !requestHeader.equals("12345") ){
            response.setStatus(response.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\"message\" : \"Authentication is Requires\"}" );


            return false ;
        }
        return true ;

    }

}
