package Collection.Lists;

import java.util.Stack;

public class myStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack myList = new Stack();

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

        myList.push('A');
        System.out.print("Puting / Inserting object  'A'  to the stack: ");
        System.out.println(myList);

        myList.pop();
        System.out.print("Poping / Deleting object  to the stack: ");
        System.out.println(myList);

        System.out.printf("Peek / Last inserted object  to the stack: "+ myList.peek());

        System.out.printf("\nSearch object 'A'  to the stack: "+ myList.search('A'));
        System.out.printf("\nSearch object '10'  to the stack: "+ myList.search(10));

	}

}
