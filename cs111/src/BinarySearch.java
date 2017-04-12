
public class BinarySearch {

	
	//input array must be in sorted order
	public static int binarySearch(int[] list, int target){
		int lo=0, hi=list.length-1;
		
		while(lo<=hi){
			int mid = (lo+hi)/2;	// midpoint of lo and hi
			if(target == list[mid]){
				return mid;
			}
			if(target <list[mid]){
				hi = mid-1;
			}else{
				lo=mid+1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={2,5,14,19,41,52,59,75};
		
		int pos = binarySearch(arr,52);
		if(pos !=-1){
			System.out.println("52 is in the array");
		}else{
			System.out.println("52 is not in the array");
		}
		pos = binarySearch(arr,10);
		if(pos !=-1){
			System.out.println("10 is in the array");
		}else{
			System.out.println("10 is not in the array");
		}
		
	}

}
