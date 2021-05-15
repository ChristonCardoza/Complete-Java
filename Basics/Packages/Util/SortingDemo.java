import java.util.*;

class Student
{
	String name;
	int age;
	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public String toString()
	{
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		return "";
	}
}
public class SortingDemo
{
	public static void main(String args[])
	{
		//TreeSet<Student> ts = new TreeSet<Student>(new NameSorterDesc());

		LinkedList ts = new LinkedList();

		ts.add(new Student("Charan", 18));
		ts.add(new Student("Subhash", 10));
		ts.add(new Student("Madan", 15));
		ts.add(new Student("Ashwini", 12));
		ts.add(new Student("Babita", 11));

		Collections.sort(ts, new AgeSorter());

		Iterator<Student> i = ts.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
}


class NameSorter implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		Student s1 = (Student) obj1;
		Student s2 = (Student) obj2;

		String n1 = s1.name;
		String n2 = s2.name;

		return n1.compareTo(n2);
	}
}
class NameSorterDesc implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		Student s1 = (Student) obj1;
		Student s2 = (Student) obj2;

		String n1 = s1.name;
		String n2 = s2.name;

		return n2.compareTo(n1);
	}
}
class AgeSorter implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		Student s1 = (Student) obj1;
		Student s2 = (Student) obj2;

		Integer a1 = s1.age;
		Integer a2 = s2.age;

		return a1.compareTo(a2);
	}
}
class AgeSorterDesc implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		Student s1 = (Student) obj1;
		Student s2 = (Student) obj2;

		Integer a1 = s1.age;
		Integer a2 = s2.age;

		return a2.compareTo(a1);
	}
}