package apps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import structures.Stack;

public class Expression {

	/**
	 * Expression to be evaluated
	 */
	String expr;                

	/**
	 * Scalar symbols in the expression 
	 */
	ArrayList<ScalarSymbol> scalars;   

	/**
	 * Array symbols in the expression
	 */
	ArrayList<ArraySymbol> arrays;

	/**
	 * Positions of opening brackets
	 */
	ArrayList<Integer> openingBracketIndex; 

	/**
	 * Positions of closing brackets
	 */
	ArrayList<Integer> closingBracketIndex; 

	/**
	 * String containing all delimiters (characters other than variables and constants), 
	 * to be used with StringTokenizer
	 */
	public static final String delims = " \t*+-/()[]";

	/**
	 * Initializes this Expression object with an input expression. Sets all other
	 * fields to null.
	 * 
	 * @param expr Expression
	 */
	public Expression(String expr) {
		this.expr = expr;
		scalars = null;
		arrays = null;
		openingBracketIndex = null;
		closingBracketIndex = null;
	}

	/**
	 * Matches parentheses and square brackets. Populates the openingBracketIndex and
	 * closingBracketIndex array lists in such a way that closingBracketIndex[i] is
	 * the position of the bracket in the expression that closes an opening bracket
	 * at position openingBracketIndex[i]. For example, if the expression is:
	 * <pre>
	 *    (a+(b-c))*(d+A[4])
	 * </pre>
	 * then the method would return true, and the array lists would be set to:
	 * <pre>
	 *    openingBracketIndex: [0 3 10 14]
	 *    closingBracketIndex: [8 7 17 16]
	 * </pe>
	 * 
	 * See the FAQ in project description for more details.
	 * 
	 * @return True if brackets are matched correctly, false if not
	 */
	public boolean isLegallyMatched() {
		openingBracketIndex = new ArrayList<Integer>();
		closingBracketIndex = new ArrayList<Integer>();
		Stack<Bracket> paren = new Stack<Bracket>();
		Stack<Bracket> bracket = new Stack<Bracket>();
		for(int i = 0; i < expr.length();i++){
			if(expr.charAt(i)=='('){
				paren.push(new Bracket('(',i));
			}else if(expr.charAt(i)=='['){
				bracket.push(new Bracket('[',i));
			}
			if(expr.charAt(i)==')'){
				if(paren.size()==0){
					return false;
				}
				openingBracketIndex.add(paren.pop().pos);
				closingBracketIndex.add(i);
			}else if(expr.charAt(i)==']'){
				if(bracket.size()==0){
					return false;
				}
				openingBracketIndex.add(bracket.pop().pos);
				closingBracketIndex.add(i);
			}
		}
		return paren.size()==0&&bracket.size()==0;

	}

	/**
	 * Populates the scalars and arrays lists with symbols for scalar and array
	 * variables in the expression. For every variable, a SINGLE symbol is created and stored,
	 * even if it appears more than once in the expression.
	 * At this time, the constructors for ScalarSymbol and ArraySymbol
	 * will initialize values to zero and null, respectively.
	 * The actual values will be loaded from a file in the loadSymbolValues method.
	 */
	public void buildSymbols() {
		scalars = new ArrayList<ScalarSymbol>();
		arrays = new ArrayList<ArraySymbol>();
		for(int i = 0, k = 0;i <= expr.length(); i++){
			if(i==expr.length()){
				if(expr.charAt(expr.length()-1)==')'||expr.charAt(expr.length()-1)==']'){
					break;
				}
				ScalarSymbol s = new ScalarSymbol(expr.substring(k,i));
				if(!scalars.contains(s)){
					scalars.add(s);
				}
				continue;
			}
			if(expr.charAt(i)=='('){
				k=i+1;
				continue;
			}
			if(Character.isDigit(expr.charAt(i))){
				k=i+1;
				if(k>=expr.length()){
					i++;
					break;
				}
				continue;
			}
			if(expr.charAt(i)=='['){
				ArraySymbol a = new ArraySymbol(expr.substring(k,i));
				if(!arrays.contains(a)){
					arrays.add(a);
				}
				k=i+1;
				continue;
			}
			if(expr.charAt(i)==']'){
				if(expr.charAt(i-1)=='('||expr.charAt(i-1)==')'||Character.isDigit(expr.charAt(i-1))){
					k=i+1;
					continue;
				}

				ScalarSymbol s = new ScalarSymbol(expr.substring(k,i));
				scalars.add(s);
				k=i+1;
				if(i==expr.length()-1){
					break;

				}
				continue;
			}
			if(expr.charAt(i)=='*'||expr.charAt(i)=='/'||expr.charAt(i)=='+'||expr.charAt(i)=='-'||expr.charAt(i)==')'||expr.charAt(i)==' '){
				if(expr.charAt(i-1)=='('||expr.charAt(i-1)==')'||expr.charAt(i-1)==']'||expr.charAt(i-1)==' '||expr.charAt(i-1)=='*'||expr.charAt(i-1)=='/'||expr.charAt(i-1)=='+'||expr.charAt(i-1)=='-'){
					k=i+1;
					continue;
				}
				if(k==i){
					k=i+1;
					continue;
				}
				ScalarSymbol s = new ScalarSymbol(expr.substring(k,i));
				if(!scalars.contains(s)){
					scalars.add(s);
				}
				k=i+1;
			}
		}
		scalars.toString();
	}

