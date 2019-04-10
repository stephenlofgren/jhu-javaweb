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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        UserAccount userAccount = new UserAccount();

        String returnUri = "/login.jsp";
        
        if ("Login".equals(request.getParameter("login"))){
            userAccount.setEmailAddress(request.getParameter("email"));
            userAccount.setPasswordHash(request.getParameter("password"));
            
            if ((userAccount = UserDB.login(userAccount)) != null){
                if(request.getAttribute("returnUri") == null){
                    session.setAttribute("userAccount", userAccount);
                    message = "Login successful:" + userAccount.getName();
                }
                else{
                    returnUri = (String) request.getAttribute("returnUri");
                    request.removeAttribute("returnUri");
                }
            } else {
                 // add message to session
                message = "Login unsuccessful";
            }
        }
        else if("Logout".equals(request.getParameter(("logout")))){
            session.removeAttribute("userAccount");
        }

        request.setAttribute("message", message);
                
        // navigate to the login screen
        getServletContext().getRequestDispatcher(returnUri).forward(request, response);
   
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
