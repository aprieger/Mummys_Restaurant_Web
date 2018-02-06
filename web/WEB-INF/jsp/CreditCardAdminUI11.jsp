<%-- 
    Document   : CreditCardAdmin11
    Created on : Jan 28, 2018, 3:25:23 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/mum.css" rel="stylesheet">
    </head>
    <body>
        <div class="banner-img"></div>
            <nav>
                <ul>
                    <li><a href="#home">Home</a></li>
                    <li><a href="#menu">Menu</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li><a href="#about">About</a></li> 
                </ul>
            </nav>
          </div>
        <a href="CreditCardAdminUI.htm">Back to Admin Credit Page</a>
        <table>
            <tr>
                <td>Credit ID</td>
                <td>Customer ID</td>
                <td>Card Number</td>
                <td>Brand</td>
            </tr>
            <c:forEach items="${listOfCards}" var="card">
                <tr>
                    <td><c:out value="${card.getCREDIT_ID()}" /></td>
                    <td><c:out value="${card.getCUSTOMER_ID()}" /></td>
                    <td><c:out value="${card.getCARD_NUMBER()}" /></td>
                    <td><c:out value="${card.getBRAND()}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>