<%-- 
    Document   : CreditCardAdminUI1
    Created on : Jan 26, 2018, 2:53:08 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        <form:form method="POST" commandName="CreditCard" id="thisButon" name="thisButon"> 
            <table>
                <tr> 
                    <td colspan="2"><input type="submit"></td> 
                </tr> 
            </table> 
        </form:form>
          <script>document.thisButon.submit();</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Credit Card Table</title>
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
        
    </body>
</html>

