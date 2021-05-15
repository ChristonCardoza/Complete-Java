	
package assignment;

import java.util.Scanner;

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

	static int count=0;

	Emp()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter name : ");
		name = sc.next();
		System.out.print("Enter age : ");
		age = sc.nextInt();

		count++;
	}
	final public void display()
	{
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Salary : "+salary);
		System.out.println("Designation : "+desig);
		System.out.println();
	}
	public abstract void raiseSalary();
}
final class Clerk extends Emp
{
	Clerk()
	{
		salary = 8000;
		desig = "Clerk";
	}
	public void raiseSalary()
	{
		salary += Employee.clerkHike;
	}	
}
final class Programmer extends Emp
{
	Programmer()
	{
		salary = 25000;
		desig = "Programmer";
	}
	public void raiseSalary()
	{
		salary += Employee.programmerHike;
	}	
}
final class Manager extends Emp
{
	Manager()
	{
		salary = 70000;
		desig = "Manager";
	}
	public void raiseSalary()
	{
		salary += Employee.managerHike;
	}	
}

public class EmpMain
{
	public static void main(String args[])
	{	
		int ch1=0, ch2=0;
		Emp emp[] = new Emp[100];
		do
		{
			System.out.println("-----------------------");
			System.out.println("  1.  Create  ");
			System.out.println("  2.  Display  ");
			System.out.println("  3.  Raise Salary  ");
			System.out.println("  4.  Exit  ");
			System.out.println("-----------------------");
			System.out.print("Enter choice :- ");
			ch1 = new Scanner(System.in).nextInt();
			if(ch1==1)
			{
				do
				{
					System.out.println("-----------------------");
					System.out.println("  1.  Clerk  ");
					System.out.println("  2.  Programmer  ");
					System.out.println("  3.  Manager  ");
					System.out.println("  4.  Exit  ");
					System.out.println("-----------------------");
					System.out.print("Enter choice :- ");
					ch2 = new Scanner(System.in).nextInt();
					switch(ch2)
					{
						case 1 : emp[Emp.count] = new Clerk();
							break;
						case 2 : emp[Emp.count] = new Programmer();
							break;
						case 3 : emp[Emp.count] = new Manager();
							break;
					}
				}while(ch2 != 4);
			}
			else if(ch1==2)
			{
				for(int i=0; i<Emp.count; i++)
					emp[i].display();
			}
			else if(ch1==3)
			{
				for(int i=0; i<Emp.count; i++)
					emp[i].raiseSalary();
			}
		}while(ch1 != 4);
		System.out.println("Total no. of employees created : "+Emp.count);
	}
}	
		
		
