package structures;

import java.util.ArrayList;

/**
 * This class is a repository of sorting methods used by the interval tree.
 * It's a utility class - all methods are static, and the class cannot be instantiated
 * i.e. no objects can be created for this class.
 * 
 * @author runb-cs112
 */
public class Sorter {

	private Sorter() { }

	/**
	 * Sorts a set of intervals in place, according to left or right endpoints.  
	 * At the end of the method, the parameter array list is a sorted list. 
	 * 
	 * @param intervals Array list of intervals to be sorted.
	 * @param lr If 'l', then sort is on left endpoints; if 'r', sort is on right endpoints
	 */
	public static void sortIntervals(ArrayList<Interval> intervals, char lr) {
		int arrLength = intervals.size();
		int arrLocation;
		if(lr == 'l'){
			for(int i = arrLength; i>=0; i--){
				for(int j = 0; j<arrLength-1;j++){
					arrLocation = j+1;
					if(intervals.get(j).leftEndPoint > intervals.get(j+1).leftEndPoint){
						Interval temp = intervals.get(j);
						intervals.set(j, intervals.get(j+1));
						intervals.set(j+1, temp);
					}else if(intervals.get(j).leftEndPoint == intervals.get(j+1).leftEndPoint){
						if(intervals.get(j).rightEndPoint > intervals.get(j+1).rightEndPoint){
							Interval temp = intervals.get(j);
							intervals.set(j, intervals.get(j+1));
							intervals.set(j+1, temp);
						}
					}
				}
			}
		}
		if(lr == 'r'){
			for(int i = arrLength; i>=0; i--){
				for(int j = 0; j<arrLength-1;j++){
					arrLocation = j+1;
					if(intervals.get(j).rightEndPoint > intervals.get(j+1).rightEndPoint){
						Interval temp = intervals.get(j);
						intervals.set(j, intervals.get(j+1));
						intervals.set(j+1, temp);
					}else if(intervals.get(j).rightEndPoint == intervals.get(j+1).rightEndPoint){
						if(intervals.get(j).leftEndPoint > intervals.get(j+1).leftEndPoint){
							Interval temp = intervals.get(j);
							intervals.set(j, intervals.get(j+1));
							intervals.set(j+1, temp);
						}
					}
				}
			}
		}
		// COMPLETE THIS METHOD
	}
	/**
	 * Given a set of intervals (left sorted and right sorted), extracts the left and right end points,
	 * and returns a sorted list of the combined end points without duplicates.
	 * 
	 * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
	 * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
	 * @return Sorted array list of all endpoints without duplicates
	 */
	public static ArrayList<Integer> getSortedEndPoints(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
		ArrayList<Integer> endPoints = new ArrayList<Integer>();
		int i=0, j=0;
		while(i<leftSortedIntervals.size() || j<rightSortedIntervals.size()){
			if(i==leftSortedIntervals.size()){
				if(!endPoints.contains(rightSortedIntervals.get(j).rightEndPoint)){
					endPoints.add(rightSortedIntervals.get(j).rightEndPoint);
				}
				j++;
				continue;
			}
			if(j==rightSortedIntervals.size()){
				if(!endPoints.contains(leftSortedIntervals.get(i).leftEndPoint)){
					endPoints.add(leftSortedIntervals.get(i).leftEndPoint);
				}
				i++;
				continue;
			}
			if(leftSortedIntervals.get(i).leftEndPoint > rightSortedIntervals.get(j).rightEndPoint){
				if(!endPoints.contains(rightSortedIntervals.get(j).rightEndPoint)){
					endPoints.add(rightSortedIntervals.get(j).rightEndPoint);
				}
				j++;
				continue;
			}else if(leftSortedIntervals.get(i).leftEndPoint < rightSortedIntervals.get(j).rightEndPoint){
				if(!endPoints.contains(leftSortedIntervals.get(i).leftEndPoint)){
					endPoints.add(leftSortedIntervals.get(i).leftEndPoint);
				}
				i++;
				continue;
			}else if(leftSortedIntervals.get(i).leftEndPoint == rightSortedIntervals.get(j).rightEndPoint){
				if(!endPoints.contains(rightSortedIntervals.get(j).rightEndPoint)){
					endPoints.add(rightSortedIntervals.get(j).rightEndPoint);
				}
				i++;j++;
				continue;
			}
		}
		return endPoints;
	}
}
