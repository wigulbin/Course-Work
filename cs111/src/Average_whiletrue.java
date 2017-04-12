
public class Average_whiletrue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter termination number: ");
		int terminator = IO.readInt();
		int sum=0, count=0;
		
		
		while (true){
			System.out.println("Enter number, or terminator: ");
			int number=IO.readInt();
			
			if(number == terminator){
				break;  // jumps out of the while loop
			}
			
			sum += number; // same as sum = sum + number
			count++; // count = count+1
		}
		
		if (count == 0) {
			System.out.println("No input values to average");
		}else{
			System.out.println("average = " + (double)sum/count);
			// System.out.println("average = " + sum*1.0/count); => This also works
		}
			
		/*
		System.out.println("Enter number, or terminator: ");
		int number=IO.readInt();
		while (number != terminator){
			
			sum += number; // same as sum = sum + number
			count++; // count = count+1
			
			System.out.println("Enter number, or terminator: ");
			number=IO.readInt();
			
		}
		
		if (count == 0) {
			System.out.println("No input values to average");
		}else{
			System.out.println("average = " + (double)sum/count);
			// System.out.println("average = " + sum*1.0/count); => This also works
		}*/
	}

}
