import java.util.*;

public class UtilDemo
{
	public static void main(String args[])
	{
		Date d1 = new Date();
		System.out.println(d1);
		Date d2 = new Date();
		d2.setTime(-232348988);
		System.out.println(d2);

		System.out.println(d1.before(d2));
		System.out.println(d1.after(d2));
		System.out.println(d1.equals(d2));

		d1.setMonth(55);
		System.out.println(d1);

		System.out.println("------------------");

		String str = "Raju|25:20000,Clerk;Bangalore|raju@abc.com";
		
		StringTokenizer st = new StringTokenizer(str, "|,;:");
		int count = st.countTokens();
		for(int i=0; i<count; i++)
		{
			System.out.println(st.nextToken());
		}

		System.out.println("------------------");

		BitSet b1 = new BitSet(16);
		BitSet b2 = new BitSet(16);

		for(int i=0; i<16; i++)
		{
			if(i%3==0)
				b1.set(i);
			if(i%4==0)
				b2.set(i);
		}

		System.out.println(b1);
		System.out.println(b2);
		//b1.and(b2);
		//b1.or(b2);
		b1.xor(b2);
		System.out.println(b1);

		System.out.println("------------------");

		Stack s1 = new Stack();

		s1.push("111");
		s1.push("222");
		s1.push("333");
		s1.push("444");
		s1.push("555");

		//System.out.println(s1.pop());
		//System.out.println(s1.pop());
		//System.out.println(s1.pop());

		//System.out.println(s1.peek());
		//System.out.println(s1.peek());
		//System.out.println(s1.peek());

		System.out.println(s1.search("666"));
		System.out.println(s1.empty());

		System.out.println("------------------");

		Vector v1 = new Vector(2);
		
		v1.add("HELLO");
		v1.add(new Integer(234234));
		v1.add(new Thread());
		v1.add(new Date());
		v1.add(new StringBuffer("THANKS"));

		Enumeration e = v1.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}		
	}
}