<%-- 
    Document   : login
    Created on : Feb 22, 2023, 5:38:23 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS2/headers-css-master/styles/header-14.css "/>
        <link rel="stylesheet" href="CSS2/lg.css"/>
    </head>
    <body >
        <header>
            <%@include file="CSSHeader.jsp" %>
        </header>
<!--                <section >
                    <form action="mainController" method="post" class>
                        <h1>Login</h1>
                        <table>
                            <tr>
                                <td>Email</td>
                                <td><input type="text" name="txtemail" required=""/></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" name="txtpassword" required=""/></td>
                            </tr>
                            <tr><td colspan="2"><input type="submit" value="Login" name="action" /></td></tr>    
                        </table>         
                    </form> 
                </section>-->
        <div class="backg">
           <form class="formbruh" action="mainController" method="post">
            <font style='color:red;'><%= (request.getAttribute("WARNING") == null) ? "" : (String) request.getAttribute("WARNING")%> </font>
            <h2 style="font-weight: bold; font-size: 20px"> Login Information </h2>
            <input class="name" type="text" name="txtemail" required="" placeholder="Enter Username"/>
            <input class="pw" type="password" name="txtpassword" required="" placeholder="Enter Password"/>   
            <input class="inputbutton buttonbackg" type="submit" value="Login" name="action" />
            <br/>
             <tr><td colspan="2"><input type="checkbox" value="savelogin" name="savelogin"/>Stayed signed in</></td></tr> 
            <li class="liitem"><a href="registration.jsp"> Dont have account? <p  style="color: red">REGISTER !!</p></a></li>
        </form> 
        </div>
        

        <footer class="footer">
            <%@include file="CSSFooter.jsp" %>
        </footer>

    </body>

</html>

