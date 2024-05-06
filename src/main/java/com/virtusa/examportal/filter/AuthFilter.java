package com.virtusa.examportal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/siteController")
public class AuthFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
               HttpServletRequest req = (HttpServletRequest) request; 
               HttpServletResponse resp = (HttpServletResponse) response; 
               System.out.println("inside filter");
               String user = (String) req.getSession().getAttribute("user");
               resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
               if(user==null){
                   resp.sendRedirect(req.getContextPath()+"/loginController?action=login");
                }else{
                chain.doFilter(request, response);
               } 
    }

    @Override
    public void destroy() {
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

   
    
}
