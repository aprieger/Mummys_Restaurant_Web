<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="react.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js"></script>
        <link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />
        <script src="https://code.jquery.com/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Edit Service Area</title>
        
    </head>
    <body>
        <input id="menuBtn" type="button"  onclick="window.location = 'adminserviceareas.htm'" value="Back To Admin: Service Areas" >
        <form:form method="POST" action="${userActionUrl}" modelAttribute="svcAreaEditForm">
            <p>Editing AreaID: ${adminServiceAreaDetails.areaId}</p>
            <form:label path="name">Name:</form:label>
            <form:input path="name" type="text" name="name" value="${adminServiceAreaDetails.name}" /><br>
            <form:label path="areaCode">Area Code: </form:label>
            <form:input path="areaCode" type="text" name="areaCode" value="${adminServiceAreaDetails.areaCode}" /><br>
            <form:label path="packageId">Package Id: </form:label>
            <form:input path="packageId" type="text" name="packageId" value="${adminServiceAreaDetails.packageId}" /><br>
            <form:label path="taxRate">Tax Rate: </form:label>
            <form:input path="taxRate" type="text" name="taxRate" value="${adminServiceAreaDetails.taxRate}" /><br>        
         
            <input type="submit" value="Confirm Changes">
        </form:form>
    </body>
</html>


