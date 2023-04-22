package Behavioral.NullObject;

public class Client {

	public static void main(String[] args) {
//		ComplexService service = new ComplexService("Simple report",new StorageService());
		ComplexService service = new ComplexService("Simple report2",new NullStorageService());
		service.generateReport();

	}

}
