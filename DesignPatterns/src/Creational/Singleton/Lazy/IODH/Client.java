package Creational.Singleton.Lazy.IODH;

public class Client {

	public static void main(String[] args) {

		LazyRegistryIODH singleton;
		singleton = LazyRegistryIODH.getInstance();

		singleton = LazyRegistryIODH.getInstance();
		singleton = LazyRegistryIODH.getInstance();
		singleton = LazyRegistryIODH.getInstance();
	}

}
