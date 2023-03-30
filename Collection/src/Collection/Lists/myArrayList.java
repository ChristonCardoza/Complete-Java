package Collection.Lists;

import java.util.ArrayList;
import java.util.Iterator;

class myArrayList {
    public static void main(String[] args) {

        ArrayList myList = new ArrayList();
        ArrayList myList2 = myList;

        myList.add('A');
        myList.add('A');
        myList.add('A');
        myList.add(null);
        myList.add(true);
        myList.add(false);
        myList.add(6);

        System.out.print("The Entered Araylist elements are : ");
        System.out.println(myList);

        System.out.print("Removed 2nd Index from Araylist : ");
        myList.remove(1);
        System.out.println(myList);

        System.out.print("Adding value for 2nd Index from Araylist : ");
        myList.add(1,'A');
        System.out.println(myList);

        System.out.println("If myList2 created from myList then both myList and MyList2 referes tp same object : ");
        System.out.print("If myList2");
        System.out.println(myList2);
        System.out.print("If myList");
        System.out.println(myList);

        System.out.print("Removed 2nd Index from myList2 : ");
        myList2.remove(1);
        System.out.print(myList);
        System.out.print(" myList == myList2  ");
        System.out.print(myList2);

        myList.add(1,'A');

        System.out.printf("\nValue of 2nd Index from myList : " + myList.get(1));
        System.out.printf("\nFirst occurance of value 'A' from myList at index : " + myList.indexOf('A'));
        System.out.printf("\nLast occurance of value 'A' from myList at index : " + myList.lastIndexOf('A'));
        System.out.printf("\nSize of myList : " + myList.size() + "\n");

        System.out.println("Iterating through Iterator");
        Iterator itr = myList.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }

        ArrayList myList3 = new ArrayList();
        for (int i=0; i<10; i++) {
        	myList3.add(i);
        }
        System.out.printf("Value of myList3 : " + myList3 + "\n" );

        Iterator itr1 = myList3.iterator();
        while(itr1.hasNext()) {
        	Integer n = (Integer) itr1.next();
        	if(n%2 == 0) {
        		System.out.println(n);
        	}else {
        		itr1.remove();
        	}
        }

        System.out.printf(" Iterator can do remove operation, value which are non-divisible by 2 is removed: " + myList3);



    }
}