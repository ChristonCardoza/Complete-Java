package org.christu.project.jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

    private DataSource dataSource;

    public  StudentDbUtil(DataSource theDataSource){
        dataSource = theDataSource;
    }

    public List<Student> getStudents() throws Exception {
        List<Student> students = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

//        1. Get a connection
            myConn = dataSource.getConnection();

//        2. Create sql statement
            String sql = "select * from student order by last_name";
            myStmt = myConn.createStatement();

//        3. Execute query
            myRs = myStmt.executeQuery(sql);

//        4. Process result set
            while(myRs.next()){

                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                Student tempStudent = new Student(id, firstName, lastName, email);

                students.add(tempStudent);


            }

            return students;

        }
        finally {
            //        5. Close JDBC objects

            close(myConn, myStmt, myRs);
        }


    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs){

        try {

            if(myRs != null){
                myRs.close();
            }

            if(myStmt != null){
                myStmt.close();
            }

            if(myConn != null) {
                myConn.close();
            }

        } catch(Exception exp){
            exp.printStackTrace();
        }
    }

    public void addStudent(Student theStudent) throws Exception{

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "insert into student (first_name, last_name, email) values (?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, theStudent.getFirstName());
            myStmt.setString(2, theStudent.getLastName());
            myStmt.setString(3, theStudent.getEmail());

            myStmt.execute();

        } finally {
            close(myConn, myStmt, null);
        }
    }

    public Student getStudents(String theStudentId) throws Exception{

        Student theStudent = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int studentId;

        try {

            studentId = Integer.parseInt(theStudentId);

            myConn = dataSource.getConnection();

            String sql = "select * from student where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, studentId);

            myRs = myStmt.executeQuery();

            if(myRs.next()){
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                theStudent = new Student(studentId, firstName, lastName, email);

            } else {
                throw new Exception("Could not find the student id: " + studentId);
            }

            return theStudent;
        } finally {
            close(myConn, myStmt, myRs);
        }

    }

    public void updateStudent(Student theStudent) throws Exception{

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try{
            myConn = dataSource.getConnection();

            String sql = "update student set first_name=?, last_name=?, email=? where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, theStudent.getFirstName());
            myStmt.setString(2, theStudent.getLastName());
            myStmt.setString(3, theStudent.getEmail());
            myStmt.setInt(4, theStudent.getId());

            myStmt.execute();

        }finally {
            close(myConn, myStmt, null);
        }
    }

    public void deleteStudent(String theStudentId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try{
            int studentId = Integer.parseInt(theStudentId);

            myConn = dataSource.getConnection();

            String sql = "delete from student where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, studentId);

            myStmt.execute();

        }finally {
            close(myConn, myStmt, null);
        }
    }
}
