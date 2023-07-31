<%-- 
    Document   : index
    Created on : Feb 22, 2023, 5:35:22 PM
    Author     : Admin
--%>

<%@page import="sample.dto.Account"%>
<%@page import="sample.dao.AccountDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.dto.Plant"%>
<%@page import="sample.dao.PlanDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="CSS2/headers-css-master/styles/header-14.css" />
        <link rel="stylesheet" href="CSS2/css/bootstrap.css"/>
        <link rel="stylesheet" href="CSS2/css/bootstrap.min.css"/>
    </head>
    <body>
        <header>
            <%@include file="CSSHeader.jsp" %>
        </header>
        <p class="flower">Flowers Product

        </p>

        <div class="row ">   
            <%
                String keyword = request.getParameter("txtsearch");
                String searchby = request.getParameter("searchby");
                String emailtokken = (String) request.getAttribute("emailToken");
                ArrayList<Plant> list;
                String[] tmp = {"out of stock", "availble"};
                if (keyword == null && searchby == null) {
                    list = PlanDAO.getPlants("", "");
                } else {
                    list = PlanDAO.getPlants(keyword, searchby);
                }

                if (list != null && !list.isEmpty()) {
                    for (Plant p : list) {%>
            <div class="col-md-4 balanceDIV">
                <table class="product">
                    <tr class="plantProduct">
                        <td><img src='<%= p.getImgpath()%>' class="plantimg" /></td>             
                        <td class="balancetext"> <p>Product ID:</p> <%=  p.getId()%></td>
                        <td class="balancetext"><p>Product Name:</p> <%=  p.getName()%></td>
                        <td class="balancetext"><p>Price:</p> <%=  p.getPrice()%></td>
                        <td  class="balancetext"><p>Status:</p> <%=  p.getStatus()%></td><!-- comment -->
                        <td class="balancetext"><p>Category:</p> <%=  p.getCatename()%></td>
                        <td class="balancetext"> <a href="mainController?action=addtocart&pid=<%= p.getId() %>  " />ADD TO CART  </td>
                    </tr>

                </table>  
            </div>

            <%
                }
            } else {%>

            <h1>Have no item name like: "<%=  keyword%>" by "<%= searchby%>" on the stocks</h1>
            <h1> <a style="font-weight: bold; color: black; font-size: 15px" href="index.jsp" >Click here  to back</a></h1>

            <%
                }
            %> 
            
                    </div>

        <footer class="footer">
            <%@include file="CSSFooter.jsp" %> 
        </footer>

        

    </body>
</html>
