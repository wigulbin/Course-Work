
public class Sorter {

	public static void selectionSort(int[] arr) {
		for (int n=arr.length; n > 1; n--) {
			int maxIndex = 0;
			for (int i=1; i < n; i++) {
				if (arr[i] > arr[maxIndex]) {
					maxIndex = i;
				}
			}
			// switch with last
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[n-1];
			arr[n-1] = temp;
		}
	}
	
	public static void selectionSort(String[] arr) {
		for (int n=arr.length; n > 1; n--) {
			int maxIndex = 0;
			for (int i=1; i < n; i++) {
				if (arr[i].compareTo(arr[maxIndex]) > 0) {
					maxIndex = i;
				}
			}
			// switch with last
			String temp = arr[maxIndex];
			arr[maxIndex] = arr[n-1];
			arr[n-1] = temp;
		}
	}
	
	public static void insertionSort(int[] arr) {
		for (int i=1; i < arr.length; i++) { // insert arr[i] in left sorted list
			int temp = arr[i];   // temp is to be inserted 
			int j=i-1;
			for (;j >= 0;j--) {
				if (temp < arr[j]) { // move arr[j] to arr[j+1]
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = temp;
		}
		
	}
	
	public static void insertionSort(String[] arr) {
		for (int i=1; i < arr.length; i++) { // insert arr[i] in left sorted list
			String temp = arr[i];   // temp is to be inserted 
			int j=i-1;
			for (;j >= 0;j--) {
				if (temp.compareTo(arr[j]) < 0) { // move arr[j] to arr[j+1]
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = temp;
		}
		
	}
	
	public static void printArray(int[] list) {
		System.out.print("\t[");
		System.out.print(list[0]);
		for (int i=1; i < list.length; i++) {
			System.out.print("," + list[i]);
		}
		System.out.println("]");
	}
	
	public static int[] makeRandomArray() {
		System.out.print("Enter array length: ");
		int n = IO.readInt();
		int[] arr = new int[n];
		for (int i=0; i < n; i++) {
			arr[i] = (int)Math.random()*n;   // scale returned value (0..1) by n, and cast to int
		}
		return arr;
	}
	
	public static void main(String[] args) {
		/*
		System.out.print("Enter list of integers to sort, comma separated:\n\t=> ");
		
        String line = IO.readString();
        String[] items = line.split(",");
        int[] arr = new int[items.length];
        for (int i=0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(items[i]);
        }*/
		
		int[] arr = makeRandomArray();
        System.out.print("Input array :");
       // printArray(arr);
     // get clock time BEFORE sums
     	long before = System.currentTimeMillis();  
        selectionSort(arr);
     // get clock time AFTER searches
     	long after = System.currentTimeMillis();  
     	int diff = (int)(after-before);
     	System.out.println("\tTime for selection sort = " + diff + " milliseconds");
        
     	//remake array because selection sort would have sorted the original
     	arr = makeRandomArray();
        
     	before = System.currentTimeMillis();
        insertionSort(arr);
        after = System.currentTimeMillis();  
     	diff = (int)(after-before);
     	System.out.println("\tTime for selection sort = " + diff + " milliseconds");
        //System.out.print("Sorted array:");
       // printArray(arr);
	}
}
