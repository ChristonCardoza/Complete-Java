package com.cardoza.foodcart;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FoodCart", value = "/FoodCart")
public class FoodCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the data from database(model)
        try {
            List<Food> foodItems = FoodCartDbUtil.getFoodList();
            request.setAttribute("foodItems", foodItems);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // redirect to a different page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("show-food.jsp");
        dispatcher.forward(request, response);
    }
}