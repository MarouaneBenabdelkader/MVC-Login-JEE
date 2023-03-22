package com.estf.login.prepexam.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();

        if((Boolean) session.getAttribute("Auth") == null){
            chain.doFilter(request, response);
            return;
        }
        Boolean flagg = (Boolean) session.getAttribute("Auth");

        if(flagg){
            ((HttpServletResponse) response).sendRedirect("home");
            return;
        }
        chain.doFilter(request, response);
    }
}
