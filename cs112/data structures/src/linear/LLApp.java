package linear;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;

public class LLApp {
	
	public static void addAfter(IntNode front,int oldItem, int newItem){
		if(front==null){
			return;
		}
		IntNode ptr=front;
		while(ptr!=null&&ptr.data!=oldItem){
			ptr=ptr.next;
		}
		if(ptr==null){
			return;
		}
		ptr.next=new IntNode(newItem, ptr.next);
		
	}
	
	public static IntNode delete(IntNode front, int item){
		IntNode prev=null, ptr=front;
		if(front==null){
			return front;
		}
		while(ptr!=null&&ptr.data!=item){  // locate the first instance of item
			prev=ptr;
			ptr=ptr.next;
		}
		if(prev==null){ // first item matches
			return front.next;  // second node becomes new front
		}
		if(ptr==null){  // item is not in list
			return front;
		}
		//remove item
		prev.next=ptr.next;
		return front;
	}
	
	public static IntNode deleteFromFront(IntNode front){
		if(front==null){
			return front;
		}
		front=front.next;
		return front;
	}
	
	public static IntNode addToFront(IntNode front, int item){
		/*
		IntNode ptr=new IntNode(item, null);
		ptr.next=front;
		front=ptr;
		return front;
		*/
		return new IntNode(item, front);
	}
	
	public static boolean search(IntNode front, int target){
		for(IntNode ptr=front;ptr!=null;ptr=ptr.next){
			if(target==ptr.data){
				return true;
			}
		}
		return false;
	}
	
	
	public static void traverse(IntNode front){
        if(front == null){
        	System.out.println("Empty list");
        	return;
        }
        System.out.print(front.data); //first item
		IntNode ptr=front.next;    //prepare to loop starting with second item
		while(ptr!=null){
			System.out.print("->"+ptr.data);
			ptr=ptr.next;
		}
        System.out.println();
	}
	
	
	public static void main(String[] args) {
        IntNode front=null;
        traverse(front);  //test traverse on empty list
        front=addToFront(front,4);
        traverse(front);
        front=addToFront(front,6);
        traverse(front);
        front=addToFront(front,8);
        traverse(front);
        
        front=deleteFromFront(front);
        traverse(front);
        front=deleteFromFront(front);
        traverse(front);
        front=deleteFromFront(front);
        traverse(front);
        front=deleteFromFront(front);
        traverse(front);
        
        front=addToFront(front,10);
        traverse(front);
        front=addToFront(front,3);
        traverse(front);
        front=addToFront(front,4);
        traverse(front);
        front=addToFront(front,3);
        traverse(front);
        front=addToFront(front,2);
        traverse(front);
        front = delete(front, 3);
        traverse(front);
        front = delete(front, 2);
        traverse(front);
        front = delete(front, 7);
        traverse(front);
        front = delete(front, 4);
        traverse(front);
        front = delete(front, 3);
        traverse(front);
        front = delete(front, 10);
        traverse(front);
        front = delete(front, 4);
        traverse(front);
        
        addAfter(front, 3, 4);
        traverse(front);

        front=addToFront(front,10);
        traverse(front);
        front=addToFront(front,3);
        traverse(front);
        front=addToFront(front,4);
        traverse(front);
        front=addToFront(front,3);
        traverse(front);
        front=addToFront(front,2);
        traverse(front);
        
        addAfter(front, 2, 7);
        traverse(front);
        addAfter(front, 15, 8);
        traverse(front);
        
        //using StringLL
        StringLL sll= new StringLL();
        sll.addToFront("cs111");
        sll.addToFront("cs112");
        sll.traverse();
        System.out.println(sll.search("cs112"));
        System.out.println(sll.size());
        System.out.println(sll.isEmpty());
        sll.clear();
        System.out.println(sll.size());
        System.out.println(sll.isEmpty());
        
        //using generic linked list
        // string LL
        LinkedList<String> str= new LinkedList<String>();
        sll.addToFront("cs111");
        sll.addToFront("cs112");
        sll.traverse();
        System.out.println(str.search("cs112"));
        System.out.println(str.size());
        System.out.println(str.isEmpty());
        sll.clear();
        System.out.println(str.size());
        System.out.println(str.isEmpty());
        
        // integer LL
        LinkedList<Integer> intll = new LinkedList<Integer>();
        intll.addToFront(6);     // auto boxing, param int 6 is automatically boxed to Integer 6
        intll.traverse();
        intll.addToFront(8);
        intll.traverse();
        intll.deleteFront();
        intll.traverse();
        intll.deleteFront();
        intll.traverse();
        try{
        	String s = getLine("random_stuff.txt");
        	intll.deleteFront();
        }	catch(NoSuchElementException e){
        	System.out.println(e.getMessage());
        	System.exit(1);
        }	catch(FileNotFoundException f){
        	System.out.println(f.getMessage());
        	System.exit(1);
        }
        intll.traverse();
	}
	
	static String getLine(String file)
	throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new FileReader(file));
		return "";
	}

}
















