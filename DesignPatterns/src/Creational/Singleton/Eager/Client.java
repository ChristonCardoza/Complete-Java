package Creational.Singleton.Eager;

public class Client {

	public static void main(String[] args) {

		EagerRegistry registry1 = EagerRegistry.getInstance();
		EagerRegistry registry2 = EagerRegistry.getInstance();

		System.out.println(registry1 == registry2);

	}

}
