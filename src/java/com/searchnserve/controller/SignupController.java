/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.controller;

import com.searchnserve.data.UserDB;
import com.searchnserve.model.UserAccount;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stephen
 */
@WebServlet(name = "SignupController", urlPatterns = {"/SignupController"})
public class SignupController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String message = "";
        
        if ("Join Now".equals(request.getParameter("joinNow"))){
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            
            // passwords don't match
            if (password == null || !password.equals(confirmPassword)){
                message = "Provided passwords don't match!";
                session.setAttribute("message", message);
            } else{
                UserAccount user = new UserAccount();
                user.setName(request.getParameter("fullName"));
                user.setEmailAddress(request.getParameter("email"));
                user.setPasswordHash(request.getParameter("password"));
                
                // account already exists
                if (UserDB.selectUserByEmail(user.getEmailAddress()) != null){
                    message = "Provided email address already exists!";
                } else if (UserDB.createAccount(user) == false){ // create account
                    message = "Account could not be created";
                }
                
            }
        }
        
        // add message to session
        request.setAttribute("message", message);
        
        // navigate to the signup screen
        getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);

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
