
public class HitswithMethods2 {


	public static int getNumberOfPages() {
		int number=0;
		do{
			System.out.print("Enter the number of pages: ");
			number=IO.readInt();
		}while(number <= 0);
		return number;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =0;
		int[] hits = loadArray();
		// print array to verify contents
		
		// find page with max htis ( break ties arbitrarily)
		int maxIndex = findMax(n, hits);

		// max hits is at index maxIndex
		System.out.println("Page #" + (maxIndex+1) + " has max hits = " + hits[maxIndex]);

	}

	public static int[] loadArray() {
		// get number of pages
		int n = getNumberOfPages();

		// set up array for page hits
		int[] hits = new int[n];

		for(int counter=0; counter < n; counter++){
			System.out.println("Enter hits for page " + (counter+1) + ": ");
			hits[counter] = IO.readInt();
		}
		return hits;
	}

	public static int findMax(int n, int[] hits) {
		int maxIndex=0;
		for (int p=1; p<n; p++){
			if (hits[p] > hits[maxIndex]){
				maxIndex = p;
			}
		}
		return maxIndex;
	}


	public void printArray(int[] arr){
		System.out.print("[");
		// print first value separately since it wont have a comma before it
		System.out.print(arr[0]);
		// rest of the stuff
		for(int i=1; i < arr.length; i++){
			System.out.print(","+arr[i]);
		}
		System.out.println("]");
	}
}




