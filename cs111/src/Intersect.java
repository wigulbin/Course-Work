
public class Intersect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter constant d:");
		int d = IO.readInt();
		System.out.println("Enter constant f:");
		int f = IO.readInt();
		System.out.println("Enter constant g:");
		int g = IO.readInt();
		System.out.println("Enter constant m:");
		int m = IO.readInt();
		System.out.println("Enter constant b:");
		int b = IO.readInt();

		int q = (f-m);
		int u = (g-b);

		if (d==0){
			if(q==0){
				System.out.println("ERROR: Lines are paralell, they do not equal on another.");
				System.exit(1);
			}
			int x = u/q;
			int y = m*x+b;
			System.out.println("The lines interset at:");
			System.out.println("(" + x + ")" + "," + "(" + y + ")");
			System.exit(1);
		}

		double x = (((-q) + (Math.sqrt((q*q)-(4*d*u))))/(2*d));
		double x2 = (((-q) - (Math.sqrt((q*q)-(4*d*u))))/(2*d));
		double y = m*x+b;
		double y2 = m*x2+b;

		System.out.println("The intersections is/are:");
		System.out.println("(" + x + ")" + "," + "(" + y + ")");
		System.out.println("(" + x2 + ")" + "," + "(" + y2 + ")");

	}

}
