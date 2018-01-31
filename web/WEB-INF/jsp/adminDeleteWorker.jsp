<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Worker</title>
        <link href="css/mum.css" rel="stylesheet"> 
    </head>
    <body>
        <div>
          <div className="banner-img"></div>
            <nav>
                <ul>
                    <li><a href="#home">Home</a></li>
                    <li><a href="#menu">Menu</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li><a href="#about">About</a></li> 
                </ul>
            </nav>
          </div>
        <h3>Enter the employee id of the worker to be deleted</h3>
        <form:form method="POST" commandName="worker"> 
          <table> 
            <tr> 
                <td>Employee ID :</td> 
                <td><form:input path="firstName" /></td> 
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr> 
          </table>
        </form:form>   
    </body>
</html>
