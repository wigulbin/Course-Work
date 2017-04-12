package linear;

public class LLstringsearch {
    public static int numberOfOccurances(StringNode front, String target){
    	if(front==null){
    		return 0;
    	}
    	StringNode temp=front;
    	int num=0;
    	while(temp!=null){
    		if((temp.data).equals(target)){
    			num++;
    		}
    		temp=temp.next;
    	}
    	return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
