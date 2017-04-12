
public class BarGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("How many bars are there in your bar graph?");
		int barNumber = IO.readInt();
		System.out.println("How tall is the tallest bar in your graph?");
		int barTallest= IO.readInt();

		int[][] barGraph = new int [barNumber][barTallest];


		for(int count = 0; count<barNumber; count++){
			System.out.print("What is the heigh of bar " + count + "?");
			int barHeight=IO.readInt();
			while(count<barHeight){
				System.out.print("[]");
			}
		}
*/
		int bars = 0;
		while(bars<= 0){
			System.out.println("How many bars do you want?");
			bars = IO.readInt();
			if(bars<=0){
				System.out.println("need to have more than 0 bars");
			}
		}

		//Array that stores values of bars
		int[] values = new int[bars];

		//Put the values into the array
		for(int i = 0; i < bars;){
			System.out.println("Enter value for bar " + i + ":");
			int a = IO.readInt();
			if(a<0){
				System.out.println("Value must be > 0");
				continue;
			}
			values[i]=a;
			i++;
		}
		System.out.println("YOur values are");
		for(int i = 0;i<values.length;i++){
			System.out.print(values[i] + " ");
		}
		//Print out the graph
		
		//Get highest value
		int highest = Integer.MIN_VALUE;
		for(int i = 0; i < values.length; i++){
			if(values[i] > highest)
				highest = values[i];
		}
		System.out.println();
		
		for(int j = highest; j > 0; j--){
			for(int k = 0; k<values.length; k++){
				if(values[k] >= j)
					System.out.print("[] ");
				else
					System.out.print("   ");
			}
			System.out.println(); //next row in graph
		}
	}
}

