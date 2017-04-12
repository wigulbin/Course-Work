
public class searchArray {
	public static void main(String[] args){
		String[] inputArray={"Alpaca","Bird","Buffalo","Cat","Dog","Elephant"};
		String check= "alpaca";
		for(int k=0;k<inputArray.length;k++){
			if(check.compareToIgnoreCase(inputArray[k])==0){
				System.out.print(k);
				System.exit(1);
			}else if(check.compareToIgnoreCase(inputArray[k])!=0 && k==inputArray.length-1){
				System.out.println(check + " is not in the array");
			}
		}
	}
}
