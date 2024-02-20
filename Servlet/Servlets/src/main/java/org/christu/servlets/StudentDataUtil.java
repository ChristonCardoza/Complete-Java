package org.christu.servlets;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

    public static List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Mary", "Public", "mary@xyz.com"));
        students.add(new Student("John", "Doe", "john@xyx.com"));
        students.add(new Student("Ajay", "Rao", "ajay@xyz.com"));

        return students;
    }
}
