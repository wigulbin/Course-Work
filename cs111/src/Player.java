
public class Player {
	
	private int money;
	private int location;
	private int blocksOwned;
	
	public static final int DEFAULT_MONEY=1000;
	public static final int DEFAULT_LOCATION=0;
	public static final int DEFAULT_BLOCKSOWNED=0;
	
	public Player(){
		money=DEFAULT_MONEY;
		location=DEFAULT_LOCATION;
		blocksOwned=DEFAULT_BLOCKSOWNED;
	}
	
	public Player(int newMoney,int location,int blocksOwned ){
		 money=newMoney;
		 this.location=location;
		 this.blocksOwned=blocksOwned;
	}
	
	void moneyLost(int amount){
		money-=amount;
	}
	
	void movePlayer(int roll){
		location+=roll;
	}
	
	public int getMoney(){
		return money;
	}
}
