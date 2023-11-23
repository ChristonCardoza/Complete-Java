<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 23/11/23
  Time: 5:27 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.Random, java.util.ArrayList, java.io.*" %>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<%@include file="header.jsp"%>
    <h1>First JSP Page</h1>

     <%!
         int a = 50;
         int b = 10;
         String name  = "Chrisu's World";

         public int doSum(){
              return a + b;
         }

         public String reverse() {
             StringBuffer br = new StringBuffer(name);
             return br.reverse().toString();
         }
     %>

    <%
        out.println(a);
        out.println("<br>");
        out.println(b);
        out.println("<br>");
        out.println("Sum is : "+ doSum());
        out.println("<br>");
        out.println(reverse());
    %>

    <h1>Sum is: <%= doSum() %></h1>

    <h1>
        Randon number:
        <%
            Random r = new Random();
            int n = r.nextInt(10);
        %>
        <%= n %>
    </h1>

<%--    <h1>TagLib Example: </h1>--%>
<%--    <c:set var="name" value="Cardoza World"></c:set>--%>
<%--    <c:out value="${name}"></c:out>--%>

</body>
</html>
