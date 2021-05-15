import java.util.Iterator;
import java.util.LinkedList;

public class myLinkedList {

	public static void main(String[] args) {
		
		LinkedList myList = new LinkedList();
		
	    myList.add('A');
        myList.add('A');
        myList.add('A');
        myList.add(null);
        myList.add(true);
        myList.add(false);
        myList.add(6);
        
        System.out.print("The Entered LinkedList elements are : ");
        System.out.println(myList);
        
        System.out.print("Removed 2nd Index from LinkedList : ");
        myList.remove(1);
        System.out.println(myList);
        
        System.out.print("Adding value for 2nd Index from LinkedList : ");
        myList.add(1,'A');
        System.out.println(myList);
        
        System.out.printf("\nValue of 2nd Index from myList : " + myList.get(1));
        System.out.printf("\nFirst occurance of value 'A' from myList at index : " + myList.indexOf('A'));
        System.out.printf("\nLast occurance of value 'A' from myList at index : " + myList.lastIndexOf('A'));
        myList.addFirst(1);
        System.out.printf("\nAdding value for first of LinkedList : ");
        System.out.println(myList);
        myList.addLast(100);
        System.out.printf("\nAdding value for last of LinkedList : ");
        System.out.println(myList);
        myList.removeFirst();
        System.out.printf("\nRemoving value for first of LinkedList : ");
        System.out.println(myList);
        myList.removeLast();
        System.out.printf("\nRemoving value for last of LinkedList : ");
        System.out.println(myList);
        System.out.printf("\nSize of myList : " + myList.size() + "\n");
        
        System.out.println("\nIterating through Iterator");
        Iterator itr = myList.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }

	}

}
