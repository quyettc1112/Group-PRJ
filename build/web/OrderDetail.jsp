<%-- 
    Document   : OrderDetail
    Created on : Feb 25, 2023, 2:50:44 PM
    Author     : Admin
--%>

<%@page import="sample.dao.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.dto.OrderDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSSS/orderdetail.css"/>
    </head>
    <body>
        <section>
            <%@include file="CSSHeader.jsp" %> 
            <a href="personalPage.jsp">View all orders</a>      
        </section>

        <!--load all orders of the user here-->
        <section> 
            <%
                String orderid = request.getParameter("orderid");
                if (orderid != null) {
                    int orderID = Integer.parseInt(orderid.trim());
                    ArrayList<OrderDetail> list = OrderDAO.getOrderDetail(orderID);
                    if (list != null && !list.isEmpty()) {
                        int money = 0;
                        for (OrderDetail od : list) {%>
                        <table class="order">
                <tr>
                    <td>Order ID</td>
                    <td>Plant ID</td>
                    <td>Plant Name</td>
                    <td>Image</td>
                    <td>Price</td>
                    <td>Quantity</td>
                </tr>
                <tr>
                    <td>  <%=  od.getOrderDetailID()%>   </td>
                    <td>  <%=  od.getPlantID()%>   </td> 
                    <td>  <%=  od.getPlantName()    %>  </td>
                    <td><img src='<%=  od.getImgpath()   %>' class="plantimg" />
                    <td>  <%=  od.getPrice()%>   </td>
                    <td>  <%=  od.getQuantity()%>   </td>
                    <% money = money + od.getPrice() * od.getQuantity(); %>

                </tr>            
            </table>
            <% }   // end for %>                    
            <h3>Total money: <%= money%></h3>
            <%   } // end if 
            else {
            %>
            <p>Your dont have any order</p> 
            <%
                    }
                }
            %>           
        </section>
        
        <section class="footer">
            <%@include file="CSSFooter.jsp" %>
        </section>
    </body>
</html>
