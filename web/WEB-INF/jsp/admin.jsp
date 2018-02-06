<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration Page</title>
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
        <div class="workerTables">
         <form:form method="POST" commandName="worker">
            <table><br>
                <tr><h3>Administration Main Page</h3></tr>   
            <tr><td><input type="submit" class="cssButton" name="first" value="Access employee records"></td> 
                <td> <input type="submit" class="cssButton" name="second" value="Access customer records" ></td></tr> 
            <tr><td> <input type="submit" class="cssButton" name="third" value="Access credit card records"></td>
            <td> <input type="submit" class="cssButton" name="fourth" value="Access product records"></td></tr>
            <tr><td> <input type="submit" class="cssButton" name="fifth" value="Access product records"></td>
            <td><input type="submit" class="cssButton" name="back" value="Back"></td></tr>
          </table>
         </form:form>
        </div>
    </body>
</html>

