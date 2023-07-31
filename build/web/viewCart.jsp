<%-- 
    Document   : viewCart
    Created on : Feb 26, 2023, 5:04:10 PM
    Author     : nanat
--%>

<%@page import="sample.dao.PlanDAO"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSSS/styleindex.css"/>
    </head>
    <body>
        <header>
            <%@include file="CSSHeader.jsp" %>
        </header>
        <section> 
            <%
                String name = (String) session.getAttribute("name");
                if (name != null) {
            %>
            <div>
                <h3>Welcome <%= session.getAttribute("name")%> come back </h3>
                <h3><a href="mainController?action=logout">Logout</a> </h3>
                <h3><a href="personalPage.jsp">Personal page</a></h3>
            </div>

            <%
                }
            %>
            <font style='color:red;'><%= (request.getAttribute("WARNING") == null) ? "" : (String) request.getAttribute("WARNING")%> </font>

            <table style="width: 100%"> 

                <% HashMap<String, Integer> cart = (HashMap) session.getAttribute("cart");
                    if (cart != null && !cart.isEmpty()) {
                %>
                <tr class="formTR"><td>Product id</td><td>Quantity</td><td>Image</td><td>Price</td><td>Action</td></tr>
                <%
                    int total = 0;
                    if (cart != null) {
                        Set<String> pids = cart.keySet();
                        for (String pid : pids) {
                            int quantity = cart.get(pid);
                %>
                
                <form action="mainController"  method="post"  >
                    <tr class="formTR"><td><input type="hidden" value="<%= pid%>" name="pid"><a href="#"><%= pid%></a></td>
                        <td><input type="number" value="<%= quantity%>" name="quantity"></td>    
                        <td class="logoo" > <img " src="<%= PlanDAO.getPlantsIMG(pid)%>" /> </td>    
                        <td> <%= PlanDAO.getPlantsPrice(pid)%> </td>
                        <td><input type="submit" value="update" name="action">
                            <input type="submit" value="delete" name="action"></td
                    </tr>
                </form>  
                    
                
                
                <%
                        total = total + (quantity * PlanDAO.getPlantsPrice(pid));
                    }
                %>
                <tr><td>Total money: <%= total%> </td></td></tr>
                <%
                } else {
                %>
                <h1>Your cart is empty</h1>
                <%  }
                %>

            </table>


        </section>

        <section> 
            <form action="mainController" method="post">
                <input type="submit" value="saveOrder" name="action" class="submitorder">
            </form>
        </section>


        <%
        } else {
        %>
        <h1 style="font-size: 30px;">Your have no order <a href="index.jsp" style="color: red">Click here to back and buy something :) </a></h1>
        <% }%>

        <footer class="footer">
            <%@include file="CSSFooter.jsp" %>
        </footer>
    </body>

</html>
