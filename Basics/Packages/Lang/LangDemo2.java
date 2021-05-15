import java.lang.reflect.*;

class A implements Cloneable
{
	int x;
	public A clone()
	{
		try
		{
			return (A)super.clone();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public String toString()
	{
		return "Object of A class with value of x : "+x;
	}
	public void finalize()
	{
		System.out.println("Object with value "+x+" getting removed....");
	}
}
public class LangDemo2
{
	public static void main(String args[]) throws Exception
	{
		A a1 = new A();
		a1.x = 10;

		A a2 = new A();
		a2.x = 50;

		System.out.println(a1.equals(a2));

		Class c1 =	a2.getClass();
		System.out.println("a2 is an instance of "+c1.getName()+" class");

		System.out.println("Hello is instance of "+"Hello".getClass().getName());

		A a3 = a1.clone();	
		System.out.println(a3.x);	

		a3.x = 100;

		System.out.println(a1);	
		System.out.println(a2);	
		System.out.println(a3);	

		a1 = null;
		a2 = null;
		a3 = null;

		System.gc();
		Thread.sleep(2000);	

		Class c2 = Class.forName(args[0]);	
		Object obj = c2.newInstance();
		System.out.println(obj);

		Field f[] = c2.getFields();
		Constructor c[] = c2.getConstructors();
		Method m[] = c2.getMethods();

		System.out.println("public class "+c2.getName());
		System.out.println("{");
		for(int i=0; i<m.length; i++)
		{
			System.out.println("\t"+m[i].getName()+"()");
		}
		System.out.println("}");
	}
}