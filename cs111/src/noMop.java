
public class noMop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1= new Player();
		Player player2= new Player();
		Player player3= new Player();
		Player player4= new Player();
		
		int[] squareArray= new int [10];
		for(int k=0;k<squareArray.length;k++){
			Square square=new Square(100);
			squareArray[k]=square.getPrice();
		}
		
	}
	

}
