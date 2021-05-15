import java.io.*;

class A
{
	public void abc() throws ArithmeticException, IOException, UserException
	{
		
			int a = 50;
			for(int i=1; i<=20; i++)
			{
				System.out.println(i);
				int res = a/(a-i);
				if(i==150)
					throw new NullPointerException();
				if(i==120)
					throw new IOException();
				if(i==30)
					return;
				if(i==10)
					throw new UserException(" when i is 10");
				if(i==80)
					throw new UserException(" when i is 8");
			}
		
	}
	public void xyz() throws ArithmeticException, IOException, UserException
	{
		abc();
	}
	public void atoz() throws ArithmeticException, IOException, UserException
	{
		xyz();
	}
}
public class ExceptionHandling
{
	public static void main(String args[])
	{
		try
		{
			A a1 = new A();
			a1.atoz();
		}
		catch(IOException e)
		{
			System.out.println("IO Exception occured....");
		}
		catch(NullPointerException e)
		{
			System.out.println("NULL Exception occured....");
		}
		catch(UserException ue)
		{
			System.out.println("Custom exception handler....");
			System.out.println("Reason : "+ue.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Default exception handler....");
		}
		finally
		{
			System.out.println("THANKS");
		}		System.out.println("Program continues.....");
	}
}
class UserException extends Exception
{
	public UserException()
	{
	}
	public UserException(String msg)
	{
		super(msg);
	}
	public void display()
	{
		System.out.println("Just for Demo");
	}
}