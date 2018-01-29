<%-- 
    Document   : CreditCardAdminUI2
    Created on : Jan 29, 2018, 9:51:01 AM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Card</title>           
    </form>
    </head>
    <body>
        <form:form method="POST" commandName="CreditCard"> 
            <table>
                <tr> 
                    <td>Card Number</td>
                    <td><form:input path="CARD_NUMBER"/></td>
                    <td><form:errors path="CARD_NUMBER" cssClass="error" /></td>
                </tr>
                <tr> 
                    <td>Security code</td>
                    <td><form:input path="SECURITY_NUMBER"/></td>
                    <td><form:errors path="SECURITY_NUMBER" cssClass="error" /></td>
                </tr>
                <tr> 
                    <td>Brand</td>
                    <td>
                        <form:select path="BRAND">
                            <option value ="Visa">Visa</option>
                            <option value ="Mastercard">Mastercard</option>
                            <option value ="Discover">Discover</option>
                        </form:select>
                    </td>
                    <td><form:errors path="BRAND" cssClass="error" /></td>
                </tr>
                <tr> 
                    <td>expiration Date</td>
                    <td><form:input type="date" path="EXPERATION_DATE"/></td>
                    <td><form:errors path="EXPERATION_DATE" cssClass="error" /></td>
                </tr>
                <tr> 
                    <td>Name</td>
                    <td><form:input path="NAME_ON_CARD"/></td>
                    <td><form:errors path="NAME_ON_CARD" cssClass="error" /></td>
                </tr>
                <tr> 
                    <td>Address</td>
                    <td><form:input path="STREET"/></td>
                    <td><form:errors path="STREET" cssClass="error" /></td>
                </tr>
                <tr> 
                    <td>City</td>
                    <td><form:input path="CITY"/></td>
                    <td><form:errors path="CITY" cssClass="error" /></td>
                </tr>
                <tr> 
                    <td>Zip Code</td>
                    <td><form:input path="AREA_CODE"/></td>
                    <td><form:errors path="AREA_CODE" cssClass="error" /></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit"></td> 
                </tr> 
            </table> 
        </form:form>
    </body>
</html>