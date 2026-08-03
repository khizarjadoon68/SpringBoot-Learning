package in.strikes.filterDemo.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        //Store the time in millimeter .
        Long startTime = System.currentTimeMillis();

        HttpServletRequest httpRequest =
                (HttpServletRequest) servletRequest ;

        HttpServletResponse httpResponse =
                (HttpServletResponse) servletResponse ;

        //Create Random RequestId .
        String requestId = UUID.randomUUID().toString();

        //Set Id ni RequestHeader
        httpResponse.setHeader("X-Request-Id" , requestId);

        //Request Log
        System.out.println("Incoming Request : "
                +httpRequest.getMethod() +" "
                +httpRequest.getRequestURI());


        try {
            /*
            I have finished my work in this filter.
            Now continue the request to the next filter or to the target servlet/controller.
             */
            filterChain.doFilter(servletRequest ,servletResponse);
        }
        finally {
            //Total duration of Request time .
            //This Request takes how much time .
            Long duration = System.currentTimeMillis() - startTime ;

            //Response Status Log .
            System.out.println("Response Status : "
                    +httpResponse.getStatus());

            System.out.println("API Response Time :  "+duration);

        }


    }
}
