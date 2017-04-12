
public class TEST4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input a string: ");
		String encoded=IO.readString();
		encoded=encoded.toLowerCase();
		char[] alpha={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
		String decoded= "";
		for(int i=0;i<encoded.length();i++){
			if(encoded.charAt(i)==' '){
				decoded+=' ';
			}
			for(int j=0;j<alpha.length;j++){
				if(encoded.charAt(i)==alpha[j]){
					if(alpha[j]=='a'){
						decoded+='z';	
					}else if(alpha[j]=='0'){
						decoded+='9';
					}else{
						decoded+=alpha[j-1];
					}
				}
			}
		}
		decoded=decoded.trim();
		System.out.print(decoded);
	}

}
