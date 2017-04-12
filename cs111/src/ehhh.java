
public class ehhh
{
	// DO NOT DECLARE ANY VARIABLES HERE
	// (you may declare local variables inside methods)
	public static void main(String[] args){
		String test="4d4f9de2i";
		//System.out.println(test.substring(2));
		decompress("4d4f9de2i");
	}

	public static String decompress(String compressedText){ 
		String answer="";
		answer=decompress(compressedText, answer);
		return answer;
	}

	public static String decompress(String compressedText, String a){
		int n=1;
		int n2;
		if(compressedText.charAt(0)=='2'){
			n=2;
		}else if(compressedText.charAt(0)=='3'){
			n=3;
		}else if(compressedText.charAt(0)=='4'){
			n=4;
		}else if(compressedText.charAt(0)=='5'){
			n=5;
		}else if(compressedText.charAt(0)=='6'){
			n=6;
		}else if(compressedText.charAt(0)=='7'){
			n=7;
		}else if(compressedText.charAt(0)=='8'){
			n=8;
		}else if(compressedText.charAt(0)=='9'){
			n=9;
		}
		n2=n;
		decompress(n, n2, compressedText, a);
		return compressedText;
	}

	private static void decompress(int count, int con, String s, String a){
		if(con==1){
			a+=s.charAt(0);
			decompress(s.substring(1), a);
		}else{
			a+=s.charAt(1);
		}
		if(s.length()<=2 && count==0){
			System.out.println(a);
			System.exit(1);
		}
		if(count==0){
			decompress(s.substring(2), a);
		}
		decompress(count-1, con, s, a);
	}
}
