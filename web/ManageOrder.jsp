<%-- 
    Document   : ManageOrder
    Created on : Mar 10, 2023, 9:38:58 AM
    Author     : ASUS
--%>

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
            if (name == null) {
        %>
        <p><font color="red"> You must be an admin to access the site</font> </p>
        <p></p>
        <%} else {
        %>
        <header><c:import url="header_loginedAdmin.jsp"/></header>
        <h1>ORDER TABLE</h1>
        <table class="order">
            <tr>
                <th>FULLNAME</th>
                <th>ORDER ID</th>
                <th>ORD DATE</th>
                <th>SHIPDATE</th>
                <th>STATUS</th>
                <th>ACC ID</th>
            </tr>
            <tbody>
                <c:forEach var="o" items="${sessionScope.orderlist}">
                    <tr>
                        <td>${o.getFullname()}</td>
                        <td>${o.getOrderID()}</td>
                        <td>${o.getOderDate()}</td>
                        <td>${o.getShopDate()}</td>
                        <td>${o.getStatus()}</td>
                        <td>${o.getAccID()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h1>SEARCH ORDER BY NAME</h1>
        <form action="mainController" method="POST">
            <input type="text" name="txtsearch">
            <input type="submit" value="searchBN" name="action">
        </form>


        <h1>SEARCH ORDER BY DATE</h1>
        <form action="mainController" method="POST">
            <label>From-date:</label>
            <input type="date" name="DATEB" required=""/>
            <label>To-date:</label>
            <input type="date" name="DATEE" required=""/>
            <input type="submit" value="SearchBD" name="action"/>
        </form>

        <h1>INFORMATION ORDER</h1>
        <c:if test="${requestScope.Ord == null}">
            <h3><c:out value="${requestScope.ERROR}" default=""/></h3>
        </c:if>
        <table class="order">
            <tr>
                <th>FULLNAME</th>
                <th>ORDER ID</th>
                <th>ORD DATE</th>
                <th>SHIPDATE</th>
                <th>STATUS</th>
                <th>ACC ID</th>
            </tr>
            <tbody>
                <c:forEach var="bn" items="${requestScope.Ord}">
                    <tr>
                        <td>${bn.getFullname()}</td>
                        <td>${bn.getOrderID()}</td>
                        <td>${bn.getOderDate()}</td>
                        <td>${bn.getShopDate()}</td>
                        <td>${bn.getStatus()}</td>
                        <td>${bn.getAccID()}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <%}%> 
    </body>
</html>
