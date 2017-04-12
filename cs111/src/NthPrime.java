
public class NthPrime {

	public static void main(String[] args) {

		System.out.println("Enter a value: ");
		int primeNumber = 1;
		int number = IO.readInt();
		if(number <1){
			IO.reportBadInput();
			System.out.println("Please input another number");
		}
		int isPrime = 0;
		while(isPrime<number){
			boolean prime = false;
			primeNumber++;
			for(int count = 2;prime == false; count++){
				if((primeNumber%count == 0) && primeNumber == count){
					prime = true;
					isPrime++;
				}else if((primeNumber%count == 0) && primeNumber != count) {
					prime = true;
				}
			}
		}
		IO.outputIntAnswer(primeNumber);
	}

}