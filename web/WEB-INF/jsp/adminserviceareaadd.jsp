<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
        <title>Admin: Add Service Area</title>
        
    </head>
    <body>
        <input id="menuBtn" type="button"  onclick="window.location = 'adminserviceareas.htm'" value="Back To Admin: Service Area" >
        <form:form method="POST" action="${userActionUrl}" modelAttribute="svcAreaAddForm">
            <p>Add New Service Areas</p>
            <form:label path="name">Name:</form:label>
            <form:input path="name" type="text" name="name" value="" /><br>
            <form:label path="areaCode">Area Code:</form:label>
            <form:input path="areaCode" type="text" name="areaCode" value="" /><br>
            <form:label path="packageId">Package Id:</form:label>
            <form:input path="packageId" type="text" name="packageId" value="" /><br>
            <form:label path="taxRate">Tax Rate:</form:label>
            <form:input path="taxRate" type="text" name="taxRate" value="" /><br>
            <input type="submit" value="Confirm Addition">
        </form:form>
    </body>
</html>


