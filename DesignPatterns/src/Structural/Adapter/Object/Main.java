package Structural.Adapter.Object;

public class Main {

	public static void main(String[] args) {
		/** Using Object Adapter **/
		Employee employee = new Employee();
		populateEmployeeData(employee);
		EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
		BusinessCardDesigner designer = new BusinessCardDesigner();
		String card = designer.designCard(objectAdapter);
		System.out.println(card);

	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("Elliot Alderson");
		employee.setJobTitle("Security Engineer");
		employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
}
