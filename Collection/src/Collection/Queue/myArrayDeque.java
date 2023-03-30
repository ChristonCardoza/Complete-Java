package Collection.Queue;

import java.util.ArrayDeque;

public class myArrayDeque {
    public static void main(String[] args) {

        ArrayDeque<Integer> myArrayDeque = new ArrayDeque<>();

        myArrayDeque.offer(29);
        System.out.println("Element of ArrayDeque after offering 29: "+ myArrayDeque);

        myArrayDeque.offerFirst(12);
        System.out.println("Element of ArrayDeque after offeringFirst 12: "+ myArrayDeque);

        myArrayDeque.offerLast(45);
        System.out.println("Element of ArrayDeque after offeringLat 45: "+ myArrayDeque);

        myArrayDeque.offer(23);
        System.out.println("Element of ArrayDeque after offering 23 : "+ myArrayDeque);

        System.out.println("Peeking Element of ArrayDeque : "+ myArrayDeque.peek());
        System.out.println("PeekingFirst Element of ArrayDeque : "+ myArrayDeque.peekFirst());
        System.out.println("PeekingLast Element of ArrayDeque : "+ myArrayDeque.peekLast());

        myArrayDeque.poll();
        System.out.println("Element of ArrayDeque after poll : "+ myArrayDeque);

        myArrayDeque.pollFirst();
        System.out.println("Element of ArrayDeque after pollingFirst : "+ myArrayDeque);

        myArrayDeque.pollLast();
        System.out.println("Element of ArrayDeque after pollingLast : "+ myArrayDeque);

    }
}
