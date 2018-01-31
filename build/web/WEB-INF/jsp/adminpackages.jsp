<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

        <title>Admin: Packages</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            .menuTitle {
                text-align: center;
                font-family: Garmond;
            }
            table,tr,th,td{
                border: 1px solid black;
                padding: 5px;
            }

            table {
                border-collapse: collapse;
                width: 90%;
                margin: auto;
            }
            .packageImage{
                width: 10em;
            }

            tbody tr:hover.selected td,
            tbody tr:hover td {
              background-color: orangeyellow;
              cursor: pointer;
            }
        </style>
    </head>
    <body>
        <input id="menuBtn" type="button"  onclick="window.location = 'index.htm'" value="Back To Index" >
        <input id="addBtn" type="button"  onclick="window.location = 'adminpackageadd.htm'" value="Add New Package" >
        <table id="packageTable">
            <caption class="packagesTitle">Packages</caption>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Special</th>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${adminPackageList}" var="pack">
                    <tr>
                        <td>${pack.packageId}</td>
                        <td>${pack.name}</td>
                        <td>${pack.description}</td>
                        <td>${pack.mealCategory}</td>
                        <td>
                            <img width="120em" src=${pack.imageSource} alt=${pack.imageSource}></img>
                        </td>
                        <td>${pack.price}</td>
                        <td>${pack.isSpecial}</td>
                        <td>${pack.mealType}</td>
                        <td>
                            <a href="adminpackageedit.htm?packageId=${pack.packageId}"><button id="editButton">Edit</button></a>
                            <form:form method="POST" action="${userActionUrl}" modelAttribute="pkgDeleteForm">
                                <form:input path="packageId" type="hidden" name="packageId" value="${pack.packageId}" />
                                <input type="submit" value="Delete">
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>