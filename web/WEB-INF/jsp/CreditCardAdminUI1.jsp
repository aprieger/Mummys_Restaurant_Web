<%-- 
    Document   : CreditCardAdminUI1
    Created on : Jan 26, 2018, 2:53:08 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Credit Card Table</title>
    </head>
    <body>
        <h1>Admin View Credit Card Table </h1>
        <p>user name = ${CreditCard.CREDIT_ID}</p>
        <p>password = ${CreditCard.password}</p>
    </body>
</html>

CreditCard{CREDIT_ID= 1, 
CUSTOMER_ID= 1, CARD_NUMBER= 12345, BRAND= VISA, SECURITY_NUMBER= 999, 
EXPERATION_DATE= 2020-12-12 00:00:00.0, NAME_ON_CARD= ben, STREET= happylane, CITY= phoenix, AREA_CODE= 555}