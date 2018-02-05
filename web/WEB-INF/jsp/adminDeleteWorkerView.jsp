<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Workers</title>
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
        </div><br>
        <table>
            <tr>
                <td>Employee ID</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Gender</td>
                <td>Login ID</td>
                <td>Email</td>
                <td>Active</td>
                <td>Admin</td>
            </tr>
            <c:forEach items="${listOfWorkers}" var="worker">
                <tr>
                    <td><c:out value="${worker.getEmployeeId()}" /></td>
                    <td><c:out value="${worker.getFirstName()}" /></td>
                    <td><c:out value="${worker.getLastName()}" /></td>
                    <td><c:out value="${worker.getGender()}" /></td>
                    <td><c:out value="${worker.getLoginId()}" /></td>
                    <td><c:out value="${worker.getEmail()}" /></td>
                    <td><c:out value="${worker.getIsActive()}" /></td>
                    <td><c:out value="${worker.getIsAdmin()}" /></td>
                </tr> 
            </c:forEach>
                <form:form commandName="worker">
                    <input type="submit" class="cssButton" name="delete" value="Delete employee">
                    <input type="submit" formaction="adminWorkerMain.htm" class="cssButton" name="back" value="Back to Admin Main">
                </form:form>
          </table>
    </body>
</html>
