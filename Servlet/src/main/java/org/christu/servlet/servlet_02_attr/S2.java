package org.christu.servlet.servlet_02_attr;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class S2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try(PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet S2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet S2 at " +  request.getContextPath() +"</h1>");

            int nn1 = Integer.parseInt(request.getParameter("n1"));
            int nn2 = Integer.parseInt(request.getParameter("n2"));

            int p = nn1 * nn2;

           int sum = (int) request.getAttribute("sum");

           out.println("<h1>");
           out.println("Sum is = " + sum);
           out.println("Product is = " + p);
           out.println("<h1>");

            out.println("</body>");
            out.println("</html>");

        }
    }
}
