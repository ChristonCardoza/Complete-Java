<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 24/11/23
  Time: 7:44 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
    <h1 align="center">Menu</h1>
    <table border="1" cellpadding="30%" align="center" bordercolor="red">
        <tr>
            <th>Code</th>
            <th>Item</th>
            <th>Price</th>
        </tr>
        <c:forEach var="items" items="${foodItems}">
            <tr>
                <td>${items.id}</td>
                <td>${items.item}</td>
                <td>${items.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
