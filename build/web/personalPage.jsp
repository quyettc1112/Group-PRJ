
<%@page import="sample.dto.Account"%>
<%@page import="sample.dao.AccountDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.dao.OrderDAO"%>
<%@page import="sample.dto.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            String from = (String) request.getParameter("txtfrom");
            String to = (String) request.getParameter("txtto");
            Cookie[] c = request.getCookies();
            boolean login = false;
            if (name == null) {
                String token = "";
                for (Cookie aCookie : c) {
                    if (aCookie.getName().equals("selector")) {
                        token = aCookie.getValue();
                        Account acc = AccountDAO.getAccount(token);
                        if (acc != null) {
                            name = acc.getFullname();
                            email = acc.getEmail();
                            login = true;
                        }
                    }
                }
            } else {
                login = true;
            }
            
            //show content if login=true
            if (login == true) {
        %>
        <header>
            <%@include file="header_loginedUser.jsp" %>          
        </header>

        <section>
            <h3>Welcome <%= name%> come back</h3>
            <h3> <a href="mainController?action=logout">Logout</a></h3>
        </section>

        <section>
            <%
                ArrayList<Order> list = OrderDAO.getOrders(email);
                ArrayList<Order> list2 = OrderDAO.getOrders(from, to);
                String[] status = {"", "Processcing", "Completed", "Canceled"};
                if (list2 !=null  &&  !list2.isEmpty()) {
                        list.clear();
                        list.addAll(list2);
                    }
                if (list != null && !list.isEmpty()) {
                    for (Order ord : list) {%>
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
                        <br/><!-- comment -->
                        <% if (ord.getStatus() == 1)%> <a href="#">Cancel Order</a>

                    </td>
                    <td> <a href="OrderDetail.jsp?orderid=<%=   ord.getOrderID()   %>" />Detail</td>
                </tr>


            </table>       

            <% }
            } else {
            %>
            <p>Your don't have any order</p>
            <% }
                } else { %>
                <a href="login.jsp">U need to login</a>
                
                <%
                    }
            %>
        </section>


        <footer class="footer">
            <%@include file="CSSFooter.jsp" %> 
        </footer> 
    </body>
</html>
