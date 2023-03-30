package Collection.Sets;

import java.util.HashSet;
import java.util.Iterator;

public class myHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet mySet = new HashSet();

		mySet.add('A');
		mySet.add('A');
		mySet.add('A');
		mySet.add(null);
		mySet.add(true);
		mySet.add(false);
		mySet.add(6);

        System.out.print("The Entered Hashset elements are : ");
        System.out.println(mySet);
        mySet.remove('A');
        System.out.print("Removed Object 'A' from Hashset : ");
        System.out.println(mySet);

        System.out.printf("Hashcode from Hashset : "+  mySet.hashCode());
        System.out.printf("\nSize of mySet : " + mySet.size());

        System.out.println("\n\nIterating through Iterator: \n");
        Iterator itr = mySet.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }




	}

}
