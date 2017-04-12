
public class TwoSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a terminating value (must be a real number: ");
		double terminate=IO.readDouble();
		System.out.println("Enter a sequence of real numbers");
		double temp = IO.readDouble();
		if (temp == terminate){
			System.out.print("No numbers to check");
		}
		double x = temp;
		System.out.println("Enter a sequence of real numbers");
		double y = IO.readDouble();
		double min1 = Math.min(x, y);
		double min2 = Math.max(x, y);
		if (temp == terminate){
			System.out.print(min1 + ", " + min2);
		}
		while (temp != terminate){
			System.out.println("Enter a sequence of real numbers");
			temp = IO.readDouble();
			if (temp < min1 && temp!=terminate){
				min2 = min1;
				min1 = temp;
			}else if (temp < min2 && temp!=terminate){
				min2 = temp;
			}
			if (temp == terminate){
				IO.outputDoubleAnswer(min1);
				IO.outputDoubleAnswer(min2);
			}


		}
	}

}


