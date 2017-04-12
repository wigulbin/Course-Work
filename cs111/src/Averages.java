import java.util.Arrays;


public class Averages {

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
		String n="None";
		System.out.println("How many numbers will you input?");
		int numberAmount=IO.readInt();

		System.out.println("Enter your numbers: ");

		double[] listArr= new double[numberAmount];
		for(count=0;count<numberAmount;count++){
			listArr[count]=IO.readDouble();
		}
		Arrays.sort(listArr);


		int meancount=0;
		max=listArr[listArr.length-1];

		min=listArr[0];

		for(int k=0;k<numberAmount;k++){
			sum+=listArr[k];
			meancount=k;
		}

		mean=sum/(meancount+1);


		double[][] modeArray;
		//double[][] modeArray= new double[1][listArr.length];
		modeArray=new double[2][listArr.length];
		modeArray[0][0]=listArr[0];

		int q=1;

		for(int k=1;k<listArr.length;k++){
			if(listArr[k]!=listArr[k-1]){
				modeArray[0][q]=listArr[k];
				q++;
			}
		}
		modeArray= new double[2][q];
		modeArray[0][0]=listArr[0];

		q=1;

		for(int k=1;k<listArr.length;k++){
			if(listArr[k]!=listArr[k-1]){
				modeArray[0][q]=listArr[k];
				q++;
			}
		}

		for(int j=0;j<modeArray[1].length-1;j++){
			for(int i=0;i<listArr.length;i++){
				if(modeArray[0][j]==listArr[i]){
					modeArray[1][j]+=1;

				}
			}
		}
	

		double isMax=0;
		double tempMode=0;
		for(int j=0;j<modeArray[1].length-1;j++){
			tempMode=modeArray[1][j];
			if(tempMode>isMax){
				isMax=tempMode;
				mode=modeArray[0][j];
			}
		}

		for(int j=0;j<modeArray[1].length-1;j++){
			tempMode=modeArray[1][j];
			if(modeArray[1][j]==isMax&&modeArray[1][j]==modeArray[1][j+1]){
				mode=0;
			}
		}

		IO.outputDoubleAnswer(min);
		IO.outputDoubleAnswer(max);
		IO.outputDoubleAnswer(sum);
		IO.outputDoubleAnswer(mean);
		if(numberAmount%2!=0){
			median=listArr[(numberAmount/2)];
			IO.outputDoubleAnswer(median);
			if(mode==0){
				IO.outputStringAnswer(n);
			}else{
				IO.outputDoubleAnswer(mode);
			}

		}else{
			median=listArr[listArr.length/2];
			median2=listArr[(listArr.length/2)-1];
			IO.outputDoubleAnswer((median+median2)/2);
			if(mode==0){
				IO.outputStringAnswer(n);
			}else{
				IO.outputDoubleAnswer(mode);
			}
		}
	}
}

