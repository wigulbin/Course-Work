
public class F2C_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * The following statement does 2 things:
		 * 1. It declares fahrenheit to be of type double
		 * 2. It initializes fahrenheit with value 45.5
		 */

		// read fahrenheit value from user
		System.out.print("Enter Fahrenheit value =>");
		double fahrenheit=IO.readDouble();

		//accept only values that are >= -459.67 (absolute zero)

		// Version 1
		while(fahrenheit < -459.67){			//If statements are only true or false
			System.out.println("Value must be >= -459.67");
			System.out.print("Enter fahrenheit value => ");
			fahrenheit=IO.readDouble();
		}
		
		double celsius=(fahrenheit-32)*5/9;
		System.out.println("celsius=" + celsius); // + here stands for concatenation

	}
}



