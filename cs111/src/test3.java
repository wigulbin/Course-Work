
public class test3 {

	public static void main(String[] args) {
		// TODO A+uto-generated method stub
		System.out.println("Input a sentence: ");
		String sentence=IO.readString();

		String sentenceR=null;
		int spacePos=0;
		int j=0;
		int k=0;
		for(int count=0;count<sentence.length();count++){
			if(sentence.charAt(count)==' '){
				k++;
			}
		}
		String[] array=new String [k+1];
		for(int i=0;i<k;i++){
			array[i]=sentence.substring(spacePos, sentence.indexOf(' ', spacePos));
			spacePos=sentence.indexOf(' ', spacePos)+1;
			j=i;
		}
		array[j+1]=sentence.substring(sentence.lastIndexOf(' '),sentence.indexOf('.'));
		array[j+1]=array[j+1].trim();
		sentenceR=array[array.length-1] + ' ';
		for(int i=array.length-2;i>=0;i--){
			sentenceR+=array[i] + ' ';
		}
		sentenceR=sentenceR.trim();
		sentenceR+='.';
		System.out.print(sentenceR);
	}
}
