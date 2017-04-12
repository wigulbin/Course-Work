
public class methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = add(5,6); // calls the add(int,int) method
		
		float y = add(5.2f,6.8f); // calls the add(float,float) method

		int n=5;
		stuff(n);
		System.out.println("n=" + n); 
		
	}
	
	public static void stuff(int n){
		n=10;
	}
	
	
	// different methods with same name, different parameters
	// called method OVERLOADING
	//the following two methods overload the name "add"
	public static int add(int x, int y){
		return x+y;
	}
	// different methods with same name, different parameters
	public static float add(float x, float y){
		return x+y;
	}
	/* this wont work because it has teh same name and same parameter types as the first add,
	 * return type is irrelevant
	public static void add(int a, int b){
		return;
	}
	*/
}
