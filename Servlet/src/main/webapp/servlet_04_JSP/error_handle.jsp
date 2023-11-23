<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 23/11/23
  Time: 6:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
  <head>
      <title>Sorry !! Something went wrong...</title>
    <style>
      *{
        padding: 0px;
        margin: 0px;
      }
    </style>
  </head>
  <body>
    <div style="padding: 20px; color: blue; background: #e2e2e2">
      <h1>Sorry!! Something went wrong...</h1>
      <br>
      <p><%= exception %></p>
    </div>
  </body>
</html>
