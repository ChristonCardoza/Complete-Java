package org.christu.servlet.servlet_02_attr;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class S1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try(PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet S1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet S1 at " +  request.getContextPath() +"</h1>");

            String n1 = request.getParameter("n1");
            String n2 = request.getParameter("n2");

            int nn1 = Integer.parseInt(n1);
            int nn2 = Integer.parseInt(n2);

            int s = nn1 + nn2;

            request.setAttribute("sum", s);

            RequestDispatcher rd = request.getRequestDispatcher("s2");

            rd.forward(request, response);

            out.println("</body>");
            out.println("</html>");

        }
    }
}
