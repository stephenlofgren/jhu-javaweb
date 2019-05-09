/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.controller;

import com.searchnserve.data.UserDB;
import com.searchnserve.model.UserAccount;
import java.io.IOException;
import java.util.ArrayList;
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
        String error = "";
        String returnUri = "/signup.jsp";
        boolean addUser = "Join Now".equals(request.getParameter("action"));
        ArrayList<String> messages = new ArrayList<>();

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
                error = "Provided email address already exists.<br/>";
            } else {
                user.setEmailAddress(request.getParameter("email"));
            }

        }
        
        validateData(request, user, messages);
        if (!"".equals(error)){
            messages.add(error);
        }


        // if error is empty there are no validation errors, and data should
        // be saved in the db
        if (messages.isEmpty()) {
            if (addUser) {
                if (UserDB.createAccount(user) == false) { // create account
                    messages.add("Account could not be created.");
                }
            } else {
                if (UserDB.updateAccount(user) == false) { // update account
                    messages.add("Account could not be updated.");
                }
            }
        }

        // if error is still empty, then data was successfuly saved in the db
        if (messages.isEmpty()) {
            // place new or updated user into session
            session.setAttribute("userAccount", user);
            if (request.getAttribute("returnUri") == null) {
                returnUri = "/HomeController";
            } else {
                returnUri = (String) request.getAttribute("returnUri");
                request.removeAttribute("returnUri");
            }
        } else {
            // add error to request
            String message = "";
            for (String errorMessage: messages){
                message += errorMessage + "<br/>";
            }
            
            request.setAttribute("message", message);
            // add temporary user to request so form values are preserved
            request.setAttribute("userAccount", user);
        }

        // navigate to the signup screen
//        response.sendRedirect(request.getContextPath() + returnUri);
        request.getRequestDispatcher(returnUri).forward(request, response);

    }

    /**
     * Validates submitted data and populates the user object. Returns true if
     * data is valid and false otherwise. Validation error messages will be
     * populated in the messages ArrayList
     *
     * @param user
     * @param messages
     * @return
     */
    private boolean validateData(HttpServletRequest request,
            UserAccount user, ArrayList<String> messages) {
        boolean validationSuccessful = true;

        // full name
        user.setName(nullToEmpty(request.getParameter("fullName")));
        if ("".equals(user.getName())) {
            validationSuccessful = false;
            messages.add("Full name is required.");
        }

        // email
        user.setEmailAddress(nullToEmpty(request.getParameter("email")));
        if ("".equals(user.getEmailAddress())) {
            validationSuccessful = false;
            messages.add("Email is required.");
        }

        // password
        user.setPasswordHash(nullToEmpty(request.getParameter("password")));
        if ("".equals(user.getPasswordHash())) {
            validationSuccessful = false;
            messages.add("Password is required.");
        }
        
        if (user.getPasswordHash().length() < 10) {
            validationSuccessful = false;
            messages.add("Password must be at least 10 characters long.");
        }

        if ("".equals(nullToEmpty(request.getParameter("confirmPassword")))) {
            validationSuccessful = false;
            messages.add("Password Confirmation is required.");
        }

        if (!user.getPasswordHash().equals(nullToEmpty(request.getParameter("confirmPassword")))) {
            validationSuccessful = false;
            messages.add("Provided passwords must match.");
        }

        // phone number
        user.setPhoneNumber(nullToEmpty(request.getParameter("phoneNumber")));
        try {
            if (!"".equals(user.getPhoneNumber())){
                Long.parseLong(user.getPhoneNumber());
            }

        } catch (NumberFormatException nfe) {

            validationSuccessful = false;
            messages.add("Phone number cannot contain non-digit characters");
        }
        
        // address line 1
        user.setAddressLine1(nullToEmpty(request.getParameter("addressLine1")));
        
        // address line 2
        user.setAddressLine2(nullToEmpty(request.getParameter("addressLine2")));
        
        // city
        user.setCity(nullToEmpty(request.getParameter("city")));
        
        // state
        user.setState(nullToEmpty(request.getParameter("state")));
        
        // zip code
        user.setZipCode(nullToEmpty(request.getParameter("zipCode")));
        try {
            if (!"".equals(user.getZipCode())){
                Long.parseLong(user.getZipCode());
            }

        } catch (NumberFormatException nfe) {

            validationSuccessful = false;
            messages.add("Zip Code cannot contain non-digit characters");
        }

        return validationSuccessful;
    }

    private String nullToEmpty(String string) {
        return string == null ? "" : string.trim();
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
