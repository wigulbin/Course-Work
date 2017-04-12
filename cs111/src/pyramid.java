

public class pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter # of lines");
		int n=IO.readInt();
		for(int a=1; a<=n; a++){
			for(int b=1; b<=a; b++){
				System.out.print("*");
			}
			System.out.println();
		
		}
	}

}
