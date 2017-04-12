
public class stringReverse {

	public static 	String reverse(String s){
		if(s.length() == 1){
			return s;
		}else{
			return (reverse(s.substring(1, s.length())) + (s.substring(0,1)));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Hello";
		
		System.out.println(reverse(a));
	}

}
