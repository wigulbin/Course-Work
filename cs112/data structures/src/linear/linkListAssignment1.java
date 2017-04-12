package linear;

public class linkListAssignment1 {
	public static IntNode addBefore(IntNode front, int target, int newItem){
		if(front==null){
			return null;
		}
		IntNode temp=front;
		IntNode item=new IntNode(newItem, null);
		IntNode prev=null;
		if(front.data==target){
			return new IntNode(newItem,front);
		}
		while(temp!=null){
			if(temp.data==target){
				item.next=temp;
				prev.next=item;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		return front;
	}
    public static void main(String[] args){
    	IntNode front=new IntNode(2,null);
    	
    	System.out.println(addBefore(front,2,5));
    	System.out.println(front.next);
    	
    }
}
