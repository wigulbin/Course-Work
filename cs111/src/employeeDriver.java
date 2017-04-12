
public class employeeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee("Julio", "Patel", 15, 1500.00);
		Employee emp2 = new Employee("Jeff", "Winger", 20);
		
		emp1.printInfo();
		System.out.println();
		emp2.printInfo();
		System.out.println("-------------------------------");
		
		emp1.work(5);
		emp2.work(10);
		
		int emp1Salary = emp1.salary(40);
		
		System.out.println(emp1Salary);
		
		emp1.bonus(50, 7);
	}
	int a=0; String b, c, d;

}
