<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get worker</title>
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
          </div>
        <h3>Enter the employee id of the worker</h3>
        <form:form method="POST" commandName="worker"> 
          <table class="workerTables"> 
            <tr> 
                <td>Employee ID: <form:input type="number" path="employeeId" /></td> 
            </tr> 
            <tr> 
                <td>
                <input type="submit" class="cssButton">
                <input type="submit" formaction="adminWorkerMain.htm" class="cssButton" name="back" value="Back to Admin Main"></td>
            </tr> 
          </table>
        </form:form>   
    </body>
</html>
