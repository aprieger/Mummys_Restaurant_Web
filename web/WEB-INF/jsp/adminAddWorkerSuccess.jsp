<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Success</title>
        <link href="css/mum.css" rel="stylesheet">  
    </head>
    <body>
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
        <form:form >
            <div style="text-align: center">
        <h3>The employee ${worker.firstName} ${worker.lastName} has been added to the system!<br/></h3>
        <input type="submit"  formaction="AdminWorkerMain.htm" class="cssButton" name="back" value="Back to Admin Main">
            </div>
            </form:form>    
    </body>
</html>
