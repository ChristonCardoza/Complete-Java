package org.christu.servlets;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TestParamServlets", value = "/TestParamServlets")
public class TestParamServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        String maxCartSize = context.getInitParameter("max-shopping-cart-size");
        String teamName = context.getInitParameter("project-team-name");

        out.println("<html><body>");

        out.println("Max car: " + maxCartSize);
        out.println("<br/> <br/>");
        out.println("Team name: " + teamName);

        out.println("</html></body>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}