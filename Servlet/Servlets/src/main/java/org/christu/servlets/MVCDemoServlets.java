package org.christu.servlets;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MVCDemoServlets", value = "/MVCDemoServlets")
public class MVCDemoServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] students = {"Susan", "Anil", "Mohamed", "Trupti"};
        request.setAttribute("student_list", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_student.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}