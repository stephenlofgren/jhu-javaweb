package com.searchNServe.view;

import com.searchNServe.data.DBUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
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
