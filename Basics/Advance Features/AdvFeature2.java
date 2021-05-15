class A implements AutoCloseable
{
	
	public void display(){
		
		System.out.println("Just for Demo class A");
	}
	
	public void close(){
		
		System.out.println("Releaseing resourcess....of class A");
	}
}

public class AdvFeature2{
	public static void main(String[] args){
		try(A a1 = new A();){
			
			a1.display();
		}
		System.out.println("Main Exit");
	}
}