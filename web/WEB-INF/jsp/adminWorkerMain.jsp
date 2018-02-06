<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration: Worker Records</title>
        <link href="css/mum.css" rel="stylesheet"> 
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        
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
                <tr><h3>Administration Worker Main Page</h3></tr>   
            <tr><td><input type="submit" class="cssButton" name="first" value="Add an employee"></td> 
                <td><input type="submit" class="cssButton" name="third" value="Update an employee"></td></tr>
            <tr><td><input type="submit" class="cssButton" name="fourth" value="View an employee"></td>
                <td><input type="submit" class="cssButton" name="back" value="Back to Admin Main"></td></tr>
          </table>
         </form:form>
        </div>
    </body>
</html>
