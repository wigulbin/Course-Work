
public class Hits {

	
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
		
		// get number of pages
		int n = getNumberOfPages();
		
		// set up array for page hits
		int[] hits = new int[n];
		
		// get hits per page from user and fill in the array
		/*int counter = 0;
		
		while(counter<n){
			System.out.println("Enter hits for page " + (counter+1) + ": ");
			// assign value read in from the user to hits[p]
			hits[counter++]=IO.readInt();
		}
		*/
		
		for(int counter=0; counter < n; counter++){
			System.out.println("Enter hits for page " + (counter+1) + ": ");
			hits[counter] = IO.readInt();
		}
		
		int maxIndex=0;
		for (int p=1; p<n; p++){
			if (hits[p] > hits[maxIndex]){
				maxIndex = p;
			}
		}
		// max hits is at index maxIndex
		System.out.println("Page #" + (maxIndex+1) + " has max hits = " + hits[maxIndex]);
		
	}

}
