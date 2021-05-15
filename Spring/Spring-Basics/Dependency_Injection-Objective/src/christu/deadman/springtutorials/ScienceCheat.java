package christu.deadman.springtutorials;

public class ScienceCheat {
	
	static int count = 0;
	
	ScienceCheat(){
		
		count+=1;
	}
	
	public void scienceCheat() {
		System.out.println("The Science Cheats are created");
	}
	
	public void objectCountt() {

		System.out.println("The Number of objected  created for ScienceCheats is : "+count);
	}

}
