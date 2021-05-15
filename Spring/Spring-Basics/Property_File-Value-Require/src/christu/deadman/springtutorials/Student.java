package christu.deadman.springtutorials;

public class Student {
	
	private String name;
	private String interestedCourse;
	private String hobby;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setInterestedCourse(String interestedCourse) {
		this.interestedCourse = interestedCourse;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public void studentInfo() {
		System.out.println("Student Name : "+name);
		System.out.println("Student interest course :"+interestedCourse);
		System.out.println("Student Hoby : "+hobby);
	}
	

}
