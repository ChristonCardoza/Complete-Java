<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 14/02/24
  Time: 11:47 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Functions</title>
</head>
<body>
<c:set var="data" value="DeadMan" />
Length of the string <b> ${data} </b>: ${fn:length(data)}
<br/> <br/>
Uppercase version of the string <b> ${data} </b>: ${fn:toUpperCase(data)}
<br/> <br/>
Does the string <b> ${data} </b> start with <b>Dead</b>?: ${fn:startsWith(data, "Dead")}
</body>
</html>
