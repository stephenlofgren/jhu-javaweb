/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stephen
 */
public class SessionTokenRequestListener implements Filter {
    public FilterConfig filterConfig; 
    
    private void createSessionCookie(ServletRequest request, ServletResponse response){
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (request.getParameter("JSESSIONID") != null) {
            Cookie userCookie = new Cookie("JSESSIONID", req.getParameter("JSESSIONID"));
            res.addCookie(userCookie);
        } else {
            String sessionId = session.getId();
            Cookie userCookie = new Cookie("JSESSIONID", sessionId);
            res.addCookie(userCookie);
        }

    }
    
    public void doFilter(final ServletRequest request,                //2
        final ServletResponse response,FilterChain chain)
        throws java.io.IOException, javax.servlet.ServletException { 
        createSessionCookie(request, response);
        chain.doFilter(request,response);                               //3
    } 

  public void init(final FilterConfig filterConfig) {               //4
    this.filterConfig = filterConfig;
  } 

  public void destroy() {                                           //5
  }

}
