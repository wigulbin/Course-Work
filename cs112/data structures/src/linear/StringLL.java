package linear;

public class StringLL {

	// inner class
	public static class StringNode{
		String data;
		StringNode next;
		public StringNode(String data, StringNode next){
			this.data=data;
			this.next=next;
		}
	}
	
	StringNode front;
	int size;
	
	public StringLL(){  //initializes list to empy
		front=null;
		size=0;
	}
	
	public void addToFront(String item){
		front = new StringNode(item, front);
		size++;
	}
	
	public void deleteFront(){
		if(front ==null){
			System.out.println("Empty list, nothing to delete");
			return;
		}
		front =front.next;
		size++;
	}
	
	public boolean search(String target){
		for(StringNode ptr=front; ptr!=null; ptr=ptr.next){
			if(target.equals(ptr.data)){
				return true;
			}
		}
		return false;
	}
	
	public void traverse(){
		if(front==null){
			System.out.println("Empty list");
			return;
		}
		System.out.print(front.data);
		StringNode ptr=front.next;
		while(ptr!=null){
			System.out.print("->"+ptr.data);
			ptr=ptr.next;
		}
		System.out.println();
	}
	
    public int size(){
    	return size;
    }
    
    public void clear(){
    	front=null;
    	size=0;
    }
    
    public boolean isEmpty(){
    	return size==0;
    }
}
