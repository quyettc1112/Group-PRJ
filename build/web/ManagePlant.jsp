<%-- 
    Document   : ManagePlant
    Created on : Feb 26, 2023, 3:38:29 PM
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
            <input type="hidden" name="page" value="ManagerPlant">
            <input type="text" name="txtsearch">
            <select name= "searchby" >
                <option value="by name">by name</option>
                <option value="by category">by category</option>
            </select>
            <input type="submit" value="searchPlant"  name="action" >
        </form>
        <c:if test="${requestScope.listPlan == null}">
            <h3><c:out value="${requestScope.ERROR}" default=""/></h3>
        </c:if>

        <table class="order" >
            <h1>PLANT TABLE</h1>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Image</th>
                <th>Description</th>
                <th>Status</th>
                <th>CateID</th>
                <th>CateName</th>
            </tr>
            <tbody>

                <c:forEach var="Pla" items="${sessionScope.plantList}">
                    <tr>
                        <td>${Pla.getId()}</td>
                        <td>${Pla.getName()}</td>
                        <td>${Pla.getPrice()}</td>
                        <td class="logoo"><img src='${Pla.getImgpath()}' /></td>
                        <td>${Pla.getDescription()}</td>
                        <td>
                            <c:choose>
                                <c:when test="${Pla.getStatus() eq 1}">Con hang</c:when>
                                <c:otherwise>het hang</c:otherwise>
                            </c:choose>
                        </td>
                        <td>${Pla.getCateid()}</td>
                        <td>${Pla.getCatename()}</td>

                    </tr>
                </c:forEach>
            </tbody>

        </table>
        <h1>UPDATE TABLE</h1>
        <table class="order" style="border: black solid 1px">
            <tr>

                <th>Product ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Image</th>
                <th>Description</th>
                <th>Status</th>
                <th>CateID</th>
                <th>CateName</th>
                <th>Action</th>
            </tr>
            <tbody>

                <c:forEach var="sp" items="${requestScope.listPlan}">
                    <tr>
                <form action="mainController" method="post">
                    <td><p><input type="number" name="id" value="${sp.getId()}" readonly=""/></p></td>
                    <td><p><input type="text" name="txtname" value="${sp.getName()}"/></p></td>
                    <td><p><input type="number" name="price" value="${sp.getPrice()}" min="0"/></p></td>
                    <td class="logoo"><p><input type="text" name="img" value="${sp.getImgpath()}"/><img src='${sp.getImgpath()}' /></p></td>
                    <td><p><input type="text" name="txtdescription" value="${sp.getDescription()}"/></p></td>
                    <td><p><input type="number" name="status" value="${sp.getStatus()}" min="0" max="1"/></p></td>
                    <td><p><input type="number" name="cateid" value="${sp.getCateid()}"/></p></td>
                    <td><p><input type="text" name="catename" value="${sp.getCatename()}"/></p></td>
                    <td><input type="submit" value="Update" name="action"><br><input type="submit" value="Delete" name="action"></td>
                </form>    
            </tr>

        </c:forEach>
    </tbody>
</table>
<h1>ADD PLANT</h1>
<table class="order" style="border: black solid 2px">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Image</th>
        <th>Description</th>
        <th>Status</th>
        <th>CateID</th>
        <th>Action</th>
    </tr>
    <tbody>
        <tr>
    <form action="mainController" method="post">
        <td><input type="text" name="txtname"></td>
        <td><input type="number" name="price" min="1"></td>
        <td><input type="text" name="img"></td>
        <td><input type="text" name="description"></td>
        <td><input type="number" name="status" min="0" max="1"></td>
        <td><input type="number" name="cateid" min="0"></td>
        <td><input type="submit" value="Create" name="action"></td>
    </form>
</tr>
</tbody>
</table>
</form>
<%}%>
</body>
</html>
