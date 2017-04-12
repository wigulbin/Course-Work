
public class Sumfor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("How many values are you going to add together?: ");
		int numValues = IO.readInt();
		int sum=0;

		/* Version 1: Starting count at 0
		for(int count=0; count < numValues; count++){
			System.out.println("count=" + count);

			System.out.println("Enter value: ");
			int number=IO.readInt();
			sum += number;
		}
		*/

		/* VERSION 2: STARTING cOUNT AT 1
		for(int count=1; count <= numValues; count++){
			System.out.println("count=" + count);

			System.out.println("Enter value: ");
			int number=IO.readInt();
			sum += number;
		 }
		 */

		//WHILE LOOP VERSION
		int count=1;
		while(count <= numValues){
			System.out.println("count=" + count);

			System.out.println("Enter value: ");
			int number=IO.readInt();
			sum += number;
			count++;
		}

		System.out.println("sum=" +sum);
	}
}


