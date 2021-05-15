import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class myProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Properties myProperty = new Properties();
		
		File file = new File("F:/Java-Collection/Map/HashTable/myProperty.properties");
		FileInputStream fis;
		FileOutputStream fos;
		try {
			fis = new FileInputStream(file);
			Properties myProperty = new Properties();
			myProperty.load(fis);
			System.out.println("Elements in  property file are: "+myProperty);
			System.out.println("The value of fname is : "+myProperty.getProperty("fname"));
			myProperty.setProperty("age", "25");
			System.out.println("Adding New property in  property object: "+myProperty);
			fos = new FileOutputStream(file);
			myProperty.store(fos, "Added Age by DeadMAn");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
