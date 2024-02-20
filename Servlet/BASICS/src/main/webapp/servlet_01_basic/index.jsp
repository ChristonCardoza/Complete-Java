<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java Servlet Practice</title>

    <style>

        .container {
            width: 30%;
            border: 1px solid black;
            margin: auto;
            padding: 20px;
            font-size: 20px;
        }

        #form table tr td input {
            font-size: 20px;
        }
    </style>
</head>
<body>
<%--    <h1><%= "Hello World!" %></h1>--%>
<%--    <br/>--%>

<%--    <h1><a href="hello-servlet">Hello Servlet</a></h1>--%>
<%--    <h1><a href="first">First Servlet</a> </h1>--%>
<%--    <h1><a href="second">Second Servlet</a> </h1>--%>
    <div class="container">

        <h1>Form</h1>

        <form id="form" action="registerServlet" method="post">
            <table>
                <tr>
                    <td>Enter name:</td>
                    <td><input type="text" name="user_name" placeholder="Enter here" /></td>
                </tr>

                <tr>
                    <td>Enter your password: </td>
                    <td><input type="password" name="user_password" placeholder="Enter here" /></td>
                </tr>


                <tr>
                    <td>Enter your email: </td>
                    <td><input type="email" name="user_email" placeholder="Enter here" /></td>
                </tr>

                <tr>
                    <td>Select Gender: </td>
                    <td><input type="radio" name="user_gender" value="male"> Male &nbsp; &nbsp; <input type="radio" name="user_gender" value="female">Female</td>
                </tr>

                <tr>
                    <td>Select your course</td>
                    <td>
                        <select name ="user_course">
                            <option value="Java">Java</option>
                            <option value="Php">Php</option>
                            <option value="Python">Python</option>
                            <option value="Android">Android</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td style="text-align: right"><input type="checkbox" value="checked" name="condition"></td>
                    <td> Agree terms and conditions</td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <button type="submit">Register</button>
                        <button type="reset">Reset</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>