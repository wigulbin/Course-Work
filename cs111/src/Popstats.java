
public class Popstats {

	public static void populateArrays(String[] countries, int[] pops) {
		String line;
		for (int i=0; i < countries.length; i++) {  
			line = IO.readLine();
			// separate on "|"
			int pos = line.indexOf('|');
			countries[i] = line.substring(0,pos);
			String popstr = line.substring(pos+1);
			// take out commas, if any  (replace commas with nothing, i.e. empty string)
			popstr = popstr.replace(",", "");
			pops[i] = Integer.parseInt(popstr);
		}
	}
	
	public static int getPopulation(String[] countries, int[] pops, String country) {
		// scan the countries array for match
		// LINEAR/SEQUENTIAL search
		for (int i=0; i < countries.length; i++) {
			if (country.equalsIgnoreCase(countries[i])) {
				return pops[i];
			}
		}
		return -1;
	}
	
	public static void printMillions(String[] countries, int[] pops) {
		for (int i=0; i < countries.length; i++) {
			if (pops[i] < 1000000) {
				break;
			}
			if (pops[i] < 1000000000) {
				System.out.println(countries[i] + ": " + pops[i]);
			}
		}
	}
	
	
	public static int bottomBillion(int[] pops) {
		long worldpop=0;
		int i=pops.length-1;
		while (i >= 0 && worldpop < 100000000) {
			worldpop += pops[i];
			i--;
		}
		return pops.length-i;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter population file name: ");
		String file = IO.readString();
		
		if (!IO.openFile(file)) {
			System.exit(1);
		}
		
		String line;
		// first line of file is number of countries
		/*
		 * line = IO.readLine();
		 * if (line == null) {
		 * return;
		 * }
		 */
		
		if ((line = IO.readLine()) == null) {
			System.exit(1);
		}
		
		// Integer is a class in Java that has a method to convert a string
		// that represents a number, to the actual numeric value
		// "25" -> 25
		// "2567" -> 2567
		// "25x" -> ERROR  (not an integer)
		// "-25" -> -25
		// "12.6" => ERROR (not an integer)
		// "12,500" => ERROR (not an integer because of the comma)
		int n = Integer.parseInt(line);
		
		// set up one array for countries and another parallel array for population
		String[] countries = new String[n];
		int[] pops = new int[n];
		
		// read everything in
		populateArrays(countries, pops);
		
		// compute total world pop
		System.out.println("Maximum storable integer value = " + Integer.MAX_VALUE);
		
		// define a long int variable to hold world population
		long worldpop=0;
		for (int i=0; i < pops.length; i++) {
			worldpop += pops[i];
		}
		
		System.out.println("World population = " + worldpop);
		
		
		System.out.print("Enter country to find population, \"quit\" to exit: ");
		String country = IO.readString().toLowerCase();
		while (!country.equals("quit")) {
			int pop = getPopulation(countries, pops, country);
			if (pop != -1) {
				System.out.println("Population of " + country + " = " + pop);
			} else {
				System.out.println("Country " + country + " not in list");
			}
			System.out.print("Enter country to find population, \"quit\" to exit: ");
			country = IO.readString().toLowerCase();
		}
		
		
		int num = bottomBillion(pops);
		System.out.println("Bottom billion number = " + num);
		
		printMillions(countries, pops);
	}
}
