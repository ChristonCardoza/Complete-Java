class A{
	public void abc()
	{
		System.out.println("Hi");
	}
	
}

class B extends A{
	public void abc()
	{
		System.out.println("Hello");
	}
	
	
}

class C extends B{
	public void abc()
	{
		System.out.println("Thanks");
	}
	
	
}

public class RunTimePolymorphism{
	
	public static void main(String args[]){
			
		A a1 = new A();
		a1.abc();
		a1 = new B();
		a1.abc();
		a1 = new C();
		a1.abc();
		
	}
}