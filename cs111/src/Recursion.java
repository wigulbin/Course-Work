public class Recursion {

	// n is assumed to be >= 1
	public static int fact(int n) {
		if (n == 1) {   // termination condition (also known as base case) 
			return 1;
		}
		return n*fact(n-1);
	}
		
	// n is assumed to be >= 0
	// sequence is 0,1,1,2,3,5,8,13,21,34....
	public static int fib(int n) {
		if (n == 0 || n == 1) {   // fib(0)=0 and fib(1)=1
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static boolean palindrome(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		if (s.charAt(0) != s.charAt(s.length()-1)) {
			return false;
		}
		return palindrome(s.substring(1,s.length()-1));
	}
	
	public static int max(int[] arr){	// called by any application that needs to find max
		return max(arr,0);	//call recursive helper method with 0 as start index
	}
	
	private static int max(int[] arr, int start){
		if(start==arr.length-1){	//termination
			return arr[start];
		}
		return Math.max(arr[start], max(arr, start+1));
	}
	
	public static void bigK(int size){
		if(size ==1){
			System.out.println('k');
			return;
		}
		//print top line
		System.out.print('k');
		for(int i=0;i<size-1;i++){
			System.out.print(' ');
		}
		System.out.println('k');
		
		//recurse to build smaller nested big K
		bigK(size-1);
		
		//print bottom line
		System.out.print('k');
		for(int i=0;i<size-1;i++){
			System.out.print(' ');
		}
		System.out.println('k');
	}
	
	public static boolean binarySearch(int[] arr, int target){	// called by any application that needs to find max
		return binarySearch(arr, target, 0, arr.length-1);	//call recursive helper method with 0 as start index
	}
	
	private static boolean binarySearch(int[] arr, int target, int lo, int hi){
		if(lo == hi){	//termination if there is only one thing left
			return target == arr[lo];
		}
		int mid = (lo+hi)/2;
		if(target==arr[mid]){	//termination if target matches mid
			return true;
		}
		if(target < arr[mid]){
			return binarySearch(arr, target, lo, mid-1);	//recurse left half
		}else{
			return binarySearch(arr, target, mid+1, hi);	//recurse right half
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("(f)act, f(i)b, (p)alindrome, or (q)uit? ");
		char ch = Character.toLowerCase(IO.readChar());
		while (ch != 'q') {
			if (ch == 'f') {
				System.out.print("Enter n (1 or more): ");
				int n = IO.readInt();
				System.out.println(fact(n));
			} else if (ch == 'i') {
				System.out.print("Enter n (0 or more): ");
				int n = IO.readInt();
				System.out.println(fib(n));
			} else if (ch == 'p') {
				System.out.print("Enter string: ");
				System.out.println(palindrome(IO.readString()));
			} 
			System.out.print("(f)act, f(i)b, (p)alindrome, or (q)uit? ");
			ch = Character.toLowerCase(IO.readChar());
		}

	}

}
