package christu.deadman.springtutorials;

public class Student {
	
//	public String studentName;
	private String studentName;
	
//	public void setstudentName(String studentName) {
//		this.studentName = studentName;
//		System.out.println("The setter method is called for : Student Name");
//	}
	
	Student(String studentName){
		this.studentName = studentName;
		System.out.println("The constructor is called for : Student Name");
	}
	public void studentInfo() {
		
		System.out.println("The Student name is : "+studentName);
	}

}
