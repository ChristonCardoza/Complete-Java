import java.util.PriorityQueue;

public class myPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue myQueue = new PriorityQueue();
		
		System.out.println("Head Element of Empty Queue : "+ myQueue.peek());
		
		
		myQueue.add(11);
		System.out.println("Head Element of Queue : "+ myQueue.element());
		
		for(int i=1; i<=10; i++) {
			myQueue.offer(i);
		}
		
		for(int i=5; i<=10; i++) {
			myQueue.offer(i);
		}
		
		System.out.println("Element of Queue : "+ myQueue);
		
		System.out.println("Head Element of Empty Queue : "+ myQueue.peek());
		
		System.out.println("Removing and returning HeadElement of Queue : "+ myQueue.poll());
		
		System.out.println("Element of Queue : "+ myQueue);
		
//		myQueue.add('A');
//		myQueue.add(null);

	}

}
