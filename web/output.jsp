<%-- 
    Document   : output
    Created on : Oct 23, 2015, 11:58:59 AM
    Author     : MIIT190614
--%>

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
                double shippingPrice;
                shippingPrice = (Double)request.getAttribute("shippingPrice");
                
            %>
            Price: <% out.print(shippingPrice); %>
        </p>
    </body>
</html>
