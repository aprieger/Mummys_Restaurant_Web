<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search worker</title>
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
                <tr><td><h3>Employee search</h3></td></tr>
                <tr><td>Enter employee id:</td></tr>
                    <td><form:input type="number" path="employeeId"/></td></tr>
                <tr><td><input type="submit" class="cssButton" name="first" value="Search by employee id"></td></tr>
                <tr><td><h3>OR</h3></td></tr>
                <tr><td> <input type="submit" class="cssButton"  name="second" value="Search all records"></td></tr> 
            </table>
          </form:form>
        </div>
    </body>
</html>
