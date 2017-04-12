public class types {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=5;
		// float y=3.2; => does not work, 3.2 is considered to be a double
							// and doubles can't be stored in floats
		// fix it by taking on an 'f' after 3.2
		float y=3.2f;

		// double y=3.2; => Will not work, this has already be declared y to be of type float
							// a variable can only be declared once
		double z=3.2;
		
		z=y; // LHS is double, RHS is float, good
		
		// y=z; => does not work, LHS is float RHS is double. Cannot convert from double to float
		
		int i=3;
		
		//float result=x/i; => won't work, RHS is an integer computation because 
								//both x and i ("operands") are ints, so result
								// is int (places after decimal point are discarded)
		// Fix #1
		float result=x*1f/i;  //*1f could be put after the i, just needs to be in the computation
		System.out.println("result of 5/3=" + result);
		
		//Fix #2
		result=(float)x/i;		// CAST x to type float
		System.out.println("result of 5/3=" + result);
		
		int a=(int)3.2f;		// Cast a to type int, forces 3.2 to fit into an int variable
		System.out.println("a="+a);
		
		int big=56789076;
		short small=(short)big;
		System.out.println("short="+small);
		
		// character type
		char ch='x';	//differs from  char ch='X':
		System.out.println("ch="+ch);
		
		// ch=x; => without quates, x is a variable of type in, type mismatch
		
		// ch="x"; => "" means a string,'' is used with char type primitive
	}

}
