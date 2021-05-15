import java.util.*;

public class MapDemo
{
	public static void main(String args[])
	{
		//Hashtable obj = new Hashtable();
		//HashMap obj = new HashMap();
		//TreeMap obj = new TreeMap();
		LinkedHashMap obj = new LinkedHashMap();

		obj.put("444", "Suresh");
		obj.put("222", "Rakesh");
		obj.put("666", "Rajesh");
		obj.put("333", "Rajesh");
		obj.put("111", "Ramesh");
		obj.put("555", "Mahesh");

		Set s = obj.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}