public class StringRec
{
	// DO NOT DECLARE ANY VARIABLES HERE
	// (you may declare local variables inside methods)
	public static String decompress(String compressedText){	
		String answer="";
		answer=decompress(compressedText, answer);
		return answer;
	}
	
	
	public static String decompress(String compressedText, String a){
		int n=1;
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
		decompress(n, n, compressedText, a);
		return compressedText;
	}
	
	
	private static void decompress(int count, int n, String s, String answer){
		
		if(s.length()<=2 && count==0){
			System.out.println(answer);
			System.exit(1);
		}
		if(count==0){
			decompress(s.substring(2), answer);
		}
		if(n==1){
			answer+=s.charAt(0);
			decompress(s.substring(1), answer);
		}else{
			answer+=s.charAt(1);
		}
		decompress(count-1, n, s, answer);
	}
}