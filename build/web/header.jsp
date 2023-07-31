<%-- 
    Document   : header
    Created on : Feb 22, 2023, 5:31:32 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link  rel="stylesheet" href="CSSS/mycss.css" type="text/css" />
        <link rel="stylesheet" href="styles/reset.min.css" />
        <link rel="stylesheet" href="styles/style.css" />
        <link rel="stylesheet" href="styles/header-14.css" />
    </head>
    <body>
        <header>

            
                <div>  
                    <ul>
                        <li><a href="index.jsp"><img src="images/logo.jpg"></a> </li>
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="registration.jsp">Register</a></li>
                        <li><a href="login.jsp" >Login</a></li>
                        <li>
                            <form action="mainController" method="post" class="">
                                <input type="hidden" name="page" value="searchPlant">
                                <input type="text" name="txtsearch" value="<%= (request.getParameter("txtsearch") == null) ? "" : request.getParameter("txtsearch")%>">
                                <select name= "searchby" >
                                    <option value="by name">by name</option>
                                    <option value="by category">by category</option>
                                </select>
                                <!--                         <input type="text" name="searchby" />-->
                                <input type="submit" value="search"  name="action" >
                            </form>
                        </li>
                    </ul> 
                </div>
            
        </header>    
    </body>
</html>
