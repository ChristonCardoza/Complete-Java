package p1;

public class AccessModifier1{
	
		public int x;
		private int y;
		protected int z;
		int q;
		public void display()
		{
			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
			System.out.println(q);
		}
}

class B extends AccessModifier1{
	
		public void display()
		{
			System.out.println(x);
			//System.out.println(y);
			System.out.println(z);
			System.out.println(q);
		}
}
class C{
	
		public void display()
		{
			AccessModifier1 a1 = new AccessModifier1();
			System.out.println(a1.x);
			//System.out.println(a1.y);
			System.out.println(a1.z);
			System.out.println(a1.q);
		}
}

