
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Would you like to add or subtract 2 numbers? (yes for add or no for subtract)");
		boolean add = IO.readBoolean();
		if (add) {
			System.out.println("Give two numbers to add");
			int numberOne = IO.readInt();
			int numberTwo = IO.readInt();
			System.out.println(numberOne+numberTwo);
		}else{
			System.out.println("Give two numbers to subtract");
			int numberOne = IO.readInt();
			int numberTwo = IO.readInt();
			System.out.println(numberOne-numberTwo);
		}
	}

}
