<%-- 
    Document   : CreditCardAdminUI
    Created on : Jan 25, 2018, 2:34:35 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%
    session.getAttribute("Customer_Id"); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CreditCardUserUI</title>
    </head>
    <body>
        <a href="index.htm">Back to index</a>
        <h1>Credit Card User UI</h1>
        <h1>Hi,${Customer_name}</h1>
   
        <table>
            <tr>
                <td><p><a href="CreditCardUserUI1.htm">1. Add a new card </a></p></td>
            </tr>
            <tr>
                <td><p><a href="">2. Pick an existing card (ENTER THE CREDIT ID)</a></p></td>
            </tr>
            <tr>
                <td><p><a href="">3. Delete an existing card(ENTER THE CREDIT ID)</a></p></td>
            </tr>
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
    </body>
</html>