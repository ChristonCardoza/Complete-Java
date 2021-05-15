interface I
{
	public default void abc()
	{
	}
	public static void xyz()
	{
	}
}
interface J
{
	public void display();
}
interface K
{
	public void add(int a, int b);
}
interface L
{
	public int square(int a);
}
public interface LambdaDemo
{	
	public static void main(String args[])
	{
		System.out.println("HELLO");

		J j1 = () -> System.out.println("Just for Demo");
		j1.display();

		K k1 = (x, y) -> System.out.println("Result : "+(x+y));
		k1.add(10, 20);

		L l1 = (x) -> x * x;
		System.out.println(l1.square(6));

		J j2 = 	new J()
			{
				public void display()
				{
					System.out.println("From anonymous class");
				}
			};
		j2.display();
	}
}