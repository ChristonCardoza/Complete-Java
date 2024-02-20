<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 15/02/24
  Time: 3:38 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <c:forEach var="tempStudent" items="${student_list}">

        ${tempStudent} <br/>

    </c:forEach>
</body>
</html>
