/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.controller;

import com.searchnserve.data.OpportunityDB;
import com.searchnserve.model.Opportunity;
import com.searchnserve.model.UserAccount;
import com.searchnserve.viewmodel.FeaturesViewModel;
import com.searchnserve.viewmodel.OpportunityViewModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "OpportunityController", urlPatterns = {"/OpportunityController"})
public class OpportunityController extends HttpServlet {

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
        UserAccount u = (UserAccount)session.getAttribute("userAccount");

        long id;
        id = Long.parseLong(request.getParameter("id"));
        Opportunity o = OpportunityDB.selectOpportunityById(id);
        
        OpportunityViewModel vm = new OpportunityViewModel();
        vm.setOpportunity(o);
        
        if(u != null){
            List<Opportunity> favs = u.getFavorites();
            for(int i = 0; i < favs.size(); i++){
                if(favs.get(i).getId() == id){
                    vm.setFavorite(true);
                    break;
                }
            }
        }        

        request.setAttribute(vm.getModelName(), vm);
        request.setAttribute("PageName", "Opportunity Details");

        getServletContext().getRequestDispatcher("/opportunity.jsp").forward(request, response);
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