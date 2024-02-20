package org.christu.servlet.servlet_01_basic;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FirstServlet implements Servlet {

    ServletConfig conf;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        this.conf = servletConfig;
        System.out.println("Creating Object....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.conf;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Serving....");

        // set content type of the response
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.println("<h1>This is my output from servlet method</h1>");
        out.println("<h1>Todays date and time is " + new Date().toString() +"< /h1>");
    }

    @Override
    public String getServletInfo() {
        return "This servlet is created by Christon....";
    }

    @Override
    public void destroy() {
        System.out.println("Going to destroy servlet object...");
    }
}