	/**
	 * Loads values for symbols in the expression
	 * 
	 * @param sc Scanner for values input
	 * @throws IOException If there is a problem with the input 
	 */
	public void loadSymbolValues(Scanner sc) 
			throws IOException {
		while (sc.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(sc.nextLine().trim());
			int numTokens = st.countTokens();
			String sym = st.nextToken();
			ScalarSymbol ssymbol = new ScalarSymbol(sym);
			ArraySymbol asymbol = new ArraySymbol(sym);
			int ssi = scalars.indexOf(ssymbol);
			int asi = arrays.indexOf(asymbol);
			if (ssi == -1 && asi == -1) {
				continue;
			}
			int num = Integer.parseInt(st.nextToken());
			if (numTokens == 2) { // scalar symbol
				scalars.get(ssi).value = num;
			} else { // array symbol
				asymbol = arrays.get(asi);
				asymbol.values = new int[num];
				// following are (index,val) pairs
				while (st.hasMoreTokens()) {
					String tok = st.nextToken();
					StringTokenizer stt = new StringTokenizer(tok," (,)");
					int index = Integer.parseInt(stt.nextToken());
					int val = Integer.parseInt(stt.nextToken());
					asymbol.values[index] = val;              
				}
			}
		}
	}

	/**
	 * Evaluates the expression, using RECURSION to evaluate subexpressions and to evaluate array 
	 * subscript expressions. (Note: you can use one or more private helper methods
	 * to implement the recursion.)
	 * 
	 * @return Result of evaluation
	 */
	public float evaluate() {
		// COMPLETE THIS METHOD
		float ans=0;
		int i = 0;;
		float temp = 0;

		Stack<Character> operator = new Stack<Character>();
		String item = expr;
		StringTokenizer st = new StringTokenizer(expr,"+" + "-" + "*" + "/" + "(" + ")" + "[" + "]" + " ");
		String s = st.nextToken();
		Stack<Float> value = new Stack<Float>(); 
		boolean operatorMultDiv = false;
		boolean containScalar = false;
		boolean containArray = false;
		boolean skip=false;
		boolean operatorAddMin = false;
		Boolean lastToken=false;
		st = new StringTokenizer(item, "+" + "-" + "*" + "/" + "(" + ")" + "[" + "]" + " ");
		s= st.nextToken();
		int tokenCounter=st.countTokens();
		while(tokenCounter>=0){
			for(int q = 0; q<item.indexOf(s);q++){
				if(item.charAt(q)=='+'||item.charAt(q)=='-'||item.charAt(q)=='*'||item.charAt(q)=='/'){
					operator.push(item.charAt(q));
					item=item.substring(q+1);
				}
			}
			for(int parenTemp=0;parenTemp<item.indexOf(s);parenTemp++){
				Stack<Integer> open = new Stack<Integer>();
				int openCheck = 0;
				boolean check=false;
				for(int p = 0; p < item.length();p++){
					if(item.charAt(p)=='('){
						open.push(p);
					}
					if(item.charAt(p)==')'){
						openCheck = open.pop();
						check=true;
					}
					if(check && open.size()==0){
						temp = recurEvaluate(item.substring(openCheck+1, p));
						value.push(temp);
						item = item.substring(p+1);
						break;
					}
					if(item.equals("")){
						return value.pop();
					}

				}
				if(!operator.isEmpty()&&(operator.peek()=='*'||operator.peek()=='/')){
					operatorMultDiv=true;
				}else{
					operatorMultDiv=false;
				}
				skip=true;

			}
			for(i = 0; i<scalars.size();i++){
				if(!skip&&!scalars.isEmpty()&&s.equals(scalars.get(i).name)){
					for(int scalarCount=0; scalarCount<scalars.size();scalarCount++){
						if(s.equals(scalars.get(scalarCount).name)){
							value.push((float)(scalars.get(scalarCount).value));
							containScalar=true;
							item=item.substring(item.indexOf(s)+s.length());
							if(!operator.isEmpty()&&(operator.peek()=='*'||operator.peek()=='/')){
								operatorMultDiv=true;
							}else{
								operatorMultDiv=false;
							}
							break;
						}
					}
				}
			}
			for(i = 0; i<arrays.size();i++){
				if(!skip&&!arrays.isEmpty()&&s.equals(arrays.get(i).name)){
					containArray=true;
					Stack<Integer> openB = new Stack<Integer>();
					boolean checkB = false;
					int tempB = 0;
					int b=0;
					for(b = 0;b<item.length();b++){
						if(item.charAt(b)=='['){
							openB.push(b);
						}
						if(item.charAt(b)==']'){
							tempB=openB.pop();
							checkB=true;
						}
						if(checkB&&openB.size()==0){
							temp = recurEvaluate(item.substring(tempB+1,b));
							break;
						}

					}
					ArraySymbol tempArray = arrays.get(i);
					int tempValue = tempArray.values[(int)temp];
					value.push((float)tempValue);
					if(b==item.length()){
						break;
					}else{
						item = item.substring(b+1);
					}
					if(!operator.isEmpty()&&(operator.peek()=='*'||operator.peek()=='/')){
						operatorMultDiv=true;
					}else{
						operatorMultDiv=false;
					}
					break;

				}
			}if(!skip&&(!containScalar&&!containArray)){
				value.push((float)Integer.parseInt(s));

				item=item.substring(item.indexOf(s)+1);
				if(!operator.isEmpty()&&(operator.peek()=='*'||operator.peek()=='/')){
					operatorMultDiv=true;
				}else{
					operatorMultDiv=false;
				}
			}
			if(operatorMultDiv&&!operator.isEmpty()&&(operator.peek()=='*'||operator.peek()=='/')){
				float val2 = value.pop();
				float val1 = value.pop();
				if(operator.peek()=='*'){
					value.push(val1*val2);
				}else if(operator.peek()=='/'){
					value.push(val1/val2);
				}
				operator.pop();
				if(!operator.isEmpty()){
					val2 = value.pop();
					val1 = value.pop();
					if(operator.peek()=='+'){
						value.push(val1+val2);
						operator.pop();
					}else if(operator.peek()=='-'){
						value.push(val1-val2);
						operator.pop();
					}
				}
			}else if((!operatorMultDiv&&operator.size()==2)||(operator.size()==1&&!st.hasMoreTokens()&&value.size()==2)){
				float tempValue =0;
				char tempOp = ' ';
				if(value.size()==3){
					tempValue = value.pop();
					tempOp = operator.pop();
				}
				float val2 = value.pop();
				float val1 = value.pop();

				if(operator.peek()=='+'){
					value.push(val1+val2);
					operator.pop();
				}else if(operator.peek()=='-'){
					value.push(val1-val2);
					operator.pop();
				}
				if(tempOp!= ' '){
					operator.push(tempOp);
				}
				if(tempValue!=0){
					value.push(tempValue);
					val2 = value.pop();
					val1 = value.pop();
					if(operator.peek()=='+'){
						value.push(val1+val2);
						operator.pop();
					}else if(operator.peek()=='-'){
						value.push(val1-val2);
						operator.pop();
					}
				}
			}
			if(!operator.isEmpty()&&(operator.peek()=='*'||operator.peek()=='/')){
				operatorMultDiv=true;
			}else{
				operatorMultDiv=false;
			}
			if(operator.size()==2&&(operator.peek()=='+'||operator.peek()=='-')){
				operatorAddMin=true;
			}else{
				operatorAddMin=false;
			}
			item=item.trim();

			if(lastToken){
				break;
			}
			st = new StringTokenizer(item, "+" + "-" + "*" + "/" + "(" + ")" + "[" + "]" + " ");
			tokenCounter=st.countTokens();
			if(st.hasMoreTokens()){
				s = st.nextToken();
			}else if(!st.hasMoreTokens()){
				lastToken=true;
			}
			containScalar=false;
			containArray=false;
			skip=false;

			tokenCounter--;
		}
		return value.pop();

	}

