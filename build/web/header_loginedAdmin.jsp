<%-- 
    Document   : header_loginedAdmin
    Created on : Feb 26, 2023, 11:28:10 AM
    Author     : ASUS
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
        <header>
            <ul>
                <li><a href="mainController?action=manageAccounts">Manage Account</a></li>     
                <li><a href="mainController?action=manageOrder">Manager Order</a></li>
                <li><a href="mainController?action=managePlant">Manager Plant</a></li>
                <li><a href="mainController?action=manageCategories">Manager Categories</a></li>
                <li><a href="index.jsp">Home</a></li>
                <li>Welcome ${sessionScope.name} | <a href="mainController?action=logout">logout</a></li>
                
            </ul>

        </header>
    </body>
</html>
