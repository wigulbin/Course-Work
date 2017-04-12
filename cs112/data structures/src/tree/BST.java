package tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

// 1. BST does not allow duplicates
// 2. BST requires T objects to implement compareTo
public class BST<T extends Comparable<T>> {
	BSTNode<T> root;
	int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	public T search(T key) {
		BSTNode<T> ptr = root;
		while (ptr != null) {
			int c = key.compareTo(ptr.data);
			if (c == 0) {
				return ptr.data;
			}
			if (c < 0) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
		}
		return null;
	}
	
	public void delete(T item)
	throws NoSuchElementException{
		//search and locate item
		BSTNode<T> x=root, p=null;
		int c=0;
		while (p != null) {
			c = item.compareTo(x.data);
			if (c == 0) {
				break;
			}
			p = x;
			x = c < 0 ? x.left : x.right;
		}
		
		//no match
		if (x == null) {
			throw new NoSuchElementException();
		}
		
		// Case 3 check
		if (x.left != null && x.right != null){
			//find inorder predecessor
			BSTNode<T> y = x.left;
			p = x;				//in case no turns are made
			while(y.right != null){
				p = y;
				y = y.right;
			}
			//copy y data into x
			x.data=y.data;
			// set x to y, for sliding into case 1 or case 2
			x=y;
		}
		
		// x is root
		if (p == null){
			root = x.left != null ? x.left : x.right;
			size--;
			return;
		}
		
		// Case 1
		if(x.left == null & x.right == null){
			if (x == p.left){
				p.left = null;
			}else{
				p.right = null;
			}
		}
		
		// Case 2, four possibilities
		if(x == p.left){
			p.left = x.right == null ? x.left : x.right;
		} else {
			p.right = x.right == null ? x.left : x.right;
		}
		size--;
		
	}
	
	public ArrayList<T> sort() {
		ArrayList<T> ret = new ArrayList<T>(size);
		inorderTraversal(root, ret);
		return ret;
	}
	
	private static <T extends Comparable<T>>
	void inorderTraversal(BSTNode<T> root, ArrayList<T> list){
		if(root == null){
			return;
		}
		inorderTraversal(root.left, list);   //  left subtree "L"
		list.add(root.data);	// vist "V"
		inorderTraversal(root.right, list);	//right subtree "R"
	}
	
	
	// duplicates not allowed
	public void insert(T data) 
	throws IllegalArgumentException {
		BSTNode<T> ptr=root, prev=null;
		int c=0;
		while (ptr != null) {
			c = data.compareTo(ptr.data);
			if (c == 0) {
				throw new IllegalArgumentException("duplicate key, not inserted");
			}
			prev = ptr;
			ptr = c < 0 ? ptr.left : ptr.right;
		}
		
		// prev is at the node to which new node must be attached
		BSTNode<T> tmp = new BSTNode<T>(data);
		if (prev == null) { // tree was empty
			root = tmp;
			size++;
			return;
		}
		if (c < 0) {
			prev.left = tmp;
		} else {
			prev.right = tmp;
		}
		size++;
	}
	
	
	
	
}