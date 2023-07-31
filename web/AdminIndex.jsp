<%-- 
    Document   : AdminIndex
    Created on : Feb 25, 2023, 8:11:25 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name =(String) session.getAttribute("name");
            if(name == null){
        %>
        <p><font color="red"> You must be an admin to access the site</font> </p>
        <p></p>
        <%} else{
        %>
        <header>
            <c:import url="header_loginedAdmin.jsp"/>
        </header>        
        <section>
            <img src="images/admin-la-gi.jpg" alt="alt"/>
        </section>
        <%}%>
    </body>
</html>
