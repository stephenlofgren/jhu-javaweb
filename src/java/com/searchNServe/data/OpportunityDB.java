/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchNServe.data;

import com.searchNServe.model.Opportunity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
    
        public static void update(Opportunity opportunity) {
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(opportunity);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Opportunity opportunity) {
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(opportunity));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static Opportunity selectOpportunity(String email) {
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        String qString = "SELECT u FROM Opportunity u " +
                "WHERE u.email = :email";
        TypedQuery<Opportunity> q = em.createQuery(qString, Opportunity.class);
        q.setParameter("email", email);
        try {
            Opportunity o = q.getSingleResult();
            return o;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        Opportunity u = selectOpportunity(email);   
        return u != null;
    }
}
