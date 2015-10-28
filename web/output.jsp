<%-- 
    Document   : output
    Created on : Oct 23, 2015, 11:58:59 AM
    Author     : MIIT190614
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shipping Cost</h1>
        <p>
            <%
                //".00" MEANS EXACTLY 2 DECIMAL POINT.
                //".##" will drop useless zeroes
                DecimalFormat df = new DecimalFormat("#.00");
                double shippingPrice;
                double pricePerKg;
                pricePerKg = (Double)request.getAttribute("pricePerKg");
                shippingPrice = (Double)request.getAttribute("shippingPrice");
            %>
            Shipping Weight: <% out.println(request.getAttribute("weight")); %>
            <br />
            Price Per KG: <% out.println("RM " + df.format(pricePerKg)); %>
            <br />
            Total Shipping Price: <% out.println("RM " + df.format(shippingPrice)); %>
            <br />
            Note: <%out.println(request.getAttribute("sqlExecutionStatus")); %>
        </p>
    </body>
</html>
