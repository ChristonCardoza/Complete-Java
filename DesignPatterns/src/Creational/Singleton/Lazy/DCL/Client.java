package Creational.Singleton.Lazy.DCL;

public class Client {

	public static void main(String[] args) {

		LazyRegistryWithDCL lazyRegistryWithDCL1 = LazyRegistryWithDCL.getInstance();
		LazyRegistryWithDCL lazyRegistryWithDCL2 = LazyRegistryWithDCL.getInstance();

		System.out.println(lazyRegistryWithDCL1 == lazyRegistryWithDCL2);
	}

}
