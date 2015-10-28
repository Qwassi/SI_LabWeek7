/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
//import the model
import com.example.model.CalculateShippingPrice;
//import the databse class
import com.example.database.Database;

/**
 *
 * @author MIIT190614
 */
public class DeliveryServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        double weight = Double.parseDouble(request.getParameter("weight"));
        double pricePerKg;
        double shippingPrice;
        String sqlExecutionStatus;
        CalculateShippingPrice calculateShippingPrice = new CalculateShippingPrice();
        pricePerKg = calculateShippingPrice.calculatePricePerKg(weight);
        shippingPrice = calculateShippingPrice.calculateTotalShippingPrice(pricePerKg,weight);
        
        //Database related tasks
        Database db = (Database)getServletContext().getAttribute("database");
        sqlExecutionStatus = db.executeSql(weight, shippingPrice);
        
        request.setAttribute("weight", weight);
        request.setAttribute("pricePerKg", pricePerKg);
        request.setAttribute("shippingPrice", shippingPrice);
        request.setAttribute("sqlExecutionStatus", sqlExecutionStatus);

        //ServletContext servletContext = getServletContext();
        //Alternative - use request.getRequestDispatcher()
        //RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("output.jsp");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("output.jsp");
        requestDispatcher.forward(request, response);
    }
}
