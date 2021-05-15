package assignment;
import java.util.Scanner;
interface Employee
{
	int clerkHike = 2000;
	int programmerHike = 5000;
	int managerHike = 10000;
}
class Emp
{
	String name;
	int age;
	int salary;
	String desig;
	Emp()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter name:");
		name = sc.next();
		System.out.print("Enter age:");
 		age = sc.nextInt();
	}
	public void display()
	{
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Salary: "+salary);
		System.out.println("Designation: "+desig);
		System.out.println();
	}
	void raisedSalary()
	{
		salary+=Employee.clerkHike;
	}
}
class Clerk extends Emp
{
	Clerk()
	{
		salary = 8000;
		desig = "Clerk";
	}
}
class Programmer extends Emp
{
	Programmer ()
	{
		salary = 25000;
		desig = "Programmer";
	}
	
	void raisedSalary()
	{
		salary+=Employee.programmerHike;
	}
	
}
class Manager extends Emp
{
	Manager ()
	{
		salary = 70000;
		desig = "Manager";
	}
	void raisedSalary()
	{
		salary+=Employee.managerHike;
	}
	
}

public class Assign{
	
	public static void main(String args[]) {
		
		Emp e1 = new Clerk();
		Emp e2 = new Programmer();
		Emp e3 = new Manager();
		
		System.out.println("------Employee Details------");
		
		e1.display();
		e2.display();
		e3.display();
		
		System.out.println("------Employee Details------");
		
		e1.raisedSalary();
		e2.raisedSalary();
		e3.raisedSalary();
		
		System.out.println("------After raising salary------");
		
		e1.display();
		e2.display();
		e3.display();
		
		

	}
}