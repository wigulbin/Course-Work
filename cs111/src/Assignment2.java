
public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello user. What's your name?");
		String name = IO.readString();
		
		System.out.println("Enter number 1");
		int x1=IO.readInt();
		
		System.out.println("Enter number 2");
		int x2 = IO.readInt();
		
		System.out.println("Enter number 3");
		int x3 = IO.readInt();
		
		int total = x1+x2+x3;
		
		double average = total / 3.0; // or (double)total /3;
		
		IO.outputDoubleAnswer(average);
		
		//System.out.println("Hello, " + name + " the average is " + average);
	}

}
