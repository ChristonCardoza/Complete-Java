package Map.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class myHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap myMap = new HashMap();

		myMap.put("String", 'A');
		myMap.put("Boolean", false);
		myMap.put("Integer", 3);
		myMap.put(null, null);

		System.out.print("The Entered HashMap elements are : ");
        System.out.println(myMap);

        Set k = myMap.keySet();
        System.out.println("The All Keys of HashMap elements are : " + k);

        Collection v = myMap.values();
        System.out.println("The All Values of HashMap elements are : " + v);

        Set e = myMap.entrySet();
        System.out.println("The EntrySet of HashMap elements are : " + e);

        System.out.println("Getting the Keys of EntrySet from HashMap elements are : " );

        Iterator itr = e.iterator();
        while(itr.hasNext()) {
        	Map.Entry  m = (Map.Entry)itr.next();
        	System.out.println(m.getKey()+"-"+m.getValue());
        	if(m.getKey().equals("String")) {
        		m.setValue("Welcome To Hell");
        	}
//        	System.out.println(m);
        }
        System.out.println(myMap);

	}

}
