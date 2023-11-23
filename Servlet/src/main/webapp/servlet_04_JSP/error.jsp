<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 23/11/23
  Time: 6:33 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error_handle.jsp" %>
<html>
  <head>
      <title>Eror</title>
  </head>
  <body>
    <%!
      int n1 = 20;
      int n2 = 0;
    %>

    <%
      int division = n1/n2;
    %>

    <h1>Division = <%= division %></h1>
  </body>
</html>
