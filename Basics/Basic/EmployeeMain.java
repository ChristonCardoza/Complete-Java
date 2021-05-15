import java.util.Scanner;
import java.util.Scanner;
class Employee {
	
	String empName;
	int empAge;
	int empSalary;
	
	Employee()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee Name: " );
		this.empName = sc.next();
		System.out.println("Employee Age: " );
		this.empAge = sc.nextInt();
		System.out.println("Employee Salary: " );
		this.empSalary = sc.nextInt();
	
	}
	
	void display() {
		
		System.out.printf("Employee Name is: %s \nEmployee Age is: %d \nEmployee salary is: %d \n", empName,empAge,empSalary);
	}
	
	void raisedSalary() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter raising amount for object");
		int salary= sc.nextInt();
		
		this.empSalary = this.empSalary + salary;
	}
	
	
}
public class EmployeeMain {

	public static void main(String[] args) {
		
		System.out.println("---------------------------------------------------" );
		System.out.println("Employee Details" );
		System.out.println("---------------------------------------------------" );
		Employee e1 = new Employee();
		e1.display();
		System.out.println("************************************" );
		Employee e2 = new Employee();
		e2.display();
		System.out.println("************************************" );
		Employee e3 = new Employee();
		e3.display();
		System.out.println("************************************" );
		System.out.println("---------------------------------------------------" );
		System.out.println("After Raising Salary" );
		System.out.println("---------------------------------------------------" );
		e1.raisedSalary();
		e1.display();
		System.out.println("************************************" );
		e2.raisedSalary();
		e2.display();
		System.out.println("************************************" );
		e3.raisedSalary();
		e3.display();
		System.out.println("************************************" );
		
		
	}

}
