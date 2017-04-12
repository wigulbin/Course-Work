
public class anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter two words");
		
		String word1= IO.readString();
		String word2= IO.readString();

		if(word1.length()!=word2.length()){
			System.out.println("Not an anagram");
		}
		int counter=0;
		for(int i=0;i<word1.length();i++){
			String letter = word1.substring(i,  i+1);
			int index = word2.indexOf(letter);
			if (index == -1){
				IO.outputBooleanAnswer(false);
				return;
			}else{	//remove letter from word2
				String before = word2.substring(0, index);
				String after = word2.substring(index+1, word2.length());
				word2 = before + after;
			}
		}
		/*IO.outputBooleanAnswer(true);
			for(int j=1;k!=j;j++){
				
				if(word1.charAt(k)==word2.charAt(j)){
					counter++;
					word2.replace(word2.charAt(k), ' ');
				}
			}
		}
		if(counter==word1.length()){
			System.out.println("Is an anagram");
		}*/
	}
		
}
