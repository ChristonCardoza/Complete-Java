class This
{
	int length;
	int width;
	This()
	{
		System.out.println("--------------------");
	}
	This(String str)
	{
		this();
		System.out.println("Area:");
	}
	This(int length, int width)
	{
		this("abc");
		this.length =length;
		this.width = width;
		this.area();
		
	}

	public void area()
	{
		System.out.println(length * width);
	}
}

public class ThisMain
{
	 public static void main(String[] args)
	{
		This r1 = new This(10,20);
		This r2 = new This(30,40);
		This r5 = new This(50,60);
		This r3 = new This(70,80);
		This r4 = new This(90,1);
		
		
	}
}

