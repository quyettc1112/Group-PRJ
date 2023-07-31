<%-- 
    Document   : completedOders
    Created on : Feb 26, 2023, 7:27:22 PM
    Author     : Admin
--%>

<%@page import="sample.dao.OrderDAO"%>
<%@page import="sample.dto.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            if (name == null) {

        %> 
        <p>You must login to view personal page</p>
        <%        } else {
        %>
        <h1>Completed Order</h1>
        <header>
            <%@include file="header_loginedUser.jsp" %>          
        </header>
        <section>
            <%
                ArrayList<Order> list = OrderDAO.getOrders(email);
                String[] status = {"", "Processcing", "Completed", "Canceled"};
                int count = 0;
                if (list != null && !list.isEmpty()) {
                    for (Order ord : list) {
                       if (ord.getStatus() == 2) {
                       count++;
            
            %>
            <table class="order">
                <tr>
                    <td>Order ID</td>
                    <td>Oder Date</td>
                    <td>Ship Date</td>
                    <td>Orders Status</td>
                    <td>Action</td>
                </tr>
                <tr>
                    <td><%= ord.getOrderID()%></td>
                    <td><%= ord.getOderDate()%></td>
                    <td><%= ord.getShopDate()%></td>
                    <td><%=  status[ord.getStatus()]%>
<!--                        <br/> comment 
                        <% // if (ord.getStatus() == 1)%> <a href="#">Cancel Order</a>-->

                    </td>
                    <td> <a href="OrderDetail.jsp?orderid=<%=   ord.getOrderID()   %>" />Detail</td>
                </tr>
            </table>       

            <% }
                } if (count <= 0) { %>
                <p>Have no Order Completed</p>
            <% }


            } else {
            %>
            <p>Your have no order</p>
            <% } }%>
            
            
        </section>
        <footer class="footer">
            <%@include file="CSSFooter.jsp" %> 
        </footer>
    </body>
</html>
