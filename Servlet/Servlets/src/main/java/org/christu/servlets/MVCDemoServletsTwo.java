package org.christu.servlets;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MVCDemoServletsTwo", value = "/MVCDemoServletsTwo")
public class MVCDemoServletsTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student> students = StudentDataUtil.getStudents();

        request.setAttribute("student_list", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view_students_two.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}