/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchNServe.data;

import com.searchNServe.model.Opportunity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author stephen
 */
public class OpportunityDB {

    public static void insert(Opportunity opportunity){
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(opportunity);
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
            throw(ex);
        } finally {
            em.close();
        }
    }
    
}
