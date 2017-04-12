
public class Poly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the first root");
		double a = IO.readDouble();
		System.out.println("Enter the second root");
		double b = IO.readDouble();
		System.out.println("Enter the third root");
		double c = IO.readDouble();
		
		double x = (-c - b - a);
		double y = (c*b)+(c*a)+(a*b);
		double z = -(a*b*c);
		
		System.out.println("x" + "^3" + "+" + x + "x" + "^2" + "+" + y + "x" + "+" + z);
	
	}


}
