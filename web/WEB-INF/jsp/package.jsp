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
        <title>Package</title>
        
        <link href="css/CustomerPackageUI.css" rel="stylesheet" type="text/css" />
        <style>
            #nameAndPrice {
                border-style: solid;
                border-width: 2px;
                display: flex;
                width: 90%;
                margin: auto;
                margin-bottom: 3em;
            }
            #name {
                font-size: 4em;
                font-family: Century Gothic;
                padding: .2em;
                padding-left:.4em;
                margin-right: auto;
            }
            #price {
                font-size: 4em;
                font-family: Century Gothic;
                padding: .2em;
                padding-right:.4em;
            }

            #infoAndImage{
                display: flex;
                justify-content: center;
                width: 90%;
                margin: auto;
            }
            #formBox{
                display: flex;
                justify-content: center;
                width: 90%;
                margin: auto;
            }
            #info {
                border-style: solid;
                border-width: 2px;
                width:40em;
                margin-right: auto;
            }
            #description {
                font-size: 2em;
                font-family: Century Gothic;
                padding: .2em;
                padding-left:.4em;
            }
            #category {
                font-size: 2em;
                font-family: Century Gothic;
                padding: .2em;
                padding-left:.4em;
            }
            #special {
                font-size: 2em;
                font-family: Century Gothic;
                padding: .2em;
                padding-left:.4em;
            }
            #type {
                font-size: 2em;
                font-family: Century Gothic;
                padding: .2em;
                padding-left:.4em;
            }
            #areas {
                font-size: 2em;
                font-family: Century Gothic;
                padding-top: .2em;
                padding-left:.4em;
            }
            #area {
                font-size: 2em;
                font-family: Century Gothic;
                padding-left:1.2em;
            }
            #image {
                width:40em;
                text-align: center;
            }
            #packImg {
                width: 40em;
                margin-left: auto;
                margin-right: auto;
            }
            #menuBtn {
                margin: 1em;
                margin-left: 6em;
                padding:.5em;
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
            .error {
                color: red; font-weight: bold;
            }
        </style>
        <script type="text/javascript">
        $(document).ready(function() {
            $("#formPkg").validate({
                messages: {
                    quantity: "Please enter a quantity",
                },
                rules: {
                  quantity: "required",
                },
            },
          });
        });
      </script>
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
        <p id="packID">ID: ${packageItemDetails.packageId}</p>
        <input id="menuBtn" type="button"  onclick="window.location = 'menu.htm'" value="Back To Menu" >
        <div id="formBox">
            <form:form id="formPkg" method="POST" action="${userActionUrl}" modelAttribute="formPkgOrder">
                <form:input path="packageIdKey" type="hidden" name="packageIdKey" value="${packageItemDetails.packageId}" />
                <form:label path="quantity">Quantity:</form:label>
                <form:input path="quantity" type="text" name="quantity" value="1" />
                <form:errors path="quantity" cssClass="error"/>
                <input type="submit" value="Add To Cart">
            </form:form>
        </div>
        <div id="nameAndPrice">
            <div id="name">${packageItemDetails.name}</div>
            <div id="price">$${packageItemDetails.price}</div>
        </div>
        <div id="infoAndImage">
            <div id="info">
                <p id="description">${packageItemDetails.description}</p>
                <p id="category"><u>Category :</u> ${packageItemDetails.mealCategory}</p>
                <p id="special"><u>Special:</u> ${packageItemDetails.isSpecial}</p>
                <p id="type"><u>Type:</u> ${packageItemDetails.mealType}</p>
                <p id="areas"><u>Service Areas:</u></p>
                <c:forEach items="${serviceAreaList}" var="svc">
                    <p id="area">${svc.name}</p>
                </c:forEach>
            </div>
            <div id="image">
                <img id="packImg" src="images/${packageItemDetails.imageSource}" alt="${packageItemDetails.imageSource}"/>
            </div>
        </div>
    </body>
</html>


