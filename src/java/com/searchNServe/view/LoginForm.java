/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchNServe.view;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author jjose
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    
    private String userName = "";
    private String password = "";
    
    
    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getUserName() == null || getUserName().length() < 1) {
            errors.add("userName", new ActionMessage("errors.required", "Username"));
        }
        
        if (getPassword() == null || getPassword().length() < 1) {
            errors.add("password", new ActionMessage("errors.required", "Password"));
        }
        return errors;
    }

    
    /*
     ***************************************************** 
     * Getters/Setters
     *****************************************************  
     */
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String string) {
        userName = string;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
