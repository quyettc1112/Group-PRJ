<%-- 
    Document   : searchPlant
    Created on : Feb 19, 2023, 5:54:14 PM
    Author     : Admin
--%>

<%@page import="sample.dto.Plant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link  rel="stylesheet" href="CSSS/mycss.css" type="text/css" />
    </head>
    <body>
        <h1>Code co loi ko</h1>
        <c:if test="${requestScope.listPlan == null}">
            <h3><c:out value="${requestScope.ERROR}" default=""/></h3>
        </c:if>

        <section>
            <c:set var="kq" value="${sessionScope.listPlan}" />
            <c:if test="${kq != null}">
                <%
                    ServletContext context = getServletContext();
                    String tmp =  context.getInitParameter("countryName");
                    out.print("<p>The website is deploying in " + tmp + "</p>");
                    
//                    ServletConfig servletconfig = getServletConfig();
//                    String tmp2 = servletconfig.getInitParameter("lang");
//                    out.print("<p>Language is used only in this page: "+ tmp2 +"</p>");              
                %>              
                <c:set var="tmp2" value="${sessionScope.tmp2}" ></c:set>               
                <p>Language is used only in this page: ${tmp2}</p>
            <h1>Thong tin</h1>
           `     <table>               
                    <tr>
                        <td>Product ID</td>
                        <td>Name</td>
                        <td>Price</td>
                        <td>Image</td>
                        <td>Detail</td>
                        <td>Action</td>           
                    </tr>
                    <c:forEach items="${kq}" var="it"> 
                        <tr>
                            <td>${it.getId()}</td> 
                            <td>${it.getName()}</td> 
                            <td>${it.getPrice()}</td> 
                            <td class="logoo"><img src='${it.getImgpath()}' /></td>
                            <td><a href='#'>view detail</a></td>
                            <td><a href='#'>add to your cart</a></td>        
                        </tr>
                    </c:forEach>
                </c:if>
            </table>         
        </section>
    </body>
</html>
