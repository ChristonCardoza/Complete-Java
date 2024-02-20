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

    <h2> Student Table Demo </h2>
    <hr>
    <br/>

    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email Name</th>
        </tr>

        <c:forEach var="tempStudent" items="${student_list}">

            <tr>
                <td> ${tempStudent.firstName}</td>
                <td> ${tempStudent.lastName}</td>
                <td> ${tempStudent.email}</td>
            </tr>

        </c:forEach>

    </table>

</body>
</html>
