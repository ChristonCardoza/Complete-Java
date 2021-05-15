class A{
	A(){
		System.out.println("A()");
	}
	A(String s){
		this();
		System.out.println("A(String)");
	}
	
}

class B extends A{
	B(){
		super("abc");
		System.out.println("B()");
	}
	B(String s){
		this();
		System.out.println("B(String)");
	}
	
	
}

public class Inheritance3{
	
	public static void main(String args[]){
			
		B b1 = new B("abc");
		
	}
}