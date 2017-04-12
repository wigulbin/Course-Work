
public class eh {
	public static void clear(int[] a, int n){
		
		if(n==0){
			a[0]=0;
			return;
		}else{
			a[n-1]=0;	
		}
		clear(a,a.length-1);
		return;
	}
	
	public static void main(String[] args){
		int[] a ={1,2,3};
	}
	clear(a,a.length);
	
}