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

class C extends A{
	
	public void abc()
	{
		System.out.println("Thanks");
	}
}

public class Inheritance1{
	
	public static void main(String args[]){
		
		A a1 = new A();
		a1.abc();
		System.out.println("--------------");
		B b1 = new B();
		b1.abc();
		System.out.println("--------------");
		C c1 = new C();
		c1.abc();
		System.out.println("--------------");
		
	}
}