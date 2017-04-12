
public class roundrec {

	
	public static void Round(double x, int n){
		if(n==0){
			System.out.print((int)x);
			return;
		}
		System.out.print((int)x);
		
		Round((x*10)-((int)x*10),n-1);
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Round(1.23456,5);
	}

}
