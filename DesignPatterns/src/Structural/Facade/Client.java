package Structural.Facade;

//import Structural.Facade.email.Email;
//import Structural.Facade.email.Mailer;
//import Structural.Facade.email.Stationary;
//import Structural.Facade.email.StationaryFactory;
//import Structural.Facade.email.Template;
//import Structural.Facade.email.Template.TemplateType;
//import Structural.Facade.email.TemplateFactory;

import Structural.Facade.email.EmailFacade;

public class Client {

	public static void main(String[] args) {
		Order order = new Order("101", 99.99);

//		boolean result = sendOrderEmailWithoutFacade(order);
//
//		System.out.println("Order Email "+ (result?"sent!":"NOT sent..."));

		EmailFacade facade = new EmailFacade();
		boolean result = facade.sendOrderEmail(order);
		System.out.println("Order Email "+ (result?"sent!":"NOT sent..."));

	}

//	private static boolean sendOrderEmailWithoutFacade(Order order) {
//		Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
//		Stationary stationary = StationaryFactory.createStationary();
//		Email email = Email.getBuilder()
//					  .withTemplate(template)
//					  .withStationary(stationary)
//					  .forObject(order)
//					  .build();
//		Mailer mailer = Mailer.getMailer();
//		return mailer.send(email);
//	}

}
