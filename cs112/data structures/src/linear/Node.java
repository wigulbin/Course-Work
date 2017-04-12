package linear;

// generic Node class - T is an Object type, cannot be a primitive
public class Node<T>{	// t for type
	T data;
	Node<T> next;
	public Node(T data, Node<T> next){
		this.data=data;
		this.next=next;
	}
	public String toString(){
		return data.toString();
	}
}
