
public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Input a number for factorial: ");
		int n = IO.readInt();
		
		/* VERSION 1 (STANDARD)
		int factorial = 1;
		for(int i=2; i <= n; i++) {
			factorial *= i;
		}
		*/
		
		/*VERSION 2: INITIALIZATION OF i OUTSIDE FOR
		int factorial = 1,i=2;
		for(; i <= n; i++) {
			factorial *= i;
		}
		*/
		
		/* VERSION 3: OMIT THE CONDITION (EQUIVALENT TO true)
		int factorial=1,i=2;
		for(; ; i++) {
			if(i>n){
				break;
			}
			factorial *= i;
		}
		*/
		
		/* VERSION 4: EXTREME CASE, NOTHING IN THE FOR HEADER */
		int factorial=1,i=2;
		for(; ;) {
			if(i>n){
				break;
			}
			factorial *= i;
			i++;
		}
		
		System.out.println("factorial ("+n+")= " + factorial);
		
	}

}
