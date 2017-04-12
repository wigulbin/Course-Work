import java.util.Arrays;


public class CopyOfAverages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double min=0;
		double max=0;
		double sum=0;
		double mean=0;
		double median=0;
		double median2=0;
		double mode=0;
		int count=0;
		System.out.println("How many numbers will you input?");
		int numberAmount=IO.readInt();
		System.out.println("Enter your numbers: ");
		/*double number= IO.readDouble();
		min=number;
		max=number;
		sum=number;
		int k=1;*/

		double[] listArr= new double[numberAmount];
		for(count=0;count<numberAmount;count++){
			listArr[count]=IO.readDouble();
		}
		Arrays.sort(listArr);
		for(count=0;count<numberAmount;count++)	{
			System.out.println(listArr[count]);

		}
		int meancount=0;
		max=listArr[listArr.length-1];
		min=listArr[0];
		for(int k=1;k<numberAmount;k++){
			sum+=listArr[k];
			meancount=k;
		}
		mean=sum/(meancount+1);

		/*for(k=1;k<numberAmount;k++){
			number= IO.readDouble();
			listArr[k]=number;
			if(number<min){
				min=number;
			}
			if(number>max){
				max=number;
			}
			sum+=number;
			mean=sum/(k+1);
			}*/
		for(int j=0;j<listArr.length;j++){
			for(int i=0;i<listArr.length;i++){
				if(listArr[j]==listArr[i]){
					int isMode=count;
					if(isMode>=0)
						mode=listArr[j];
					count++;
				}
			}
		}
		IO.outputDoubleAnswer(min);
		IO.outputDoubleAnswer(max);
		IO.outputDoubleAnswer(sum);
		IO.outputDoubleAnswer(mean);
		if(numberAmount%2!=0){
			median=listArr[(numberAmount/2)];
			IO.outputDoubleAnswer(median);
			IO.outputDoubleAnswer(mode);

			System.out.println(median);
		}else{
			median=listArr[listArr.length/2];
			median2=listArr[(listArr.length/2)-1];
			System.out.println(median+","+median2);
			System.out.println(mode);
		}

	}
}

