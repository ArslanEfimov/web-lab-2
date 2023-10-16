package com.arslanefimov.lab2.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(filterName = "RedirectFilter", servletNames = "ControllerServlet")
public class RedirectFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String servletPath = ((HttpServletRequest) request).getServletPath();
        
        if(servletPath.equals("/controller")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/controller");
            dispatcher.forward(request, response);
        }
        else{
            filterChain.doFilter(request, response);
        }
    }
}
