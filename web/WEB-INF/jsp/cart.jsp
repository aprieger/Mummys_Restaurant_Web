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

        <title>Cart</title>
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
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #006400;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #ADFF2F;
                color: #006400;

            }
            li a:active {
                background-color: #ADFF2F;
                color: #006400;
            }
            .banner-img{
                /* The image used */
                background-image: url('images/buffet.png');

               /*  Set a specific height */
                height: 100px;

                /* Position and center the image to scale nicely on all screens */
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                position: relative;
            }

            tbody tr:hover.selected td,
            tbody tr:hover td {
              background-color: orangered;
              cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div class="banner-img"></div>
        <nav>
            <ul>
                <li><a href="#home">Home</a></li>
                <li><a href="menu.htm">Menu</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="#about">About</a></li> 
            </ul>
        </nav><br>
        <input id="menuBtn" type="button"  onclick="window.location = 'menu.htm'" value="Back To Menu" >
        <table id="packageTable">
            <caption class="menuTitle">Cart</caption>
            <thead>
                <tr>
                    <th>Package Order Id:</th>
                    <th>Package Id:</th>
                    <th>Package Name:</th>
                    <th>Price Per Package:</th>
                    <th>Quantity:</th>
                    <th>Image:</th>
                    <th>Meal Category:</th>
                    <th>Special?</th>
                    <th>Meal Type:</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cartPkgList}" var="pack">
                    <tr>
                        <td>${pack.oPkgOrderId}</td>
                        <td>${pack.pPackageId}</td>
                        <td>${pack.pName}</td>
                        <td>${pack.oPricePerPkg}</td>
                        <td>${pack.oQuantity}</td>
                        <td>${pack.pImageSource}</td>
                        <td>${pack.pMealCategory}</td>
                        <td>${pack.pIsSpecial}</td>
                        <td>${pack.pMealType}</td>
                        <td>
                            <form:form method="POST" action="${userActionUrl}" modelAttribute="pkgForm">
                                <form:input path="pkgOrderId" type="hidden" name="pkgOrderId" value="${pack.oPkgOrderId}" />
                                <input type="submit" value="Delete">
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>


