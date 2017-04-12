package poly;

import java.io.*;
import java.util.StringTokenizer;

/**
 * This class implements a term of a polynomial.
 * 
 * @author runb-cs112
 *
 */
class Term {
	/**
	 * Coefficient of term.
	 */
	public float coeff;
	
	/**
	 * Degree of term.
	 */
	public int degree;
	
	/**
	 * Initializes an instance with given coefficient and degree.
	 * 
	 * @param coeff Coefficient
	 * @param degree Degree
	 */
	public Term(float coeff, int degree) {
		this.coeff = coeff;
		this.degree = degree;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		return other != null &&
		other instanceof Term &&
		coeff == ((Term)other).coeff &&
		degree == ((Term)other).degree;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (degree == 0) {
			return coeff + "";
		} else if (degree == 1) {
			return coeff + "x";
		} else {
			return coeff + "x^" + degree;
		}
	}
}

/**
 * This class implements a linked list node that contains a Term instance.
 * 
 * @author runb-cs112
 *
 */
class Node {
	
	/**
	 * Term instance. 
	 */
	Term term;
	
	/**
	 * Next node in linked list. 
	 */
	Node next;
	
	/**
	 * Initializes this node with a term with given coefficient and degree,
	 * pointing to the given next node.
	 * 
	 * @param coeff Coefficient of term
	 * @param degree Degree of term
	 * @param next Next node
	 */
	public Node(float coeff, int degree, Node next) {
		term = new Term(coeff, degree);
		this.next = next;
	}
}

/**
 * This class implements a polynomial.
 * 
 * @author runb-cs112
 *
 */
public class Polynomial {
	
	/**
	 * Pointer to the front of the linked list that stores the polynomial. 
	 */ 
	Node poly;
	
	/** 
	 * Initializes this polynomial to empty, i.e. there are no terms.
	 *
	 */
	public Polynomial() {
		poly = null;
	}
	
	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param br BufferedReader from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 */
	public Polynomial(BufferedReader br) throws IOException {
		String line;
		StringTokenizer tokenizer;
		float coeff;
		int degree;
		
		poly = null;
		
		while ((line = br.readLine()) != null) {
			tokenizer = new StringTokenizer(line);
			coeff = Float.parseFloat(tokenizer.nextToken());
			degree = Integer.parseInt(tokenizer.nextToken());
			poly = new Node(coeff, degree, poly);
		}
	}
	
	
	/**
	 * Returns the polynomial obtained by adding the given polynomial p
	 * to this polynomial - DOES NOT change this polynomial
	 * 
	 * @param p Polynomial to be added
	 * @return A new polynomial which is the sum of this polynomial and p.
	 */
	public Polynomial add(Polynomial p) {
		Node p1=poly;
		Node p2=p.poly;
		Polynomial poly3 = new Polynomial();
		poly3.poly=new Node(0,0,null);
		Node p3=poly3.poly;
		if(p1==null){
			poly3.poly=p2;
		}
		if(p2==null){
			poly3.poly=p1;
		}
		while(p1!=null||p2!=null){
			if(p1!=null&&p2!=null){
				if(p1.term.degree<p2.term.degree){
					p3.term=p1.term;
					p1=p1.next;
				}else if(p1.term.degree>p2.term.degree){
					p3.term=p2.term;
					p2=p2.next;
				}else if(p1.term.degree==p2.term.degree&&!(p1.term.coeff+p2.term.coeff==0)){
						p3.term.coeff=p1.term.coeff+p2.term.coeff;
						p3.term.degree=p1.term.degree;
						p1=p1.next;
						p2=p2.next;
				}
			}
			if(p1==null&&p2==null){
				break;
			}
			if((p1!=null&&p2!=null)&&p1.term.degree==p2.term.degree&&p1.term.coeff+p2.term.coeff==0){
				p1=p1.next;
				p2=p2.next;
				continue;
			}
			if((p1==null&&p2!=null)&&p3.term.coeff==0){
				p3.term=p2.term;
				p2=p2.next;
			}
			if((p1!=null&&p2==null)&&p3.term.coeff==0){
				p3.term=p1.term;
				p1=p1.next;
			}
			if(p1!=null||p2!=null){
				p3.next=new Node(0,0,null);
				p3=p3.next;
			}
			if(p1==null&&p2!=null){
				p3.term=p2.term;
				p2=p2.next;
				continue;
			}else if(p2==null&&p1!=null){
				p3.term=p1.term;
				p1=p1.next;
				continue;
			}
		}
		return poly3;
	}
	
	/**
	 * Returns the polynomial obtained by multiplying the given polynomial p
	 * with this polynomial - DOES NOT change this polynomial
	 * 
	 * @param p Polynomial with which this polynomial is to be multiplied
	 * @return A new polynomial which is the product of this polynomial and p.
	 */
	public Polynomial multiply(Polynomial p) {
		Node p1=poly;
		Node p2=p.poly;
		Polynomial poly3 = new Polynomial();
		poly3.poly=new Node(0,0,null);
		Node p3=poly3.poly;
		Polynomial poly4 = new Polynomial();
		if(p1==null||p2==null){
			poly4.poly=null;
		}
		while(p1!=null){
			poly3=new Polynomial();
			poly3.poly=new Node(0,0,null);
			p3=poly3.poly;
			while(p2!=null){
				p3.term.coeff=p1.term.coeff*p2.term.coeff;
				p3.term.degree=p1.term.degree+p2.term.degree;
				p2=p2.next;
				if(p2!=null){
					p3.next=new Node(0,0,null);
					p3=p3.next;
				}	
			}
			poly4=poly4.add(poly3);
			p1=p1.next;
			p2=p.poly;
		}
		return poly4;
	}
	
	/**
	 * Evaluates this polynomial at the given value of x
	 * 
	 * @param x Value at which this polynomial is to be evaluated
	 * @return Value of this polynomial at x
	 */
	public float evaluate(float x) {
		Node p1=poly;
		float answer=0;
		while(p1!=null){
			if(p1.term.degree==0){
				answer+=p1.term.coeff;
			}else{
				answer+=p1.term.coeff*Math.pow(x,p1.term.degree);
			}
			p1=p1.next;
		}
		return answer;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String retval;
		
		if (poly == null) {
			return "0";
		} else {
			retval = poly.term.toString();
			for (Node current = poly.next ;
			current != null ;
			current = current.next) {
				retval = current.term.toString() + " + " + retval;
			}
			return retval;
		}
	}
}
