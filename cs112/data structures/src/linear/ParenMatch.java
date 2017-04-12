package linear;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParenMatch {

	public static boolean match(String expr){
		Stack<Character> stk=new Stack<Character>();
		for(int i=0;i<expr.length();i++){
			char ch = expr.charAt(i);
			if(ch=='('||ch=='['){
				stk.push(ch);    // auto boxing- ch boxed to Character
				continue;
			}
			if(ch==')'||ch==']'){
				try{
					char ch2 = stk.pop();	//auto unboxing
					if((ch==')'&&ch2=='(')||(ch==']'&&ch2!='[')){
						return false;
					}
				}  catch (NoSuchElementException e){
					return false;
				}
			}
		}
		return stk.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter expression, 'quit' to stop: ");
		String expr=sc.nextLine();
		while(!"quit".equals(expr)){
			boolean result = match(expr);
			if(result){
				System.out.println("Expression is correctly formatted");
			}else{
				System.out.println("Expression is not correctly formatted");
			}
			System.out.print("Enter expression, 'quit' to stop: ");
			expr= sc.nextLine();
		}
	}

}
