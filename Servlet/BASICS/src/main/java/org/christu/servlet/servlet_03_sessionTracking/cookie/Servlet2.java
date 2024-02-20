package org.christu.servlet.servlet_03_sessionTracking.cookie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
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

            // Get all cookies

            Cookie[] cookies = request.getCookies();

            boolean f = false;
            String name = "";

            if(cookies == null){

                out.println("<h1>You are new user, go to home page and submit your name...</h2>");
                return;

            } else {

                for (Cookie c: cookies){

                    String tname = c.getName();

                    if(tname.equals("user_name")){

                        f = true;

                        name = c.getValue();
                    }
                }
            }

            if(f){

                out.println("<h1>Hello , " + name + " Welcome back to Servlet....</h1>");
                out.println("<h1>Thank You</h1>");

            } else {

                out.println("<h1>You are new user, go to home page and submit your name...</h2>");
            }

            out.println("</body>");
            out.println("</html>");

        }
    }
}
