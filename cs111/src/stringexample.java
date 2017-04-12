
public class stringexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please enter a string ");
		String s= IO.readString();
		String r="";
		for(int i=s.length()-1;i>=0;i--){
			r+= s.charAt(i);
		}
		System.out.println(r);
	}

}
