<%-- 
    Document   : CreditCardAdminUI
    Created on : Jan 25, 2018, 2:34:35 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%
    session.getAttribute("Sname"); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CreditCardUserUI</title>
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
        <a href="index.htm">Back to index</a>
        <h1>Credit Card User UI</h1>
        <h1>${Sname}</h1>
        
        <p>${card}</p>
        <p>${card.CREDIT_ID}</p>
        <p>${card.CUSTOMER_ID}</p>
        <p>${card.CARD_NUMBER}</p>
        <p>${card.BRAND}</p>
        <p>${card.SECURITY_NUMBER}</p>
        <p>${card.NAME_ON_CARD}</p>
        <p>${card.CREDIT_ID}</p>
        
        
        <table>
            <tr>
                <td><p><a href="CreditCardUserUI1.htm">1. Add a new card </a></p></td>
            </tr>
            <tr>
                <td><p><a href="CreditCardUserUI2.htm">2. Pick an existing card</a></p></td>
            </tr>
            <tr>
                <td><p><a href="">3. Delete an existing card</a></p></td>
            </tr>
        </table>
    </body>
</html>