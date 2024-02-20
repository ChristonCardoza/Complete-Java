<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: christon
  Date: 14/02/24
  Time: 6:21 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookies Homepage</title>
</head>
<body>
<h3>Training Portal</h3>

<%
    String favLang = "Java";

    Cookie[] theCookies = request.getCookies();

    if(theCookies != null){
        for(Cookie tempCookie: theCookies){

            if("myApp.favoriteLanguage".equals(tempCookie.getName())){
                favLang = favLang = URLDecoder.decode(tempCookie.getValue(), "UTF-8");
                break;
            }
        }
    }
%>

<h4>New Books for <%= favLang%></h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>

<h4>Latest News Reports for <%= favLang%></h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>

<h4>Hot Jobs for <%= favLang%></h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>

<hr>
<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>
