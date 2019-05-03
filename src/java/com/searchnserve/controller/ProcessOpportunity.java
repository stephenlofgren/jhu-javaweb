/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.controller;

import com.searchnserve.data.GenericEntityDB;
import com.searchnserve.model.Opportunity;
import com.searchnserve.model.UserAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bert
 */
@WebServlet(name = "ProcessOpportunity", urlPatterns = {"/ProcessOpportunity"})
public class ProcessOpportunity extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String name = null, email = null, title = null, city = null, state = null, description = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ServletContext servletContext = getServletContext();
        //first get a UserAccount from session
        UserAccount u = (UserAccount)session.getAttribute("userAccount");
        name = u.getName();
        email = u.getEmailAddress();
        title = request.getParameter("title");
        city = request.getParameter("city");
        state = request.getParameter("state");
        description = request.getParameter("description");
        
        Opportunity o = new Opportunity();
        o.setContactName(u.getName());
        o.setTitle(title);
        o.setDescription(description);
        o.setEmailAddress(u.getEmailAddress());
        o.setCity(city);
        o.setState(state);
        GenericEntityDB.<Opportunity>insert(o);
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("title", title);
        getServletContext().getRequestDispatcher("/completeform.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
