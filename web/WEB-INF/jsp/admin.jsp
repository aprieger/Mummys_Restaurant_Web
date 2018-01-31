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
        <h3>Welcome ${worker.firstName}, you are logged into the system !</h3>
        <table> 
            <tr> 
                <td><a href="AdminWorkerMain.htm">Access employee records</a></td> 
            </tr>
            <tr> 
                <td><a href="Register.htm">Access customer records</a></td> 
            </tr>
            <tr> 
                <td><a href="Register.htm">Access customer credit cards</a></td> 
            </tr>
            <tr> 
                <td><a href="Register.htm">Access product records</a></td> 
            </tr>
            <tr> 
                <td><a href="Register.htm">Access order records</a></td> 
            </tr>
        </table>   
        <p>
    </body>
</html>

