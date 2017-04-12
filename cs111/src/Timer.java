
public class Timer {

	// sequential (also called linear) search on a random set of integers
	public static int seqSrch(int[] arr, int target) {
		for (int i=0; i < arr.length; i++) {
			if (target == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	// partial sums, version 2
	public static void partial2(int[] input, int[] output) {
		output[0] = input[0];   // first item of output equals first item of input
		for (int j=1; j < output.length; j++) {  // fill in cells of the output, starting with second
			// add output[j-1] (which is partial sum 0..j-1) to input[j]
			output[j] = output[j-1] + input[j];
		}
	}
		
	// partial sums, version 1
	public static void partial1(int[] input, int[] output) {
		for (int j=0; j < output.length; j++) {  // fill in cells of the output
			// sum up all values 0..j in input, and assign the sum to output[j]
			for (int i=0; i <= j; i++) {
				output[j] += input[i];
			}
		}
	}
	
	// do a lot of repeats so we can get reasonable accuracy in timing
	public static long[] timeSearch(int[] input, int repeats) {
		// replace last item with a value that cannot be in the
		// original input, and use that as the target
		// since values are in the range 1..length, make last value length+10
		
		input[input.length-1] = input.length+10;
		int target = input[input.length-1];   // last item is worst case

		// get clock time BEFORE searches
		long before = System.currentTimeMillis();  
		// do the searches
		for (int r=0; r < repeats; r++) {
			seqSrch(input, target);
		}
		// get clock time AFTER searches
		long after = System.currentTimeMillis();  
		long[] ret = new long[2];
		ret[0] = before;
		ret[1] = after;
		return ret;
	}
	
	// do a lot of repeats so we can get a reasonable accuracy in timing
	public static long[] timePartial1(int[] input, int repeats) {
		int[] output = new int[input.length];
		
		// get clock time BEFORE sums
		long before = System.currentTimeMillis();  
		// do the sums
		for (int r=0; r < repeats; r++) {
			for (int j=0; j < output.length; j++) {  // fill in cells of the output
				// sum up all values 0..j in input, and assign the sum to output[j]
				for (int i=0; i <= j; i++) {
					output[j] += input[i];
				}
			}
			/* Don't want to call method, to avoid method call overhead
			partial1(input, output);
			*/
		}
		
		// get clock time AFTER searches
		long after = System.currentTimeMillis();  
		long[] ret = new long[2];
		ret[0] = before;
		ret[1] = after;
		return ret;
	}
	
	// do a lot of repeats so we can get a reasonable accuracy in timing
	public static long[] timePartial2(int[] input, int repeats) {
		int[] output = new int[input.length];
		
		// get clock time BEFORE sums
		long before = System.currentTimeMillis();  
		// do the sums
		for (int r=0; r < repeats; r++) {
			output[0] = input[0];   // first item of output equals first item of input
			for (int j=1; j < output.length; j++) {  // fill in cells of the output, starting with second
				// add output[j-1] (which is partial sum 0..j-1) to input[j]
				output[j] = output[j-1] + input[j];
			}
			/* Don't want to call method, to avoid method call overhead
			partial2(input, output);
			*/
		}
		
		// get clock time AFTER searches
		long after = System.currentTimeMillis();  
		long[] ret = new long[2];
		ret[0] = before;
		ret[1] = after;
		return ret;
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
	
	public static void reportTime(long[] times, int repeats) {
		System.out.println("\tBefore = " + times[0]);
		System.out.println("\tAfter = " + times[1]);
		int diff = (int)(times[1]-times[0]);
		System.out.println("\tTotal time over all runs = " + diff + " milliseconds");
		System.out.println("\tAverage time for one run = " + diff*1.0/repeats + " milliseconds");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		int[] partials = {3,4,9,2,10};
		System.out.println("Partials Input: ");
		printArray(partials);
		int[] output = new int[partials.length];
		partial1(partials,output);
		System.out.println("Partial1 Output: ");
		printArray(output);
		partial2(partials,output);
		System.out.println("Partial2 Output: ");
		printArray(output);
		*/
		
		int[] arr = makeRandomArray();
		
		// get repeats
		System.out.print("How many repeats?: ");
		int repeats = IO.readInt();
		
		// time sequential search, worst case
		long[] times = timeSearch(arr,repeats);
		System.out.println("\t****  SEQUENTIAL SEARCH  ****");
		reportTime(times, repeats);
		
		// time partial sums version 1, worst case
		times = timePartial1(arr,repeats);
		System.out.println("\n\t****  PARTIAL SUMS VERSION 1 (NESTED LOOPS)  ****");
		reportTime(times, repeats);
		
		// time partial sums version 1, worst case
		times = timePartial2(arr,repeats);
		System.out.println("\n\t****  PARTIAL SUMS VERSION 2 (SINGLE LOOP)  ****");
		reportTime(times, repeats);
	}

	public static void printArray(int[] arr) {
		if (arr.length == 0) {
			System.out.println("[ ]");
			return;
		}
		System.out.print("[");
		System.out.print(arr[0]);
		for (int i=1; i < arr.length; i++) {
			System.out.print(","+arr[i]);
		}
		System.out.println("]");
	}
}
