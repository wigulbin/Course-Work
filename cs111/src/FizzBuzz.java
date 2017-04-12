
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input an integer");
		int a = IO.readInt();
		
		if ((a%3==0 || a%3==3) && (a%5==0 || a%5==5)){
			System.out.println("FizzBuzz");
			return;
		}
		else if (a%3==0 || a%3==3) {
			System.out.println("Fizz");
		}
		else if (a%5==0 || a%5==5){
			System.out.println("Buzz");
		}
		else{
			System.out.println(a);
		}
		
		
	}

}
