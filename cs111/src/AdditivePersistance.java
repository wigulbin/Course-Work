
public class AdditivePersistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a number: ");
		int n = IO.readInt();
		int a = 0;
		int sum = 0;
		int count = 0;
		while (n>1){
			while(n>1){
				count++;
				a = n%10;
				n=n/10;
				sum = sum + a;
				
			}
		}sum = sum/10;
		System.out.println(sum);
		System.out.println(count);
	}

}
