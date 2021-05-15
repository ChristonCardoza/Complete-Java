import java.util.TreeSet;

public class myNavigableSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet <Integer> mySet = new TreeSet<Integer>();
		
		mySet.add(1000);
		mySet.add(2000);
		mySet.add(3000);
		mySet.add(4000);
		mySet.add(5000);
		
		 System.out.print("The Entered Navigableset elements are : ");
	     System.out.println(mySet);
	     System.out.println("\nThe ceiling of 2000 : "+mySet.ceiling(2000));
	     System.out.println("\nThe floor of 2000 : "+mySet.floor(2000));
	     System.out.println("\nThe higher of 2000 : "+mySet.higher(2000));
	     System.out.println("\nThe lower of 2000 : "+mySet.lower(2000));
	     System.out.println("\nThe poll first : "+mySet.pollFirst());
	     System.out.println("\nThe poll last : "+mySet.pollLast());
	     System.out.println("\nElements after polling : "+mySet);
	     System.out.println("\nThe descending  : "+mySet.descendingSet());
	}

}
