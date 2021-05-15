package christu.deadman.springtutorials;

public class MathCheat {
	
	static int count = 0;
	
	MathCheat(){
		
		count+=1;
	}
	
	public void mathCheat() {

		System.out.println("The Math Cheats are created");
	}
	
	public void objectCountt() {

		System.out.println("The Number of objected  created for MathCheats is : "+count);
	}
	
}
