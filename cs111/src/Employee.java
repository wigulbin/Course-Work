
public class Employee {

	private String firstName;
	private String lastName;
	private int rate;
	private double balance;
	
	public Employee(String fName, String lName, int Rate, double Balance){
		firstName = fName;
		lastName = lName;
		rate = Rate;
		balance = Balance;
	}
	
	public Employee(String fName, String lName, int Rate){
		firstName = fName;
		lastName = lName;
		rate = Rate;
		balance = 0;
	}
	
	public void work(int hours){
		balance += rate*hours;
	}
	
	public void spend(double money){
		balance -= money;
	}
	
	public int salary(int hoursPerWeek){
		return (52*rate*hoursPerWeek);
	}
	
	public double bonus(double percent, int hoursPerWeek){
		int salary = this.salary(hoursPerWeek);
		
		return salary*(percent/100.00);
	}
	
	
	public void printInfo(){
		System.out.println("Name: "+ firstName + " " + lastName);
		System.out.println("Rate: " + rate);
		System.out.println("Balance: " + balance);
	}
}
