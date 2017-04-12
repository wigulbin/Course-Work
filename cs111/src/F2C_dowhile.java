
public class F2C_dowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * The following statement does 2 things:
		 * 1. It declares fahrenheit to be of type double
		 * 2. It initializes fahrenheit with value 45.5
		 */

		// read fahrenheit value from user
		
		double fahrenheit=0;
		do{
			System.out.print("Enter Fahrenheit value =>");
			fahrenheit=IO.readDouble();
		}while (fahrenheit < -459.67);
		
		double celsius=(fahrenheit-32)*5/9;
		System.out.println("celsius=" + celsius); // + here stands for concatenation

	}
}