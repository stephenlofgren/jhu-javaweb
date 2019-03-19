/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchNServe.data;

import com.searchNServe.model.Opportunity;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author stephen
 */
public class OpportunityDB {
    
    public static Opportunity selectOpportunity(String title) {
        String qString = "SELECT o FROM Opportunity o where o.title = :title";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", title);
        return GenericEntityDB.<Opportunity>select(qString, params, Opportunity.class);
    }
}
