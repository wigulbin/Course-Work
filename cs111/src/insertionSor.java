
public class insertionSor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] inputArray={"Elephant","Dog","Cat","Bird","Alpaca","Buffalo"};
		String temp="";

		/*for(int j=0;j<inputArray.length;j++){
			for(int k=1;k<inputArray.length-1;k++){
				if(inputArray[j].compareTo(inputArray[k])>0){
					temp=inputArray[j];
					inputArray[j]=inputArray[k];
					inputArray[k]=temp;
				}
			}
		}*/
		for(int i=1;i<inputArray.length;i++){
			String tempi=inputArray[i];
			int j=i-1;
			for(;j>=0;j--){
				if(tempi.compareTo(inputArray[j])<0){
					inputArray[j+1]=inputArray[j];
				}else{
					break;
				}
			}
			inputArray[j+1]=temp;
		}
		for(int i=1;i<inputArray.length;i++){
			for(int j=i-1;j>=0;j--){
				if(inputArray[i].compareTo(inputArray[j])<0){
					temp=inputArray[j];
					inputArray[j]=inputArray[i];
					inputArray[i]=temp;
				}
			}
		}
		for(int q=0;q<inputArray.length;q++){
			System.out.println(inputArray[q]);
		}
		
	}

}
