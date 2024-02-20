<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 19/02/24
  Time: 11:47 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.christu.project.jdbc.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student Tracker App</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<%
    List<Student> theStudents = (List<Student>) request.getAttribute("STUDENT_LIST");
%>

<body>

    <div id="wrapper">
        <div id="header">
            <h2>FooBar University</h2>
        </div>
    </div>

    <div id = "container">

        <div id="content">

            <input
                    type="button"
                    value="Add Student"
                    onclick="window.location.href='add-student-form.jsp'; return false;"
                    class="add-student-button"
            />

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="tempStudent" items="${STUDENT_LIST}">

                    <c:url var="tempLink" value="StudentControllerServlet">
                        <c:param name="command" value="LOAD" />
                        <c:param name="studentId" value="${tempStudent.id}" />
                    </c:url>
                    <c:url var="deleteLink" value="StudentControllerServlet">
                        <c:param name="command" value="DELETE" />
                        <c:param name="studentId" value="${tempStudent.id}" />
                    </c:url>
                    <tr>
                        <td> ${tempStudent.getFirstName()}</td>
                        <td> ${tempStudent.getLastName()}</td>
                        <td> ${tempStudent.getEmail()}</td>
                        <td>
                            <a href="${tempLink}">Update</a>
                            |
                            <a
                                    href="${deleteLink}"
                                    onclick="if (!(confirm('Are you sure want to delete this student?'))) return false"
                            >
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
