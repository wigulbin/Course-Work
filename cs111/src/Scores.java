
public class Scores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double min = 11;
		double max = 0;
		double average = 0;
		double sum = 0;
		double sumtotal1=0;
		double sumtotal2=0;
		double judgeExtra=0;
		System.out.println("How many judges are there?: ");
		double judge = IO.readDouble();
		while (judge<=0){
			IO.reportBadInput();
			System.out.println("Please input a positive number");
			judge = IO.readDouble();
		}
		if (judge==0){
			IO.outputDoubleAnswer(judge);
			return;
		}
		
		System.out.println("What score did each judge give? (Enter one at a time, must be between 0.0 and 10.0 inclusive): ");
		for(double count=0;count<judge;count++){
			sum = IO.readDouble();
			if (sum<0 || sum>10.0){
				IO.reportBadInput();
				System.out.println("Please input a different number");
				judge++;
				judgeExtra++;
			}
			if (sum>=0 && sum<=10.0){
				sumtotal1 += sum;
			}
			if (sum < min && sum>=0){
				min = sum;
			}
			if (sum>max && sum<=10){
				max=sum;
			}
		}
		if(judge<=2){
			IO.outputDoubleAnswer((max+min)/2);
			return;
		}
		judge -= judgeExtra;
		sumtotal2 = sumtotal1-max-min;
		average = sumtotal2/(judge-2);
		IO.outputDoubleAnswer(average);
		
	}

}
