package com.cardoza.foodcart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDbUtil {

    public static List<Food> getFoodList() throws ClassNotFoundException, SQLException {

        ArrayList<Food> food = new ArrayList<Food>();

        String url = "jdbc:mysql://localhost:3306/Food";
        String userName = "root";
        String password = "toor";

        // load the mysql driver
        Class.forName("com.mysql.jdbc.Driver");

        // get the connection
        Connection con = DriverManager.getConnection(url, userName, password);

        // create statement
        Statement statement = con.createStatement();

        // execute the statement and loop over the result set
        ResultSet rs = statement.executeQuery("select * from foodcart");

        while (rs.next()){

            int id = rs.getInt(1);
            String item = rs.getString(2);
            float price = rs.getFloat(3);

            Food f = new Food(id, item, price);
            food.add(f);
        }

        return food;
    }
}
