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
import javax.servlet.http.Cookie;
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
        String returnUri = "/signup.jsp";   
        boolean addUser = "Join Now".equals(request.getParameter("action"));

        // create new UserAccount object for add, or retrieve from session for
        // edit
        UserAccount user = addUser ? new UserAccount()
                : (UserAccount) request.getSession().getAttribute("userAccount");
        user.setName(request.getParameter("fullName"));

        // verify if email exists in db for add user, or for edit user if the 
        // email is different from what's saved for the user
        if (addUser
                || (!addUser && !user.getEmailAddress().equalsIgnoreCase(request.getParameter("email")))) {
            
            if (UserDB.selectUserByEmail(request.getParameter("email")) != null) {
                message = "Provided email address already exists.<br/>";
            } else {
                user.setEmailAddress(request.getParameter("email"));
            }
            
        }

        // validate that password and password confirmation match
        if (!request.getParameter("password").equals(
                request.getParameter("confirmPassword"))) {
            message += "Provided passwords don't match.";
        } else {
            user.setPasswordHash(request.getParameter("password"));
        }

        // if message is empty there are no validation errors, and data should
        // be saved in the db
        if ("".equals(message)) {
            if (addUser) {
                if (UserDB.createAccount(user) == false) { // create account
                    message = "Account could not be created.";
                }
            } else {
                if (UserDB.updateAccount(user) == false) { // update account
                    message = "Account could not be updated.";
                }
            }
        }

        // if message is still empty, then data was successfuly saved in the db
        if ("".equals(message)) {
            // place new or updated user into session
            session.setAttribute("userAccount", user);
            if (request.getAttribute("returnUri") == null) {
                returnUri = "/HomeController";
            } else {
                returnUri = (String) request.getAttribute("returnUri");
                request.removeAttribute("returnUri");
            }
        } else {
            // add message to request
            request.setAttribute("message", message);
            // add temporary user to request so form values are preserved
            request.setAttribute("userAccount", user);
        } 
        
        // navigate to the signup screen
        response.sendRedirect(request.getContextPath() + returnUri);   

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
