package in.strikes.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {


        HttpServletRequest httpRequest
                = (HttpServletRequest) servletRequest;

        HttpServletResponse httpResponse =
                (HttpServletResponse) servletResponse;

        String token = httpRequest.getHeader("token");

        if (token == null || !token.equals("12345")) {

            httpResponse.setStatus(httpResponse.SC_UNAUTHORIZED);

            httpResponse.setContentType("Application/json");
            httpResponse.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Authentication is Requires\"\n" +
                            "}"
            );

            return ;

        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

}