public class AArray{
	
	public static void main(String args[]){
		
		int a[] = new int[5];
		int[] b;
		
		int arr[] = {11,22,33,44,55};
		
		for(int i=0;i<arr.length;i++){
			
			System.out.println(arr[i]);
		}
		System.out.println("-------------------------");
		for(int x:arr){
			
			System.out.println(x);
		}
		System.out.println("-------------------------");
		
		for(int i=0;i<args.length;i++){
			
			System.out.println(args[i]);
		}
		System.out.println("-------------------------");
		for(String str:args){
			
			System.out.println(args);
		}
		System.out.println("-------------------------");
		
		
		int md[][] = new int[6][];
		md[0] = new int[4];
		md[1] = new int[4];
		md[2] = new int[4];
		md[3] = new int[4];
		md[4] = new int[4];
		md[5] = new int[4];
		
		for(int i=0;i<md.length;i++){
			
			for(int j=0;j<md[i].length;j++){
			
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
		
		Emp e[] = new Emp[5];
		String user[] = {"Geeta","Seeta","Reeta","Meeta","Neeta"};
		
		for(int i=0;i<e.length;i++){
			
			e[i] = new Emp();
			e[i].name = user[i];
			
		}
		
		for(int i=0;i<e.length;i++){
			
			System.out.print("Name: "+e[i].name);
			
		}
		System.out.println("-------------------------");
		
		for(Emp emp:e){
			
			System.out.print(emp.name);
		}
		
		

	}
}

class Emp{
	
	String name;
}





