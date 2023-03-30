package Collection.Lists;

import java.util.Enumeration;
import java.util.Vector;

public class myVector {

	public static void main(String[] args) {

		Vector myList = new Vector();

		myList.add('A');
        myList.add('A');
        myList.add('A');
        myList.add(null);
        myList.add(true);
        myList.add(false);
        myList.add(6);

        System.out.print("The Entered Vector elements are : ");
        System.out.println(myList);

        myList.addElement(1);
        System.out.print("The Adding Vector elements 1 : ");
        System.out.println(myList);

        myList.removeElement('A');
        System.out.print("The Removing Vector elements 'A' : ");
        System.out.println(myList);

        System.out.printf("\nFirst Element of myList : " + myList.firstElement());
        System.out.printf("\nLast Element of myList : " + myList.lastElement());
        System.out.printf("\nSpecific 2 Element of myList : " + myList.elementAt(2));
        System.out.printf("\nSize of myList : " + myList.size());
        System.out.printf("\nCapacity of myList : " + myList.capacity());

        System.out.println("\n\nIterating through Enumerator: \n");
        Enumeration e = myList.elements();
        while(e.hasMoreElements()) {
        	System.out.println(e.nextElement());
        }

	}

}
