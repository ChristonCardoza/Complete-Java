public class LangDemo3
{
	public static void main(String args[]) throws Exception
	{
		Runtime rt = Runtime.getRuntime();

		System.out.println("Wait for 10 sec and see the magic....");
		Thread.sleep(10000);
		Process p1 = rt.exec("calc.exe");	
		Thread.sleep(5000);
		Process p2 = rt.exec("mspaint.exe");	
		Thread.sleep(5000);
		Process p3 = rt.exec("notepad.exe");	

		Thread.sleep(10000);
		p3.destroy();
		Thread.sleep(5000);
		p2.destroy();
	}
}