	private float recurEvaluate(String s){
		s=s.trim();
		int i=0;
		boolean checkB = false;
		StringTokenizer st = new StringTokenizer(s,"+" + "-" + "*" + "/" + "(" + ")" + "[" + "]" + " ");
		String tokenString = st.nextToken();
		// Array code goes here if needed
		float ans=0;
		if(tokenString.equals(s)){
			ScalarSymbol scalar = new ScalarSymbol(s);
			if(scalars.contains(scalar)){
				int si = scalars.indexOf(scalar);
				return scalars.get(si).value;
				
			}else{
				return Integer.parseInt(s);
			}
		}
		
		Stack<Integer> parenOpen= new Stack<Integer>();
		Stack<Integer> braceOpen = new Stack<Integer>();
		boolean checkP=true; checkB = true;
		for(int u = 0; u < s.length(); u++){
			if(s.charAt(u)=='('){
				checkP=false;
				parenOpen.push(u);
			}
			if(s.charAt(u)==')'){
				parenOpen.pop();
				if(parenOpen.size()==0){
					checkP=true;
				}
			}
			if(s.charAt(u)=='['){
				checkB=false;
				braceOpen.push(u);
			}
			if(s.charAt(u)==']'){
				braceOpen.pop();
				if(braceOpen.size()==0){
					checkB=true;
				}
			}
			if(checkP&&checkB){
				if(s.charAt(u)=='+'){
					return recurEvaluate(s.substring(0,u)) + recurEvaluate(s.substring(u+1));
				}else if(s.charAt(u)=='-'){
					return recurEvaluate(s.substring(0,u)) - recurEvaluate(s.substring(u+1));
				}
			}
		}
		parenOpen= new Stack<Integer>();
		braceOpen = new Stack<Integer>();
		checkP=true; checkB = true;
		for(int u = 0; u < s.length(); u++){
			if(s.charAt(u)=='('){
				checkP=false;
				parenOpen.push(u);
			}
			if(s.charAt(u)==')'){
				parenOpen.pop();
				if(parenOpen.size()==0){
					checkP=true;
				}
			}
			if(s.charAt(u)=='['){
				checkB=false;
				braceOpen.push(u);
			}
			if(s.charAt(u)==']'){
				braceOpen.pop();
				if(braceOpen.size()==0){
					checkB=true;
				}
			}
			if(checkP&&checkB){
				if(s.charAt(u)=='*'){
					return recurEvaluate(s.substring(0,u)) * recurEvaluate(s.substring(u+1));
				}else if(s.charAt(i)=='/'){
					return recurEvaluate(s.substring(0,u)) / recurEvaluate(s.substring(u+1));
				}
			}
		}
		ArraySymbol array = new ArraySymbol(tokenString);
		if(s.charAt(s.length()-1)==']'&&arrays.contains(array)){
			int ai = arrays.indexOf(array);
			array = (arrays.get(ai));
			return array.values[(int) (recurEvaluate(s.substring(s.indexOf('[')+1,s.length()-1)))] ;
		}
		if(s.charAt(0)=='('&&s.charAt(s.length()-1)==')'){
			return recurEvaluate(s.substring(1,s.length()-1));
		}
		return ans;
	}

	/**
	 * Utility method, prints the symbols in the scalars list
	 */
	public void printScalars() {
		for (ScalarSymbol ss: scalars) {
			System.out.println(ss);
		}
	}

	/**
	 * Utility method, prints the symbols in the arrays list
	 */
	public void printArrays() {
		for (ArraySymbol as: arrays) {
			System.out.println(as);
		}
	}

}
