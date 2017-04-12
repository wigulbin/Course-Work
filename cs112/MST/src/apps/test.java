package apps;
import java.io.*;
import java.util.*;
public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int loopAmount = sc.nextInt();
        int students, threshold, counter=0, temp;
        Boolean printYes=true;
        while(sc.hasNext()){
        	students = sc.nextInt();

        	threshold = sc.nextInt();

            counter=0;
        	for(int i = 0;i < students; i++){
        		temp = sc.nextInt();

        		if(temp>0){
        			counter++;
                    if(counter==threshold){
                        System.out.println("NO");
                        printYes=false;
        		    }
        		}
                
        	}
            if(printYes){
                 System.out.println("YES");
                 printYes=true;
            }
        }
	}

}
