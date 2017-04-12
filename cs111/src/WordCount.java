
public class WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input a sentence or multiple sentences: ");
		String fullSentence=IO.readString();
		System.out.println("What is the minimun length of the words you want to count?: ");
		int wordLength=IO.readInt();
		fullSentence=fullSentence.trim();
		fullSentence=fullSentence.toLowerCase();
		int wordLengthCount=0;
		boolean deleteChar=false;
		StringBuilder newWordCopy= new StringBuilder("null");
		int[] charArray={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String[] split = fullSentence.split("\\s");
		int deleteCharCount=0;
		for(int counter=0;counter<split.length;counter++){
			String word=split[counter];
			if(word.length()>=wordLength){
				for(int counter2=0;counter2<word.length();counter2++){
					for(int counter3=0;counter3<charArray.length-1;counter3++){
						if(word.charAt(counter2)==charArray[counter3]){
							deleteChar=false;
							break;
						}else{
							deleteChar=true;
							deleteCharCount=counter2;
						}
					}
				}
				StringBuilder newWord=new StringBuilder(word);
				if(deleteChar==true){

					newWord.deleteCharAt(deleteCharCount);
					//System.out.println(newWord);
				}
				//System.out.println(newWord);
				String newWordString=newWord.toString();
				String newWordCopyString=newWordCopy.toString();
				int c= newWordString.compareTo(newWordCopyString);
				if(newWord.length()>=wordLength&&c!=0){
					wordLengthCount++;
					newWordCopy=newWord;
				}


			}
			//System.out.println(split[counter]);
		}
		IO.outputIntAnswer(wordLengthCount);
	}
}


