<%-- 
    Document   : ManageAccounts
    Created on : Feb 26, 2023, 11:50:40 AM
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
            String name = (String) session.getAttribute("name");
            if (name == null) {
        %>
        <p><font color="red"> You must be an admin to access the site</font> </p>
        <p></p>
        <%} else {
        %>
        <header>
            <c:import url="header_loginedAdmin.jsp"/>
        </header>

        <form action="mainController" method="POST">
            <input type="text" name="txtSearch">
            <input type="submit" value="searchAccount" name="action">
        </form>

        <h1></h1>
        <table class="order">
            <c:if test="${requestScope.accountList == null} ">
                <h3><c:out value="${requestScope.ERROR}" default=""/></h3>
            </c:if>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Full name</th>
                <th>Status</th>
                <th>Phone</th>
                <th>Role</th>
                <th>Action</th>
            </tr>

            <c:forEach var="acc" items="${requestScope.accountList}">

                <tr>
                    <td>${acc.getAccID()}</td>
                    <td>${acc.getEmail()}</td>
                    <td>${acc.getFullname()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${acc.getStatus() eq 1}">active</c:when>
                            <c:otherwise>inActive</c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${acc.getPhone()}"></c:out></td>
                        <td>
                        <c:choose>
                            <c:when test="${acc.getRole() eq 1}">admin</c:when>
                            <c:otherwise>user</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${acc.getRole() eq 0}">
                            <c:url var="mylink" value="mainController">
                                <c:param name="email" value="${acc.getEmail()}"></c:param>
                                <c:param name="status" value="${acc.getStatus()}"></c:param>
                                <c:param name="action" value="updateStatusAccount"></c:param>
                            </c:url>
                            <a href="${mylink}">Block/UnBlock</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <%}%>
    </body>
</html>
