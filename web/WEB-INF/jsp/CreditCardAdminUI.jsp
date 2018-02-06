<%-- 
    Document   : CreditCardAdminUI
    Created on : Jan 25, 2018, 2:34:35 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%
String name = "session value";
session.setAttribute("Sname", name);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CreditCardAdminUI</title>
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
          <a href=""><h2>Edit this link to go to Admin main page</h2></a>
        <h1>Credit Card Admin UI</h1>
        <table>
            <tr>
                <td><p><a href="CreditCardAdminUI1.htm">1. View all cards</a></p></td>
            </tr>
            <tr>
                <td><p><a href="CreditCardAdminUI2.htm">2. Get Card by User ID</a></p></td>
            </tr>
            <tr>
                <td><p><a href="CreditCardAdminUI3.htm">3. Get Card by Credit ID</a></p></td>
            </tr>
            <tr>
                <td><p><a href="CreditCardAdminUI4.htm">4. Delete Card by Credit ID</a></p></td>
            </tr>
            <tr>
                <td><p><a href="CreditCardAdminUI5.htm">5. Delete Card by Customer ID</a></p></td>
            </tr>
            
        </table>
    </body>
</html>




<!--


-->