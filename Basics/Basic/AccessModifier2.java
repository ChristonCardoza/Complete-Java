import p1.AccessModifier1;
class D{
	
		public void display()
		{
			AccessModifier1 a1 = new AccessModifier1();
			System.out.println(a1.x);
			//System.out.println(a1.y);
			//System.out.println(a1.z);
			//System.out.println(a1.q);
		}
}
class E extends AccessModifier1{
	
		public void display()
		{
			System.out.println(x);
			//System.out.println(y);
			System.out.println(z);
			//System.out.println(q);
		}
}
class F extends E{
	
		public void display()
		{
			System.out.println(x);
			//System.out.println(y);
			System.out.println(z);
			//System.out.println(q);
		}
}