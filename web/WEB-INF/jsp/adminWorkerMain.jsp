<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration: Worker Records</title>
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
        <h1>Administration Worker Main Page</h1>
        <table> 
            <tr> 
                <td><a href="AdminEditSaveWorker.htm">Add an employee</a></td> 
            </tr>
            <tr> 
                <td><a href="AdminDeleteWorker.htm">Delete an employee</a></td> 
            </tr>
            <tr> 
                <td><a href="AdminEditSaveWorker.htm">Update an employee</a></td>
            </tr>
            <tr> 
                <td><a href="AdminViewWorker.htm">View an employee</a></td>
            </tr>
    </body>
</html>
