
public class mult2Dtable {

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

		int[][] multTable = new int[r][c];


		for (int i=0; i < multTable.length; i++){
			for(int j=0; j < multTable[0].length; j++){
				multTable[i][j] = (i+1)*(j+1);
			}
		}
		
		//print table
		printArray(multTable);
		

	}
	public static void printArray(int[][] arr){

		for (int r=0; r< arr.length; r++){
			System.out.print("[");
			// print first value separately since it wont have a comma before it
			System.out.print(arr[r][0]);
			// rest of the stuff
			for(int c=1; c < arr[0].length; c++){
				System.out.print(","+arr[r][c]);
			}
			System.out.println("]");
		}
	}
}