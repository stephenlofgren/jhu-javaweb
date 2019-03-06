/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchNServe.view;

import com.searchNServe.model.UserAccountDAO;
import com.searchNServe.model.UserAccountDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author jjose
 */
public class LoginAction extends org.apache.struts.action.Action {

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ActionErrors errors = new ActionErrors();
        String forwardMapping = "failure";
        
        LoginForm loginForm = (LoginForm)form;
        UserAccountDTO loggedInUser = new UserAccountDTO();
        loggedInUser.setUserName(loginForm.getUserName());
        loggedInUser.setPassword(loginForm.getPassword());
        
        
        
        if (UserAccountDAO.login(loggedInUser))
        {
            // if login is successful, place user into session
            request.getSession().setAttribute("loggedInUser", loggedInUser);
            forwardMapping = "success";
        }
        else
        {
            errors.add("loginUnsuccessful", 
                    new ActionMessage("errors.loginUnsuccessful"));
            super.saveErrors(request, errors);
            forwardMapping = "failure";
        }
        
        return mapping.findForward(forwardMapping);
    }
}
