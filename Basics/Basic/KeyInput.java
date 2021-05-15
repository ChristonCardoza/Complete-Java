import java.util.Scanner;
public class KeyInput{
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter full name: ");
		//String name = sc.next();
		String name = sc.nextLine();
		
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		
		System.out.println("Married?: ");
		boolean married = sc.nextBoolean();
		
		
		System.out.println("---------------------------------------------------" );
		System.out.println("Your good name is:" +name );
		System.out.println("Your age after 10 years:" +age );
		System.out.println("Your marital status is:" +married );
	}
}