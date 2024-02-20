package org.christu.servlet.servlet_03_sessionTracking.urlRewrite;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try(PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet 2</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1 style = 'color:blue:'> Welcome to servlet 2</h1>");
            // url fetch
            String name = request.getParameter("user");
            out.println("<h1 style = 'color:red:'> Welcome back "+ name +"</h1>");

            out.println("</body>");
            out.println("</html>");

        }
    }
}