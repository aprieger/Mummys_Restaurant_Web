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

        <title>Admin: Service Areas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            .title {
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

            tbody tr:hover.selected td,
            tbody tr:hover td {
              background-color: orangeyellow;
              cursor: pointer;
            }
        </style>
    </head>
    <body>
        <input id="menuBtn" type="button"  onclick="window.location = 'index.htm'" value="Back To Index" >
        <input id="addBtn" type="button"  onclick="window.location = 'adminserviceareaadd.htm'" value="Add New Service Area" >
        <table id="packageTable">
            <caption class="packagesTitle">Service Areas</caption>
            <thead>
                <tr>
                    <th>Area Id</th>
                    <th>Name</th>
                    <th>Area Code</th>
                    <th>Package Id</th>
                    <th>Tax Rate</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${adminServiceAreaList}" var="svc">
                    <tr>
                        <td>${svc.areaId}</td>
                        <td>${svc.name}</td>
                        <td>${svc.areaCode}</td>
                        <td>${svc.packageId}</td>
                        <td>${svc.taxRate}</td>
                        <td style="display: flex">
                            <a href="adminserviceareaedit.htm?areaId=${svc.areaId}"><button id="editButton">Edit</button></a>
                            <form:form method="POST" action="${userActionUrl}" modelAttribute="svcAreaDeleteForm">
                                <form:input path="areaId" type="hidden" name="areaId" value="${svc.areaId}" />
                                <input type="submit" value="Delete">
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>