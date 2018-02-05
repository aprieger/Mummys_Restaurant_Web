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
        <title>Admin: Add Package</title>
    </head>
    <body>
        <input id="menuBtn" type="button"  onclick="window.location = 'adminpackages.htm'" value="Back To Admin: Packages" >
        <form:form method="POST" action="${userActionUrl}" modelAttribute="pkgAddForm">
            <p>Add New Package</p>
            <form:label path="name">Name:</form:label>
            <form:input path="name" type="text" name="name" value="" /><br>
            <form:label path="description">Description: </form:label>
            <form:input path="description" type="text" name="description" value="" /><br>
            <form:label path="mealCategory">Meal Category</form:label>
            <form:select path="mealCategory">
                <form:options items="${catList}" />
            </form:select><br>
            <form:label path="imageSource">Image Source</form:label>
            <form:input path="imageSource" type="text" name="imageSource" value="" /><br>        
            <form:label path="price">Price</form:label>
            <form:input path="price" type="text" name="price" value="" /><br>  
            <form:label path="isSpecial">Is Special</form:label>
            <form:select path="isSpecial">
                <form:options items="${specList}" />
            </form:select><br>
            <form:label path="mealType">Meal Type</form:label>
            <form:select path="mealType">
                <form:options items="${typeList}" />
            </form:select><br> 
            <input type="submit" value="Confirm Addition">
        </form:form>
    </body>
</html>


