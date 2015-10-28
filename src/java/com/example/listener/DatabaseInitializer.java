/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.listener;

import com.example.database.Database;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author AhmadSulha
 */
public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        String url = sc.getInitParameter("url");
        String database = sc.getInitParameter("database");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");
        Database db = new Database(url, database, username, password);
        sc.setAttribute("database", db);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
