<%-- 
    Document   : ManageCategories
    Created on : Mar 5, 2023, 3:04:09 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSSS/mycss.css"/>
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
        <header><c:import url="header_loginedAdmin.jsp"/></header>
        
        <form action="mainController" method="post">
            <input type="text" name="searchName"/>
            <input type="submit" value="searchCate"  name="action" >
        </form>
        <c:if test="${requestScope.SID == null}">
            <h3><c:out value="${requestScope.ERROR}" default=""/></h3>
        </c:if>

        <h1>CATEGORIES TABLE</h1>
        <table class="order">
            <tr>
                <th>CateID</th>
                <th>CateName</th>
            </tr>
            <tbody>
                <c:forEach var="cl" items="${sessionScope.Catelist}">
                    <tr>
                        <td>${cl.getCateId()}</td>
                        <td>${cl.getCateName()}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h1>UPDATE CATEGORIES</h1>
        <table class="order">
            <tr>
                <th>CateID</th>
                <th>CateName</th>
                <th>Action</th>
            </tr>
            <tbody>
                <c:forEach var="up" items="${requestScope.SID}">
                    <tr>
                <form action="mainController" method="post">
                    <td><input type="number" name="CateID" value="${up.getCateId()}" readonly=""></td>
                    <td><input type="text" name="CateName" value="${up.getCateName()}"></td>
                    <td><input type="submit" value="UpdateC" name="action"><br><input type="submit" value="DeleteC" name="action"></td>

                </form>
            </tr>
        </c:forEach>
    </tbody>
</table>
        <h1>ADD CATEGORIES</h1>
        <table class="order">
            <tr>
                <th>CateName</th>
                <th>Action</th>
            </tr>
            <tbody>
                <tr>
            <form action="mainController" method="POST">
                <td><input type="text" name="txtname"></td>
                <td><input type="submit" value="AddCate" name="action"></td>
            </form>
                </tr>
            </tbody>
        </table>
        <%}%>
</body>
</html>
