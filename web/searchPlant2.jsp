<%-- 
    Document   : searchPlant2
    Created on : Feb 19, 2023, 9:57:37 PM
    Author     : Admin
--%>

<%@page import="sample.dto.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSSS/mycss.css"/>
    </head>
    <body>
        <%
            ArrayList<Plant> list = (ArrayList) request.getAttribute("listPlan");
            if (list != null && list.size() > 0) {

        %>
        <table>               
            <tr>
                <td>Product ID</td>
                <td>Name</td>
                <td>Price</td>
                <td>Image</td>
                <td>Detail</td>
                <td>Action</td>           
            </tr>
            <%     for (Plant o : list) {

            %>

            <tr class="logoo">
                <td><%= o.getId() %></td> 
                <td><%= o.getName() %></td> 
                <td><%= o.getPrice() %></td> 
                <td><img src='<%= o.getImgpath() %>' /></td>
                <td><a href='#'>view detail</a></td>
                <td><a href='#'>add to your cart</a></td>        
            </tr>
            
            <%
                    }
                }
        %>
         </table>
    </body>
</html>
