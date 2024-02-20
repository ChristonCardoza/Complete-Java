<%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 15/02/24
  Time: 12:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}" scope="session" />

<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="mylabels" />

<html>
<head>
    <title>i18n</title>
</head>
<body>

<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a>
|
<a href="i18n-messages-test.jsp?theLocale=es_ES">Spanish (ES)</a>
|
<a href="i18n-messages-test.jsp?theLocale=de_DE">German (DE)</a>

<hr>

<fmt:message key="label.greeting" /> <br /> <br />
<fmt:message key="label.firstname" /> <i>John</i> <br />
<fmt:message key="label.lastname" /> <i>Doe</i> <br />
<fmt:message key="label.welcome" /> <br /> <br />

<hr>

Selected locale: ${theLocale}

</body>
</html>
