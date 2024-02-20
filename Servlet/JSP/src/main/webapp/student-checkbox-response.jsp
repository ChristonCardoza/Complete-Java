<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Confirmation Title</title>
</head>
<body>
The student is confirmed: ${param.firstName} ${param.lastName}
<br/><br/>

<%-- Display List of "favoriteLanguage" --%>

  Favorite Programming Languages: <br/>
  <ul>
    <%
      String[] langs = request.getParameterValues("favoriteLanguage");

      if(langs !=null){
        for(String temp: langs){
          out.println("<li>" + temp + "</li>");
        }
      }
    %>
  </ul>
</body>
</html>