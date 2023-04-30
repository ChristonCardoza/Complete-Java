package basics;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;


//@Component
@Named
class BusinessService {
	private DatabaseService dataService;

	//@Autowired
	@Inject
	public void setDataService(DatabaseService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}


	public DatabaseService getDataService() {
		return dataService;
	}



}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

	public static void main(String[] args) {

		try (var context =
				new AnnotationConfigApplicationContext
					(CdiContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);

			System.out.println(context.getBean(BusinessService.class)
					.getDataService());

		}
	}
}
