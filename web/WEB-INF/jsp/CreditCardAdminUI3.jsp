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
        <link href="css/mum.css" rel="stylesheet">
    </form>
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
          <p>Enter Credit ID</p>
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