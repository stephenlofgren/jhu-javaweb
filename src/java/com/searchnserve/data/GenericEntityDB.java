/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.data;

import com.searchnserve.model.Opportunity;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * @param <T> the type of the Entity being persisted
 * @author stephen
 */ 
public class GenericEntityDB {
    
    public static <T> void insert(T t){
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        if(!trans.isActive())
            trans.begin(); 
        
        try{
            em.persist(t);
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
            throw(ex);
        } finally {
            em.close();
        }
    }
    
        public static <T> void update(T t) {
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        if(!trans.isActive())
            trans.begin(); 

        try {
            t = em.merge(t);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            if(trans != null && trans.isActive())
                trans.rollback();
        } finally {
            em.close();
        }
    }

    public static <T> void delete(T t) {
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        if(!trans.isActive())
            trans.begin(); 
        
        try {
            em.remove(em.merge(t));
            trans.commit();
        } catch (   Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
    
    public static <T> T selectOne(String qString, Map<String, Object> parameters, Class<T> typeClass) {
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        TypedQuery<T> q = em.createQuery(qString, typeClass);
        for (Map.Entry<String,Object> entry : parameters.entrySet()){
            q.setParameter(entry.getKey(), entry.getValue());
        }
        try {
            List<T> o = q.getResultList();
            return o.get(0);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static <T> List<T> select(String qString, Map<String, Object> parameters, Class<T> typeClass) {
        EntityManager em = EMFUtil.getFactory().createEntityManager();
        TypedQuery<T> q = em.createQuery(qString, typeClass);
        for (Map.Entry<String,Object> entry : parameters.entrySet()){
            q.setParameter(entry.getKey(), entry.getValue());
        }
        try {
            List<T> o = q.getResultList();
            return o;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
