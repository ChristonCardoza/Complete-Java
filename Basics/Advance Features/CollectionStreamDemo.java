import java.util.*;
import java.util.stream.*;

public class CollectionStreamDemo
{
	public static void main(String args[])
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(88);
		list.add(22);
		list.add(11);
		list.add(null);
		list.add(66);
		list.add(99);
		list.add(null);
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(null);
		list.add(55);

		System.out.println(list);
		/*
		List<Integer> l1 = list.stream().filter(x->x%2==0).collect(Collectors.toList());
		System.out.println(l1);

		List<Integer> l2 = list.stream().map(x->x+x).collect(Collectors.toList());
		System.out.println(l2);

		
		List<Integer> l3 = list.stream().takeWhile(x->x%2==0).collect(Collectors.toList());
		System.out.println(l3);

		List<Integer> l4 = list.stream().dropWhile(x->x%2==0).collect(Collectors.toList());
		System.out.println(l4);

		Stream.iterate(1, x->x<100 ,x->x+1).forEach(System.out::println);
		*/

		List<Integer> l5 = list.stream().flatMap(e->Stream.ofNullable(e)).collect(Collectors.toList());
		System.out.println(l5);
	}
}