package in.strikes.filterDemo.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        Long startTime = System.currentTimeMillis();

        HttpServletRequest httpRequest =
                (HttpServletRequest) servletRequest ;

        HttpServletResponse httpResponse =
                (HttpServletResponse) servletResponse ;

        String requestId = UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-Id" , requestId);

        //Request Log
        System.out.println("Incoming Request : "
                +httpRequest.getMethod() +" "
                +httpRequest.getRequestURI());


        try {
            filterChain.doFilter(servletRequest ,servletResponse);
        }
        finally {
            Long duration = System.currentTimeMillis() - startTime ;

            //Response Status Log .
            System.out.println("Response Status : "
                    +httpResponse.getStatus());

            System.out.println("API Response Time :  "+duration);

        }


    }
}
