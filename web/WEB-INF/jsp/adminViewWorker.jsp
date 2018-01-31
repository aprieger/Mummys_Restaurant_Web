<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search worker</title>
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
            <tr>
                <td><c:out value="${worker.getEmployeeId()}" /></td>
                <td><c:out value="${worker.getFirstName()}" /></td>
                <td><c:out value="${worker.getLastName()}" /></td>
                <td><c:out value="${worker.getLoginId()}" /></td>
                <td><c:out value="${worker.getGender()}" /></td>
                <td><c:out value="${worker.getActive()}" /></td>
                <td><c:out value="${worker.getAdmin()}" /></td>
            </tr> 
        </table>
        <!-- button to delete -->
    </body>
</html>
