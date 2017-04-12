package linear;

import java.util.NoSuchElementException;	//can do  java.util.*  will import whatever is needed

public class LinkedList<T> {

	Node<T> front;
	int size;
	
	public LinkedList(){  //initializes list to empy
		front=null;
		size=0;
	}
	
	public void addToFront(T item){
		front = new Node<T>(item, front);
		size++;
	}
	
	public void deleteFront()
	throws NoSuchElementException {	// shift+ctrl+o will automatically import the package
		if(front ==null){
			throw new NoSuchElementException("no item to be deleted");
		}
		front =front.next;
		size++;
	}
	
	public boolean search(T target){
		for(Node<T> ptr=front; ptr!=null; ptr=ptr.next){
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
		Node<T> ptr=front.next;
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
