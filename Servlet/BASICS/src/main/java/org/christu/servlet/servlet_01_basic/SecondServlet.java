package org.christu.servlet.servlet_01_basic;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("This is servlet using generic servlet");
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.println("<h1> This is my second servlet using generic servlet </h1>");
    }
}
