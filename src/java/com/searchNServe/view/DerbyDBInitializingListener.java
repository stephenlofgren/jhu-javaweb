package com.searchNServe.view;

import com.searchNServe.model.DBUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DerbyDBInitializingListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        DBUtil.initializeDB();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        DBUtil.destroyDB();
    }
}
