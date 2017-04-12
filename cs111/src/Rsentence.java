
public class Rsentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a sentence:");
		String sentence=IO.readString();
		int k=0;
		for(int count=0;count<sentence.length();count++){
			if(sentence.charAt(count)==0){
				k++;
			}
		}
		String[] sentArr= new String[k];
		int spacePos=0;
		for(int i=0;i<k;i++){
			sentArr[i]=sentence.substring(spacePos, sentence.indexOf(' ',spacePos));
			spacePos=(sentence.indexOf(' ',spacePos)+1);
		}
		String rSent=sentence.substring(sentence.lastIndexOf(' ',sentence.indexOf('.')));
		for(int q=k;q>=0;q--){
			rSent+=" "+sentArr[q];
		}
		rSent+=".";
		IO.outputStringAnswer(rSent);
	}

}
