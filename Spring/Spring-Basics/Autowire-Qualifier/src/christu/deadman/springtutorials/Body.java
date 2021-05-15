package christu.deadman.springtutorials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Body {
	public static void main(String[] args) {
		
//		Human human = new Human();
//		Heart heart = new Heart();
//		human.setHeart(heart);
//		human.startPumping();
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Human human = context.getBean("human",Human.class);
		human.startPumping();
		
		
		
	}

}
