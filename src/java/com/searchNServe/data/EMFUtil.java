/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchNServe.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFUtil {
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("SearchNServePU");
    
    public static EntityManagerFactory getFactory() {
        return emf;
    }
    
    public static void runUpdate(String dml){
        EntityManager em = getFactory().createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery(dml).executeUpdate();
        em.getTransaction().commit();
    }
}
