<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 14/02/24
  Time: 10:43 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String[] cities = {"Mumbai", "Singapore", "Philadelphia"};

    pageContext.setAttribute("myCities", cities);
%>
<html>
<head>
    <title>ForEach</title>
</head>
<body>
<c:forEach var="tempCity" items="${myCities}">
    ${tempCity} <br/>
</c:forEach>
</body>
</html>
