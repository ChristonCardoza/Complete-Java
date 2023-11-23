package org.christu.servlet.servlet_03_sessionTracking.urlRewrite;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try(PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet 1</title>");
            out.println("</head>");
            out.println("<body>");

            String name = request.getParameter("user_name");

            out.println("<h1> Your name is: " + name + "</h1>");

            // performing url url rewrite
            out.println("<a href='urlWritingServlet2?user="+name+"'>Go to second servlet</a>");

            out.println("</body>");
            out.println("</html>");

        }
    }
}
