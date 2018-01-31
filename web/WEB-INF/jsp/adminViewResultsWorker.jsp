<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Workers</title>
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
        </div><br>
        <table>
            <tr>
                <td>Employee ID</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Login ID</td>
                <td>Gender</td>
                <td>Active</td>
                <td>Admin</td>
            </tr>
            <c:forEach items="${listOfWorkers}" var="worker">
                <tr>
                    <td><c:out value="${worker.getEmployeeId()}" /></td>
                    <td><c:out value="${worker.getEmployeeId()}" /></td>
                    <td><c:out value="${worker.getEmployeeId()}" /></td>
                    <td><c:out value="${worker.getEmployeeId()}" /></td>
                    <td><c:out value="${worker.getEmployeeId()}" /></td>
                    <td><c:out value="${worker.getEmployeeId()}" /></td>
                    <td><c:out value="${worker.getEmployeeId()}" /></td>
                    </td>
                </tr> 
            </c:forEach>
        </table>
    </body>
</html>
