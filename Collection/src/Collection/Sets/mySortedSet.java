package Collection.Sets;

import java.util.SortedSet;
import java.util.TreeSet;

public class mySortedSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortedSet mySet = new TreeSet();

//		mySet.add(null);

		mySet.add(103);
		mySet.add(104);
		mySet.add(100);
		mySet.add(107);
		mySet.add(109);
		mySet.add(101);
		mySet.add(102);
		mySet.add(105);
		mySet.add(106);
		mySet.add(110);

//		mySet.add(null);

        System.out.print("The Entered Sortedset elements are : ");
        System.out.println(mySet);

        System.out.printf("\nThe First element of the sorted set : "+ mySet.first());
        System.out.printf("\nThe Last element of the sorted set : "+ mySet.last());
        System.out.printf("\nElements of the sorted set < 105 : "+ mySet.headSet(105));
        System.out.printf("\nElements of the sorted set >= 105 : "+ mySet.tailSet(105));
        System.out.printf("\nElements of the sorted set 103=<> 107 : "+ mySet.subSet(103,107));

	}

}
