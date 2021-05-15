import java.util.*;

public class CollectionDemo2
{
	public static void main(String args[])
	{
		LinkedList obj = new LinkedList();

		obj.add("222");		
		obj.add("555");		
		obj.add("333");		
		obj.add("111");		
		obj.add("444");		
		obj.add("777");		
		obj.add("000");
		obj.add("666");

		Collections.sort(obj);
		//Collections.reverse(obj);
		//Collections.shuffle(obj);
		Collections.swap(obj, 2, 5);

		Iterator i = obj.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}