<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 14/02/24
  Time: 2:56 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>Todo</title>
</head>
<body>
<form action="todo-demo.jsp">
    Add new item: <input type="text" name="theItem">

    <input type="submit" value="Submit">
</form>

<br>

<%
    List<String> items = (List<String>) session.getAttribute("myToDoList");

    if(items == null){

        items = new ArrayList<String>();
        session.setAttribute("myToDoList", items);
    }

    String theItem = request.getParameter("theItem");
    boolean isItemNotEmpty = theItem != null && theItem.trim().length() > 0;
    boolean isItemNotDuplicate = theItem != null && !items.contains(theItem.trim());

    if (isItemNotEmpty && isItemNotDuplicate) {
        items.add(theItem.trim());
    }
%>

<hr>

<b> Todo List Items: </b> <br/>

<ol>

    <%
        for(String temp: items){

            out.println("<li>" + temp + "</li>");
        }
    %>
</ol>

</body>
</html>
