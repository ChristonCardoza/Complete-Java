class Calc{
	public void add(int... a){
		int res = 0;
		for(int i=0;i<a.length;i++){
			res = res+a[i];
		}
		System.out.println("Result: "+res);
	}
}
public class AdvFeature1{
	public static void main(String[] args){
		Calc c = new Calc();
		c.add(10,20);
		c.add();
		c.add(10,20,30,40);
		c.add(10);
	}
}