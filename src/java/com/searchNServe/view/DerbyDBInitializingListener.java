package com.searchNServe.view;

import javax.persistence.*;
import javax.servlet.*;
import com.searchNServe.data.DBUtil;
import com.searchNServe.data.EMFUtil;
import com.searchNServe.data.OpportunityDB;
import com.searchNServe.model.Opportunity;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class DerbyDBInitializingListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        Opportunity o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Tutoring at the YMCA");
        o.setDescription("Helping younger students with their homework");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Basking Ridge");
        o.setState("New Jersey");
        OpportunityDB.insert(o);
        //DBUtil.initializeDB();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        //DBUtil.destroyDB();
    }
}
