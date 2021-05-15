import java.util.SortedMap;
import java.util.TreeMap;

public class mySortedMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedMap myMap = new TreeMap();
//		myMap.put(null, null);
		
		myMap.put(103,103);
		myMap.put(104,104);
		myMap.put(100,100);
		myMap.put(107,107);
		myMap.put(109,109);
		myMap.put(101,101);
		myMap.put(102,102);
		myMap.put(105,105);
		myMap.put(106,106);
		myMap.put(110,110);
		
//		myMap.put(null,null);
        
        System.out.print("The Entered Sortedset elements are : ");
        System.out.println(myMap);
        
        System.out.printf("\nThe First element of the sorted set : "+ myMap.firstKey());
        System.out.printf("\nThe Last element of the sorted set : "+ myMap.lastKey());
        System.out.printf("\nElements of the sorted set < 105 : "+ myMap.headMap(105));
        System.out.printf("\nElements of the sorted set >= 105 : "+ myMap.tailMap(105));
        System.out.printf("\nElements of the sorted set 103=<> 107 : "+ myMap.subMap(103,107));
    
	}

}
