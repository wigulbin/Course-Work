
public class MaximumV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter termination number: ");
		int terminator = IO.readInt();

		System.out.println("Enter number, or terminator: ");
		int number=IO.readInt();
		int max=0;
		if (number != terminator) { // set first number to max
			max = number;
		}else{
			System.out.println("No input values");
			System.exit(0);
		}
		
		System.out.println("Enter number, or terminator: ");
		number=IO.readInt();
		while (number != terminator){
			max = Math.max(number, max);
			
			System.out.println("Enter number, or terminator: ");
			number=IO.readInt();

		}
		System.out.println(max);

		
	}
}