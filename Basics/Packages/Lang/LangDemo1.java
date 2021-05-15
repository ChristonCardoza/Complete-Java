public class LangDemo1
{
	public static void main(String args[])
	{
		String s1 = "Hello";
		String s2 = s1.toUpperCase();
		System.out.println(s1);
		System.out.println(s2);

		StringBuffer sb = new StringBuffer("Hi");
		sb.append("Hello");
		System.out.println(sb);

		String str1 = "Hi";
		String str2 = "Hi";

		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

		StringBuffer sb1 = new StringBuffer("Hi");
		StringBuffer sb2 = new StringBuffer("Hi");

		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());

		System.out.println("---------------------");

		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println(Math.sqrt(25));
		System.out.println(Math.cbrt(30));
		System.out.println(Math.pow(3, 5));
		System.out.println(Math.ceil(3.1));
		System.out.println(Math.floor(3.9));
		System.out.println(Math.round(3.5));

		System.out.println("---------------------");

		int a = 100;
		Integer i = a;
		System.out.println(i);
		System.out.println(Integer.toHexString(i));
		System.out.println(Integer.toOctalString(i));
		System.out.println(Integer.toBinaryString(i));
		String s = "1050";
		System.out.println(Integer.parseInt(s)+50);
		System.out.println(i.toString()+10);

		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
}