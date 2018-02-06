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
           <br>
          </div>
        <form:form method="POST" commandName="worker"> 
          <table> 
            <tr> 
                <td>First Name :</td> 
                <td><form:input path="firstName" /></td> 
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Last Name :</td> 
                <td><form:input path="lastName" /></td> 
                <td><form:errors path="lastName" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Gender :</td> 
                <td><form:select path="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
                 </form:select></td>
            </tr> 
            <tr> 
                <td>Phone number :</td> 
                <td><form:input path="phoneNumber" /></td> 
                <td><form:errors path="phoneNumber" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Is the employee an administrator? 0/No 1/Yes :</td> 
                <td><form:input type="number" min="0" max="1" path="isAdmin" /></td>
            </tr> 
            <tr> 
                <td>Is the employee active? 0/No 1/Yes :</td> 
                <td><form:input type="number" min="0" max="1" path="isActive" /></td>
            </tr> 
            <tr> 
                <td colspan="2">
                <input type="submit"></td> 
            </tr> 
          </table> 
        </form:form>
    </body>
</html>
