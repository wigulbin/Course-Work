
public class twodarrayex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("How many rows do you want?");
		int rows=IO.readInt();
		System.out.println("How many columns?");
		int columns=IO.readInt();
		int[][] array1= new int[rows][columns];
		for(int count2=0;count2<rows;count2++){
			System.out.println("Enter values for row" + " " + count2);
			for(int count=0;count<columns;count++){
				array1[count2][count]=IO.readInt();
			}
		}
		for(int count2=0;count2<rows;count2++){
			for(int count=0;count<columns;count++){
				System.out.print(array1[count2][count]);
				System.out.print(" ");
			}
			System.out.println();
		}
		int[] avs=new int[rows];
		
		for(int i=0; i<array1.length;i++){
			for(int k=0;k<array1[i].length;k++){
				avs[i]+=array1[i][k];
			}
			avs[i]/=array1[i].length;
		}
		int maxIn=0;
		
		for(int i=0; i<avs.length;i++){
			if(avs[i]>avs[maxIn]){
				maxIn=i;
			}
		}
		System.out.println("row " + maxIn + " has the highest average");
		for(int count2=0, count=0;count2<rows;count2++){
			int max=((array1[count2][count])+(array1[0][1])/2);
			
		}
		System.out.println("The row with the highest average is");
		
	}
}
