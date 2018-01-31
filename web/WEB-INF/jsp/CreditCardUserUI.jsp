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
            <form:form method="POST" commandName="CreditCard">
                <tr> 
                    <td><form:input path="CREDIT_ID"/></td>
                    <td><form:errors path="CREDIT_ID" cssClass="error" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td> 
                </tr>
            </form:form>
        </table>
    </body>
</html>

<form:form method="POST" commandName="CreditCard">
    <tr> 
        <td><form:input path="CREDIT_ID"/></td>
        <td><form:errors path="CREDIT_ID" cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit"></td> 
    </tr>
</form:form>