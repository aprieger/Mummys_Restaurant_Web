<%-- 
    Document   : CreditCardAdminUI
    Created on : Jan 25, 2018, 2:34:35 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CreditCardAdminUI</title>
    </head>
    <body>
        <h1>Credit Card Admin UI</h1>
        <form:form method="POST" commandName="CreditCard"> 
        <table> 
            <tr> 
                <td>User Name :</td> 
                <td><form:input path="username" /></td> 
                <td><form:errors path="username" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Password :</td> 
                <td><form:password path="password" /></td> 
                <td><form:errors path="password" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td colspan="2">
                <input type="submit"></td> 
            </tr> 
        </table> 
        </form:form>
    </body>
</html>
