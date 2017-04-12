
public class cities {

	// add city to the array cities - cities has n actual city names
	public static void addCity(String[] cities, String city, int n){
		if (n==0){	//no actual city names
			cities[0] = city;
			return;
		}
		//	search and locate the right spot for this new city
		int i=0;
		while(i<n){
			int c = city.compareToIgnoreCase(cities[i]);
			if (c==0) {	// equal. city already exists in the array, return without inserting
				return;
			}
			if (c>0){ // city must go after cities[i], continue searching
				i++;
				continue;
			}
			// city is less than cities[i]. so it must be inserted at the spot i
			// which means we need to move all cities starting at i and going up to (n-1)
			// one space over to the right
			// move back to front
			for(int s=n-1; s>=i;s--){
				cities[s+1]= cities[s];
			}
			cities[i]=city;
			return;
		}
		
		// add city at end of array
		cities[n]= city;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cities = new String[10];
		int n=0; // keeps count of actual number of cities in array

		System.out.print("Enter city name: ");
		String city = IO.readString();
		while(!"quit".equals(city)) {

			addCity(cities, city, n);
			printArray(cities);
			n++;	// increment count
			System.out.print("Enter city name: ");
			city = IO.readString();
		}


	}
	public static void printArray(String[] arr){
		System.out.print("[");
		// print first value separately since it wont have a comma before it
		System.out.print(arr[0]);
		// rest of the stuff
		for(int i=1; i < arr.length; i++){
			System.out.print(","+arr[i]);
		}
		System.out.println("]");
	}
}