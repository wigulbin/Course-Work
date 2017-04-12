
public class AdditivePersistence {
	public static int sumDigits(int number) {  // input parameter number of type int
		int sum=0;
		while(number >=10){
		sum += number % 10;
		number /=10;
		}
		sum += number;
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = getNumber();

		int count=0;
		int n = number;
		while (number >= 10){
			count++;
			number = sumDigits(number);
		}
		System.out.println("Additive persistence of " + n + " = " + count + ", digital root = " + number);
	}

	public static int getNumber() {
		int number=0;
		do{
			System.out.print("Enter a positive integer: ");
			number=IO.readInt();
		}while(number <= 0);
		return number;
	}

}
