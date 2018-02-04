<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Registration</title>
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
        </div><br>
        <form:form method="POST" commandName="worker"> 
          <table class="workerInfo"> 
            <tr>
                <td><h3 style="text-align: center">Add new employee</h3>
                </td>
            </tr>
            <tr>
                <td>First Name : <form:errors path="firstName" cssClass="error" />
                <form:input path="firstName" class="stretch" value="${worker.firstName}" /></td> 
                
            </tr> 
            <tr> 
                <td>Last Name : <form:errors path="lastName" cssClass="error" />
                <form:input path="lastName" class="stretch" value="${worker.lastName}"/></td> 
                
            </tr> 
            <tr> 
                <td>Gender : <form:select path="gender" class="stretch" value="${worker.gender}" >
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                 </form:select></td>
            </tr>
            <tr> 
                <td>Phone number : <form:errors path="phoneNumber" cssClass="error" />
                <form:input path="phoneNumber" class="stretch" value="${worker.phoneNumber}"/></td> 
                
            </tr> 
            <tr> 
                <td>Is the employee an administrator?  No:0 Yes:1 :<form:input
                        type="number" min="0" max="1" path="isAdmin" class="stretch" value="${worker.isAdmin}"/></td>
            </tr> 
            <tr> 
                <td>Is the employee active?  No:0 Yes:1 :<form:input
                        type="number" min="0" max="1" path="isActive" class="stretch" value="${worker.isActive}"/></td>
            </tr> 
            <tr> 
                <td>
                    <input type="submit" class="cssButton" style="margin-left: 10px; margin-right: 90px">
                    <input type="submit" formaction="AdminWorkerMain.htm" class="cssButton" name="back" value="Back"></button></td>
            </tr> 
          </table> 
        </form:form>
    </body>
</html>

