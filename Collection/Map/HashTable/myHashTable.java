import java.util.Hashtable;

public class myHashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable myTable = new Hashtable();
		
		myTable.put(new Temp(5),'A');
		myTable.put(new Temp(2),'B');
		myTable.put(new Temp(15),'C');
		myTable.put(new Temp(25),'F');
		myTable.put(new Temp(5),'E');
		
		System.out.print("The Entered Hashtable elements are : ");
        System.out.println(myTable);
        System.out.println("The Hashcode is "+myTable.hashCode());
				

	}

}

class Temp {
	
	int i;
	
	Temp (int i){
		this.i = i;
	}
	
	public int hashcode() {
		return i;
	}
	
	public String toString() {
		return i + " ";
	}
}
