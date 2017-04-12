
public class recitation223 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Specify pyramid height");
		int n = IO.readInt();

		for(int i = 1; i<=n; i++){
			for(int k = 0; k<i; k++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = n-1; i>=1; i --){
			for(int k = 0; k<i; k++){
				System.out.print("*");
			}
			System.out.println();
		}
		//Pyramid with space
		for(int i = 1; i<=n; i ++){
			for(int k = 0; k < (n-i); k ++){
				System.out.print(" ");
			}
			for(int k = 0; k < n-(n-i) + (i-1); k ++){
				System.out.print("*");
			}
			System.out.println();
		}
	}


}