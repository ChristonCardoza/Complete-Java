package christu.deadman.springtutorials;

public class AnotherStudent {
	
	private int studentId;
	private MathCheat MathCheat;
	private ScienceCheat ScienceCheat;

	public void setScienceCheat(ScienceCheat scienceCheat) {
		ScienceCheat = scienceCheat;
		System.out.println("he set the ScienceCheat object for ANOTHER-STUDENT");
	}

	public void setMathCheat(MathCheat mathCheat) {
		this.MathCheat = mathCheat;
		System.out.println("The set the  MathCheat Object for ANOTHER-STUDENT");
	}

	public void setstudentId(int studentId) {
		this.studentId = studentId;
		System.out.println("The set the ID for ANOTHER-STUDENT");
	}

	public void cheating() {

		MathCheat.mathCheat();
		ScienceCheat.scienceCheat();
		System.out.println("The student Id for ANOTHER-STUDENT is : " + studentId);
		MathCheat.objectCountt();
		ScienceCheat.objectCountt();
	}

}
