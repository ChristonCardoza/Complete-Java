class A{
	final int x= 10;
	final public void abc(){
		System.out.println("Hi");
	}
	
}

final class B extends A{
	
	/*final public void abc(){
		System.out.println("Hello");
	}*/
	
}
class c // extends B
{
	
}

public class Final{
	public static void main(String args[]){
		
		 A a1 = new A();
		 //a1.x = 50;
		 System.out.println(a1.x);
		 
		 B b1 = new B();
		 b1.abc();
	}
	
}