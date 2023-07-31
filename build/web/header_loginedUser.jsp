<%-- 
    Document   : header_loginedUser
    Created on : Feb 24, 2023, 9:53:29 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSSS/mycss.css"/>
    </head>
    <body>

        <nav>
            <li> <a href="index.jsp" >Home</a> </li>
            <li> <a href="changeProfile.jsp">Change Profile</a> </li>
            <li> <a href="completedOders.jsp">Completed Orders</a> </li>
            <li> <a href="canceledOrders.jsp">Canceled Orders</a> </li>
            <li> <a href="processingOrder.jsp">Processing Orders</a> </li>
            <form action="mainController" method="post"   class="">
                <li> from <input type="date" name="txtfrom" value="<%= (request.getParameter("txtfrom") == null) ? "" : request.getParameter("txtfrom")%>"> to <input type="date" name="txtto" value="<%= (request.getParameter("txtto") == null) ? "" : request.getParameter("txtto")%>">
                    <input type="submit" value="Search" name="action">
                </li>
            </form>
        </nav>
    </body>
</html>
