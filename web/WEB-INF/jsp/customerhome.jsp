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

        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            .title {
                text-align: center;
                font-family: Century Gothic;
                font-weight: bold;
                color: greenyellow;
                background-color: green;
                font-size: 2em;
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
            .button {
                font-family: Century Gothic;
                font-size: 1.1em;
                margin: 1em;
                background-color: green;
                color:white;
            }
            .button:hover {
                background-color: greenyellow;
            }
            #buttons {
                display: flex;
                align-items: center;
                justify-content: center;
            }
        </style>
    </head>
    <body>
        <div class="banner-img"></div>
        <nav>
            <ul>
                <li><a href="customerhome.htm">Home</a></li>
                <li><a href="menu.htm">Menu</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="#about">About</a></li> 
            </ul>
        </nav>
        <div id="buttons">
            <input class="button" type="button"  onclick="window.location = 'menu.htm'" value="Go to Menu" >
            <input class="button" type="button"  onclick="window.location = 'viewOrders.htm'" value="View Orders" >
            <input class="button" type="button"  onclick="window.location = 'login.htm'" value="Logout" >
        </div>
    </body>
</html>