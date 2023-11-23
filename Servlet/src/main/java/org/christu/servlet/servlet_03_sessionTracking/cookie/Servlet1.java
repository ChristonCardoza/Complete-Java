package org.christu.servlet.servlet_03_sessionTracking.cookie;

import jakarta.servlet.RequestDispatcher;
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

            String name = request.getParameter("name");

            out.println("<h1>Hello , " + name + " Welcome to Servlet....</h1>");
            out.println("<h1><a href='servlet2'> Go to servlet 2</a></h1>");


            // Create a cookie

            Cookie c = new Cookie("user_name", name);
            response.addCookie(c);

            out.println("</body>");
            out.println("</html>");

        }
    }
}
