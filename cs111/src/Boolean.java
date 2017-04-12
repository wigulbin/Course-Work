
public class Boolean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter an interger value =>");
		int number = IO.readInt();
		
		boolean negative=false, positive=false, zero=false;
		
		if (number < 0) {
			negative = true;
		}
		if (number > 0) {
			positive = true;
		}
		if (number == 0) {
			zero = true;
		}
		
		System.out.println("positive =" + positive);
		System.out.println("negative =" + negative);
		System.out.println("zero =" + zero);
		
		//negative == true? = negative?
		//negative == false? = NOT negative?
		
		if (negative) {		// same as checking negative == true
			System.out.println("Number is negative");
		}
		if(!zero) {  // ! is the symbol for NOT
			System.out.println("Number is not zero");
		}
		// sytax for OR is || syntax for AND is &&
		
		// some compound conditions
		System.out.println("Enter value for a =>");
		int a = IO.readInt();
		System.out.println("Enter value for b =>");
		int b = IO.readInt();
		System.out.println("Enter value for c =>");
		int c = IO.readInt();
		
		
				
	}

		
}
