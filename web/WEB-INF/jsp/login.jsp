<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Home Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/mum.css" rel="stylesheet">
    </head>    
    <body> 
        <div>
          <div class="banner-img"></div>
            <nav>
                <ul>
                    <li><a href="#home">Home</a></li>
                    <li><a href="#menu">Menu</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li><a href="#about">About</a></li> 
                </ul>
            </nav>
           <br>
          </div>
        <div class='login'>
         <form:form method="POST" commandName="login"> 
          <table> 
            <tr> 
                <td>Username :</td> 
                <td><form:input path="loginId" /></td> 
            </tr>
            <tr>
                <td><form:errors path="loginId" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Password :</td> 
                <td><form:password path="password" /></td> 
            </tr>
            <tr>
                <td><form:errors path="password" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td colspan="4">
                <input type="submit"></td> 
            </tr> 
          </table> 
         </form:form>
        <h6><a href="Register.htm">Click here to register a new account.</a></h6>
        <h6><a href="ChangePassword.htm">Forgot password? Click to change password.</a></h6>
    </div>
  </body>
</html>
