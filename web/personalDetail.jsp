<%-- 
    Document   : personalDetail
    Created on : Mar 11, 2023, 3:17:28 PM
    Author     : nanat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sample.dao.AccountDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSSS/personalDetail.css"/>
    </head>
    <body>
        <header>
            <%@include file="CSSHeader.jsp" %>
        </header>
        <c:set var="acc" value="${AccountDAO.getAccount2(email)}"/>
        <c:choose>
            <c:when test="${not empty acc}">
                <div class="">
                    <table class="acc">
                        <tr class="accinfo">             
                            <td class="balancetext"> <p>Account ID:</p> ${acc.getAccID()}</td>
                            <td class="balancetext"><p>Email:</p> ${acc.getEmail()}</td>
                            <td class="balancetext">
                                <p>Pass:</p> 
                                <input type="password" id="password" value="${acc.getPassword()}"/>
                                <button onclick="showPassword()">Show</button>
                            </td>                
                            <td class="balancetext"><p>Full name:</p> ${acc.getFullname()}</td>
                            <td class="balancetext"><p>Phone:</p> ${acc.getPhone()}</td>
                        </tr>
                    </table>                                
                </div>
            </c:when>
            <c:otherwise>
                <p class = "mess">you need login first </p> 
            </c:otherwise>
        </c:choose>
        <footer class="footer">
            <%@include file="CSSFooter.jsp" %> 
        </footer>
        <script>
            function showPassword() {
                var passwordInput = document.getElementById("password");
                if (passwordInput.type === "password") {
                    passwordInput.type = "text";
                } else {
                    passwordInput.type = "password";
                }
            }
        </script>
    </body>
</html>
