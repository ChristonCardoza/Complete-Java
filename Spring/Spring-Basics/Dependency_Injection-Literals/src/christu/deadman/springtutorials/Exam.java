package christu.deadman.springtutorials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {
	public static void main(String[] args) {
		
//		Student s = new Student();
//		s.studentName = "Christon Cardoza";
//		s.studentInfo();
		
//		Student s = new Student();
//		s.setstudentName("Christon Cardoza");
//		s.studentInfo();
		
//		Student s = new Student("Christon Cardoza");
//		s.studentInfo();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Student student = context.getBean("student",Student.class);
		student.studentInfo();
	}

}
