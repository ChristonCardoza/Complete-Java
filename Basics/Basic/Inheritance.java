class A{
	
	int x = 10;
	public void abc()
	{
		System.out.println("Hi");
	}
}

class B extends A{
	
	int y = 20;
	public void xyz()
	{
		System.out.println("Hello");
	}
}

class C extends A{
	
	int z = 30;
	public void atoz()
	{
		System.out.println("Thanks");
	}
}

public class Inheritance{
	
	public static void main(String args[]){
		
		A a1 = new A();
		System.out.println(a1.x);
		a1.abc();
		System.out.println("--------------");
		B b1 = new B();
		System.out.println(b1.x);
		System.out.println(b1.y);
		b1.abc();
		b1.xyz();
		System.out.println("--------------");
		C c1 = new C();
		System.out.println(c1.x);
		System.out.println(c1.z);
		c1.abc();
		c1.atoz();
		System.out.println("--------------");
		
	}
}