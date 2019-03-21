/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.data;

import com.searchnserve.model.Opportunity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    
    public static Opportunity selectOpportunityByTitle(String title) {
        String qString = "SELECT o FROM Opportunity o where o.title = :title";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", title);
        return GenericEntityDB.<Opportunity>selectOne(qString, params, Opportunity.class);
    }

    public static Opportunity selectOpportunityById(long id) {
        String qString = "SELECT o FROM Opportunity o where o.id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return GenericEntityDB.<Opportunity>selectOne(qString, params, Opportunity.class);
    }

    public static List<Opportunity> selectOpportunityRandom(int max) {
        String qString = "select id from JHUJAVAWEB.OPPORTUNITY order by RANDOM()";
        List o = EMFUtil.getResultList(qString, max);
        List<Opportunity> results = new ArrayList<Opportunity>();
        for(int i = 0; i < o.size(); i++){
            long id = (long)o.get(i);
            Opportunity opp = selectOpportunityById(id);
            results.add(opp);            
        }
        return results;
    }
}