/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;

/**
 * Web application lifecycle listener.
 *
 * @author Harri Renney
 */
public class ServletContextListener implements javax.servlet.ServletContextListener, ServletContextAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {    
        ServletContext sc = sce.getServletContext();
        String databaseName = sc.getInitParameter("databaseName");
        JDBCWrapper wrapper = new JDBCWrapper(databaseName, "jdbc:derby://localhost:1527/XYZ Web Application DB", "root", "root");
        sc.setAttribute("database", wrapper);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
