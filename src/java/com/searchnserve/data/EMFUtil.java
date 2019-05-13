/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EMFUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SearchNServePU");
    
    public static EntityManagerFactory getFactory() {
        return emf;
    }
    
    public static void runUpdate(String dml){
        EntityManager em = getFactory().createEntityManager();
        try{
            em.getTransaction().begin();
            em.createNativeQuery(dml).executeUpdate();
            em.getTransaction().commit();
        } finally {
            if(em.isOpen())
                em.close();
        }
    }

    public static List getResultList(String dml){
        EntityManager em = getFactory().createEntityManager();        
        try{
            return em.createNativeQuery(dml).getResultList();
        } catch(Exception ex) {
            return null;
        } finally {
            if(em.isOpen())
                em.close();
        }
    }

    public static List getResultList(String dml, int max){
        EntityManager em = getFactory().createEntityManager();        
        try{
            Query q = em.createNativeQuery(dml);
            q.setMaxResults(max);
            return q.getResultList();
        } catch(Exception ex) {
            return null;
        } finally {
            if(em.isOpen())
                em.close();
        }
    }

    public static Object getFirstResult(String dml){
        EntityManager em = getFactory().createEntityManager();        
        try{
            return em.createNativeQuery(dml).getSingleResult();
        } catch(Exception ex) {
            return null;
        } finally {
            if(em.isOpen())
                em.close();
        }
    }
    
    public static void destroyDB(){
        if(getFactory().isOpen())
            getFactory().close();
    }
    
}
