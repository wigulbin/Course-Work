//Object
public class Fraction {

	/*(1) Define Instance fields
	 *(2) Define constructors- special methods need to initialize a newly created object 
	 *	(a) Construction do not have return type
	 *	(b) Name of constructor is same as the class
	 */

	// instance fields
	private int num;
	private int denom;

	//most general constructor
	public Fraction(int num, int denom){
		this.num=num;	//"this" means this object, i.e the object on which the constructor is being executed
		
		if(denom==0){
			denom=1;
		}
		this.denom=denom;
	}

	//another constructor.which only accepts numerator
	//denominator=1
	public Fraction(int num){
		/* can do it this way
		this.num=num;
		denom=1;
		*/
		/*Or, mor often, the general constructor will be called to do the work*/
		this(num, 1);	//call the general constructor, this____ refers to instance field, this() calls another constructor
		
	}
	
	//another constructor. to set fraction to 1/1 (i.e. the integer 1)
	public Fraction(){
		/*num=1;
		denom=1;*/
		this(1,1);
	}
	
	//getter methods
	public int getNum(){
		return num;
	}
	public int getDenom(){
		return denom;
	}
	
	// No setter methods, want Fraction objects to be immutable
	
	public String toString(){	//if a class does not implement toString it defaults to address of object
		return num + "/" + denom;
	}
	
	//adds this fraction and f. and returns the result in a new Fraction object
	public Fraction add(Fraction f){	//add(f1,f2) = In this version, f1 & f2 are added, the object on which add is called has no part to play. (f3 does nothing) f3.add(f1,f2)
		int n = num*f.denom + denom*f.num;	//cross multiply
		int d = denom*f.denom;
		return new Fraction(n,d);
	}
	
	// static method here means that there is NO object on which this method is called
	// the Fraction class simply happens to be a good place to implement a method that adds fractions
	public static Fraction add(Fraction f1, Fraction f2){
		
		// int n= num*f1.denom; Won't work because num is an "instance" field that can only be referred on an object,
							  //but this method is not called on any fraction object
		
		int n = f1.num*f2.denom + f2.denom*f1.num;	//cross multiply
		int d = f1.denom*f2.denom;
		return new Fraction(n,d);
	}
	
	public boolean equals(Fraction other){
		return num == other.num && denom == other.denom;
	}
	
}
