import java.util.TreeMap;

public class myNavigableMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeMap <Integer,String> mySet = new TreeMap<Integer,String> ();
		
		mySet.put(1000,"Banana");
		mySet.put(2000, "Cat");
		mySet.put(3000, "Apple");
		mySet.put(4000,"Dog");
		mySet.put(5000,"Gun");
		
		 System.out.print("The Entered Navigableset elements are : ");
	     System.out.println(mySet);
	     System.out.println("\nThe ceiling of 2000 key: "+mySet.ceilingKey(2000));
	     System.out.println("\nThe floor of 2000 key : "+mySet.floorKey(2000));
	     System.out.println("\nThe higher of 2000 key: "+mySet.higherKey(2000));
	     System.out.println("\nThe lower of 2000 key : "+mySet.lowerKey(2000));
	     System.out.println("\nThe poll first entry : "+mySet.pollFirstEntry());
	     System.out.println("\nThe poll last entry: "+mySet.pollLastEntry());
	     System.out.println("\nElements after polling : "+mySet);
	     System.out.println("\nThe descending map : "+mySet.descendingMap());

	}

}
