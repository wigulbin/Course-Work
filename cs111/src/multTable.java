
public class multTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r=0;
		do{
			System.out.println("Enter number of rows, must be > 0; ");
			r=IO.readInt();
		}while (r <= 0);

		int c=0;
		do {
			System.out.print("Enter number of columns, must be > 0: ");
			c=IO.readInt();
		} while (c <= 0);
		
		/*VERSION 1
		for (int i=1; i <= r; i++){
			for(int j=1; j <= c; j++){
				System.out.print(i*j + " ");
			}
			System.out.println();
			
		}
		*/
		//VERSION 2
		int i=1;
		while (i<=r){
			int j=1;
			while(j <= c){
				System.out.print(i*j + " ");
				j++;
			}
			System.out.println();
			i++;
		}

	}
}