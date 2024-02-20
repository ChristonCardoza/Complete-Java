<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 14/02/24
  Time: 11:11 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, org.christu.jsp.Student" %>
<%
    List<Student> data = new ArrayList<>();

    data.add(new Student("John", "Doe", false));
    data.add(new Student("Maxwell", "Johnson", false));
    data.add(new Student("Mary", "Public", true));

    pageContext.setAttribute("myStudents", data);
%>
<html>
<head>
    <title>Student</title>
</head>
<body>

<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gold Name</th>
    </tr>

    <c:forEach var="tempStudent" items="${myStudents}">
        <tr>
            <td>${tempStudent.firstName}</td>
            <<td>${tempStudent.lastName}</td>
            <td>
                <c:choose>
                    <c:when test="${tempStudent.goldCustomer}"> Special Discount </c:when>
                    <c:otherwise> no soup for you! </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
