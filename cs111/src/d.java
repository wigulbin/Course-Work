
public class d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter a number: ");
		int n = IO.readInt();
		while(n!=0){
			System.out.println(n%10);
			n=(n/10);
		}
		 
	}

}
