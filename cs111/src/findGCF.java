

public class findGCF {


	public static int gcf (int a, int b){
		int smaller;
		if (a < b){
			smaller = a;
		}else{
			smaller = b;
		}

		for(int i = smaller; i>1; i--){
			if ((a%i==0) && (b%i==0)){
				return i;
			}
		}
		return 1;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the numerator and denominator");
		int numerator = IO.readInt();
		int denominator = IO.readInt();
		
		if(denominator == 0){
			System.out.println("Cannot divide by 0");
			return;
		}
		 
		int numerator2 = numerator/(gcf(numerator,denominator));
		int denominator2= denominator/(gcf(numerator,denominator));

		System.out.print(numerator + "/" + denominator + " simplified is: " +  numerator2 + "/" + denominator2);

	}

}
