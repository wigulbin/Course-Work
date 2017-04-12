
public class FractionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction f1=new Fraction();
		Fraction f2= new Fraction(3);
		Fraction f3 = new Fraction(2,3);
		
		// System.out.println(f3.num); does not work because num is a private field
		
		System.out.println("f3 = " + f3);	// toString method automatically called on f3
		System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
		
		Fraction f4= new Fraction(3,5);
		Fraction f5 = f3.add(f4);
		System.out.println("f5 = " + f5);
		
		//static method is called using name of the class
		System.out.println(Fraction.add(f3, f5));
		
		Fraction f6 = new Fraction(2,3); //same as f3 in value
		
		// is f3 equal to f6?
		System.out.println(f3.equals(f6));
	}

}
