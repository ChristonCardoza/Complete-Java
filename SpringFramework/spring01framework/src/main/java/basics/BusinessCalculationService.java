package basics;

import java.util.Arrays;

import org.springframework.stereotype.Service;

//@Component
@Service
public class BusinessCalculationService {

	private DatabaseService dataService;

	public BusinessCalculationService(DatabaseService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

}
