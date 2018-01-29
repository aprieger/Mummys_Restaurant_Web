<%-- 
    Document   : CreditCardAdminUI2
    Created on : Jan 29, 2018, 9:51:01 AM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Credit Cards by Credit ID</title>           
    </form>
    </head>
    <body>
        <form:form method="POST" commandName="CreditCard"> 
            <table>
                <tr> 
                    <td><form:input path="CREDIT_ID"/></td>
                    <td><form:errors path="CREDIT_ID" cssClass="error" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td> 
                </tr> 
            </table> 
        </form:form>
    </body>
</html>