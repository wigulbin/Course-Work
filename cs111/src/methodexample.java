
public class methodexample {

	
	public static int addition(int x1, int x2){
		return x1 + x2;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter two integbe added");
		
		int a = IO.readInt();
		int b = IO.readInt();
		
		System.out.println(addition(a,b));
	}

}
