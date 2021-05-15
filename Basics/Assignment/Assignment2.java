package com.xyz.demo;
import java.util.Scanner;
interface Employee{
	
	void name();
	void age();
	void display();
	void increment();
	
}


class Assignment implements Employee{
	String name;
	int age;
	Scanner sc = new Scanner(System.in);
	
	public void name() {
		System.out.println("Enter the Employee Name: ");
		name = sc.next();
		
	}
	
	public void age() {
		System.out.println("Enter the Employee Age: ");
		age = sc.nextInt();
	}
	public void display() {}
	public void increment() {}
	
}

class Clerk extends Assignment
{
	
	int salary = 8000;
	int hikeSalary = 2000;
	String designation = "Clerk";
	
	public void display() {
	
		System.out.println("----------Employee Details are--------------:");
		System.out.printf("Employee Name is: %s \nEmployee Age is: %d \nEmployee designation is: %s \nEmployee salary is: %d \n", name,age,designation,salary);
		
	}
	
	public void increment() {
		
		salary+=hikeSalary;
	}
			

}

class Programmer extends Assignment
{
	
	int salary = 25000;
	int hikeSalary = 5000;
	String designation = "Programmer";
	
	public void display() {
	
		System.out.println("----------Employee Details are--------------:");
		System.out.printf("Employee Name is: %s \nEmployee Age is: %d \nEmployee designation is: %s \nEmployee salary is: %d \n", name,age,designation,salary);
		
	}
	
	public void increment() {
		
		salary+=hikeSalary;
	}
			

}

class Manager extends Assignment
{
	
	int salary = 70000;
	int hikeSalary = 10000;
	String designation = "Manager";
	
	public void display() {
	
		System.out.println("----------Employee Details are--------------:");
		System.out.printf("Employee Name is: %s \nEmployee Age is: %d \nEmployee designation is: %s \nEmployee salary is: %d \n", name,age,designation,salary);
		
	}
	
	public void increment() {
		
		salary+=hikeSalary;
	}
			

}
	
public class Assignment2{
	
	public void executer() {
		
		System.out.println("----------Clerk Infomation--------------");
		Employee c = new Clerk();
		c.name();
		c.age();
		c.display();
		System.out.println("*****************After Increment*****************");
		c.increment();
		c.display();
		System.out.println("----------Programmer Infomation--------------");
		Assignment p = new Programmer();
		p.name();
		p.age();
		p.display();
		System.out.println("*****************After Increment*****************");
		p.increment();
		p.display();
		System.out.println("----------Manager Infomation--------------");
		Manager m = new Manager();
		m.name();
		m.age();
		m.display();
		System.out.println("*****************After Increment*****************");
		m.increment();
		m.display();
		
		
	}
}
	

