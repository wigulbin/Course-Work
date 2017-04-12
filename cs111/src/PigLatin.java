
public class PigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a word: ");
		String word=IO.readString();
		word.toLowerCase();
		char[] charArray={'a','e','i','o','u','A','E','I','O','U'};
		boolean isVowel=false;
		for(int k=0;k<9;k++){
			if(word.charAt(0)==charArray[k]){
				IO.outputStringAnswer(word+"way");
				isVowel=true;
			}
		}
		if(isVowel==false){
			IO.outputStringAnswer(word.substring(1, word.length())+word.charAt(0)+"ay");
		}
	}

}
