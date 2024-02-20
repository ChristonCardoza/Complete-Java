<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 30/11/23
  Time: 6:15 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Builtin</title>
</head>
<body>
    <h3> JSP Built-In Objects </h3>

    Request user agent: <%= request.getHeader("User-Agent")%>
    <br/><br/>

    Request language: <%= request.getLocale() %>
</body>
</html>
