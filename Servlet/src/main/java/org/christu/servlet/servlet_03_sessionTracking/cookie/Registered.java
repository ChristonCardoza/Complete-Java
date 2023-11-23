package org.christu.servlet.servlet_03_sessionTracking.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

import java.io.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import com.mysql.jdbc.Driver;

@MultipartConfig
public class Registered extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try(PrintWriter out = response.getWriter()) {

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Cookies Project</title>");
//            out.println("</head>");
//            out.println("<body>");
//
            String name = request.getParameter("user_name");
            String email = request.getParameter("user_email");
            String password = request.getParameter("user_password");
            Part part = request.getPart("image");
            String filename = part.getSubmittedFileName();

//            out.println("FileName: " + filename);

//            out.println(name);
//            out.println(password);
//            out.println(email);


            try {

                Thread.sleep(3000);

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cookies", "root", "toor");

                String q = "insert into user(name, password, email, imageName) values (?, ?, ?, ?)";

                PreparedStatement statement = con.prepareStatement(q);
                statement.setString(1, name);
                statement.setString(2, password);
                statement.setString(3, email);
                statement.setString(4, filename);

                statement.executeUpdate();

                // upload file

//                InputStream is = part.getInputStream();
//                byte[] data = new byte[is.available()];
//
//                is.read(data);
//
//                String path = "/home/christon/Practice/Complete-Java/Servlet/src/main/resources/" + File.separator + filename;
//
//                out.println(path);
//                FileOutputStream fos = new FileOutputStream(path);
//                fos.write(data);
//                fos.close();

                out.println("done");

            } catch (Exception e){

                e.printStackTrace();
                out.println("Error>");
            }

//            out.println("</body>");
//            out.println("</html>");

        }
    }
}
