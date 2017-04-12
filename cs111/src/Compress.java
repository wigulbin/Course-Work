
public class Compress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input a string: ");
		String string=IO.readString();
		String compressString="";
		
		for(int k=1, repeat=1;k<string.length();k++,repeat++){
			if(string.charAt(k)!=string.charAt(k-1)){
				//repeat=k-other;
				if(repeat!=1){
					compressString+=repeat;
				}
				compressString+=(string.charAt(k-1));
				repeat=0;	
			}
			if(k==string.length()-1){
				if(repeat!=0){
					compressString+=repeat+1;
				}
				compressString+=(string.charAt(k));
			}
		}
		IO.outputStringAnswer(compressString);
	}
}