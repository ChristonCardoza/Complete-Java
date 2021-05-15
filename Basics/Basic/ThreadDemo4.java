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
					Thread.sleep(3000);
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
public class  ThreadDemo4
{	
	public static void main(String args[])  throws Exception	
	{
		ThreadGroup tg = new ThreadGroup("Demo Group");
		
		A a1 = new A();
		B b1 = new B();
		C c1 = new C();
		
		Thread t1 = new Thread(tg,a1);
		Thread t2 = new Thread(tg,b1);
		Thread t3 = new Thread(tg,c1);
		

		t1.start();
		t2.start();
		t3.start();
		
		for(int i=1;i<=200;i++)
		{
			System.out.println(i+" ");
			if(i==20)
				tg.suspend();
			if(i==80)
				tg.resume();
			if(i==100)
				tg.stop();
			if(i==150)
				tg.resume();
		}

		System.out.println("Main Exit");
	}
}