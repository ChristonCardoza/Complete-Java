package org.christu.servlet.servlet_01_basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ThirdServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("This is Get method.......");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1> This is GET method of HttpServlet</h1>");
    }

}
