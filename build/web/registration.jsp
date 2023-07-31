<%-- 
    Document   : registration
    Created on : Feb 22, 2023, 5:42:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSSS/register.css"/>
    </head>
    <body>
        <header>
            <%@include file="CSSHeader.jsp" %>
        </header>
        <section class="res">
            <form class="res_form" action="mainController" method="post" >
                <h1 class="res_h1">Register</h1>
                <table class="res_ta">
                    <tr><td class="res_td">Email</td><td><input class="res_ty_te" type="text" name="txtemail" required="" /></td></tr>
                    <tr><td class="res_td">Full name</td><td><input class="res_ty_te" type="text" name="txtfullname" required="" /></td></tr>
                    <tr><td class="res_td">Password</td><td><input class="res_ty_te" type="password" name="txtpassword" required="" /></td></tr>
                    <tr><td class="res_td">Phone</td><td><input class="res_ty_te" type="text" name="txtphone" required="" /></td></tr>
                    <tr><td class="res_td" colspan="2"><input class="res_ty_su" type="submit" value="create" name="action"/></td></tr>
                </table>       
            </form>
        </section>
        <footer class="footer">
            <%@include file="CSSFooter.jsp" %>
        </footer>
    </body>
</html>