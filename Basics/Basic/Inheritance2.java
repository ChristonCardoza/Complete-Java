class A{
	
	int x = 10;
	public void abc()
	{
		System.out.println("Hi");
	}
}

class B extends A{
	
	int x = 20;
	
	public void abc()
	{
		System.out.println("Hello");
	}
	public void xyz()
	{
		System.out.println(super.x);
		System.out.println(x);
		super.abc();
		abc();
	}
}


public class Inheritance2{
	
	public static void main(String args[]){
		
		
		B b1 = new B();
	
		b1.xyz();
		
		
	}
}