package in.strikes.filterDemo.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
public class ResponseHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) servletRequest ;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) servletResponse ;

        String requestId = UUID.randomUUID().toString();

        //Headers are in key value pair .
        //This is the key " x-request-id : " .
        //This is the value " requestId " .
        httpServletResponse.setHeader("x-request-id : ",requestId);

        filterChain.doFilter(httpServletRequest ,httpServletResponse);

    }
}
