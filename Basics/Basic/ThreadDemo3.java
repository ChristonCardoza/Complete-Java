class A extends Thread
{
	public void run()
	{
		for(int i=1; i<=20; i++)
		{
			System.out.println("i : "+i);
			try
			{
				if(i%3==0)
					Thread.sleep(5000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
class B extends Thread
{
	public void run()
	{
		for(int j=1; j<=20; j++)
		{
			System.out.println("j : "+j);
			try
			{
				if(j%4==0)
					Thread.sleep(2000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
class C extends Thread
{
	public void run()
	{
		for(int k=1; k<=20; k++)
		{
			System.out.println("k : "+k);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
public class  ThreadDemo3
{	
	public static void main(String args[])	throws Exception
	{
		A a1 = new A();
		B b1 = new B();
		C c1 = new C();
		
		b1.setDaemon(true);

		a1.start();
		b1.start();
		c1.start();

		
		System.out.println("a1 is Daemon: "+a1.isDaemon());
		System.out.println("b1 is Daemon: "+b1.isDaemon());
		System.out.println("c1 is Daemon: "+c1.isDaemon());

	}
}