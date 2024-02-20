<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 15/02/24
  Time: 11:37 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Split Cities</title>
</head>
<body>
<c:set var="data" value="Singapore,Tokyo,Mumbai,London" />
<h3>Split Demo</h3>
<c:set var="citiesArray" value="${fn:split(data, ',')}" />

<c:forEach var="tempCity" items="${citiesArray}">
    ${tempCity} <br/>
</c:forEach>

<h3>Join Demo</h3>
<c:set var="fun" value="${fn:join(citiesArray, '*')}" />

Result of joining: ${fun}
</body>
</html>
