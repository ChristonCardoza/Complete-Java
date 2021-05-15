package Christon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
	
	public static void main(String[] args) {
	
//		Airtel airtel = new Airtel();
//		airtel.calling();
//		airtel.data();
		
//		Bsnl bsnl = new Bsnl();
//		bsnl.calling();
//		bsnl.data();
		
//		Sim sim = new Airtel();
//		sim.calling();
//		sim.data(); 
//		 
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Sim sim = context.getBean("Sim",Sim.class);
		sim.calling();
		sim.data();
		
	
	}

}
