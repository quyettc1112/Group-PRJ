<%-- 
    Document   : changeProfile
    Created on : Feb 26, 2023, 10:41:42 PM
    Author     : Admin
--%>

<%@page import="sample.dao.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header_loginedUser.jsp" %>          
        </header>
        <section>
           
            <% 
               String email = (String) session.getAttribute("email");
            %>
          
 
            <form action="mainController" method="post">
                <input  type="text" name="txtfullname" required="" placeholder="Enter new Fullname"/> 
                <input  type="text" name="txtphone" required="" placeholder="Enter new Phone"/>
                <input type="hidden" name="txtemail" value="<%=  email  %>" />
                <input type="submit" name="action" value="change">
            </form>
            


        </section>
        <footer class="footer">
            <%@include file="CSSFooter.jsp" %> 
        </footer>
    </body>
</html>
