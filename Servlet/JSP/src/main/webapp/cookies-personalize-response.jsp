<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 14/02/24
  Time: 6:10 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookies Personalize Response</title>
</head>

    <%
        String favLang = request.getParameter("favoriteLanguage");
        favLang = URLEncoder.encode(favLang, "UTF-8");

        Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);

        theCookie.setMaxAge(60 * 69 * 24 * 365);

        response.addCookie(theCookie);
    %>
<body>
    Thanks! We set your favorite language to : ${param.favoriteLanguage}
    <br/> <br/>

    <a href="cookies-homepage.jsp">Return to homepage.</a>
</body>
</html>
