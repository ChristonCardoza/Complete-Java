import java.util.*;

public class CollectionDemo3
{
	public static void main(String args[])
	{
		LinkedList<Object> obj = new LinkedList<Object>();

		obj.add("222");		
		obj.add(555);		
		obj.add("333");		
		obj.add(new Date());		
		obj.add("444");		

		Iterator i = obj.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}

		HashMap<Integer, String> mobj = new HashMap<Integer, String>();

		mobj.put(111, "Rajesh");
		mobj.put(323, "Raju");
		mobj.put(343, "adsa");


	}
}