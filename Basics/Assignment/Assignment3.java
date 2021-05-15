import java.util.Scanner;
import java.util.InputMismatchException;

interface Employee
{
	int clerkHike = 2000;
	int programmerHike = 5000;
	int managerHike = 10000;
}
abstract class Emp 
{
	String name;
	int age;
	int salary;
	String desig;
	static int counter =  0;
	Emp() throws  MyStringException,InputMismatchException
	{
		counter+=1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		name = sc.next();
		System.out.println("Enter age:");
 		age = sc.nextInt();
 		if(age>60) {
 			
 			throw new MyStringException("Your too old to become a Employer");
 		}
 		else if (age<18) {
 			
 			throw new MyStringException("Your too young to become a Employer");
 		}
	}
	final public void display()
	{
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Salary: "+salary);
		System.out.println("Designation: "+desig);
		System.out.println();
	}
	
	public abstract void raisedSalary();
	
}
final class Clerk extends Emp
{
	Clerk() throws  MyStringException
	{
		salary = 8000;
		desig = "Clerk";
	}
	public void raisedSalary()
	{
		salary+=Employee.clerkHike;
	}
}
final class Programmer extends Emp
{
	Programmer () throws  MyStringException
	{
		salary = 25000;
		desig = "Programmer";
	}
	
	public void raisedSalary()
	{
		salary+=Employee.programmerHike;
	}
	
}
final class Manager extends Emp
{
	Manager () throws  MyStringException
	{
		salary = 70000;
		desig = "Manager";
	}
	public void raisedSalary()
	{
		salary+=Employee.managerHike;
	}
	
}

public class Assignment3{
		
	public static void main(String args[]) {
		
		int choice=0,option;
		Emp emp[] = new Emp[100];
		Scanner sc = new Scanner(System.in);
		String[] A = {"1. Create","2. Display","3. Raise Salary","4. Exit"};
		do {
					
					for(String str:A){
						
						System.out.println(str);
					}
					
					System.out.println("-------------------");
					System.out.println("Enter Your Choice:");
					System.out.println("-------------------");
				
				try {
					    Scanner scr = new Scanner(System.in);
						choice = scr.nextInt();
						
						switch(choice){
						
						   	case 1: do{
								
											String[] Empl = {"1. Clerk","2. Programmer","3. Mannager","4. Exit"};
											for(String str:Empl){
											
												System.out.println(str);
											}
											System.out.println("-------------------");
											System.out.println("Enter Your option:");
											System.out.println("-------------------");
											option = sc.nextInt();
											try {
												
												switch( option ){
												
												case 1:emp[Emp.counter]= new Clerk();
														break;
												case 2: emp[Emp.counter]  = new Programmer();
														break;
												case 3: emp[Emp.counter] = new Manager();
														break;
												}
											}
											catch(MyStringException mse){
												
												System.out.println("Reson for Exception: "+mse.getMessage());
												Emp.counter --;
				
											}
											catch(InputMismatchException ime){
												
												System.out.println("Reson for Exception: "+ime);
												Emp.counter --;
				
											}
											
				//							catch(NullPointerException e){
				//								
				//								System.out.println("Reson for Exception: "+e);
				//								break;
				//							}
											
										
									}while(option!=4);
							
									break;
									
						   	case 2:	for(int i=0; i<Emp.counter; i++)
						   					emp[i].display();
						   			break;
						   			
						   	case 3:	for(int i=0; i<Emp.counter; i++)
			   							emp[i].raisedSalary();
						   			break;
							
						}
						
					}
				catch(InputMismatchException ime){
					System.out.println("Reson for Exception: "+ime);
					//break;
				}

		}while(choice !=4);

		
		
	}
		
			
	
}	

class MyStringException extends Exception
{
	public MyStringException()
	{
	}
	public MyStringException(String msg)
	{
		super(msg);
	}
	
}
	