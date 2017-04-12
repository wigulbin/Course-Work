package structures;

import java.util.*;

/**
 * Encapsulates an interval tree.
 * 
 * @author runb-cs112
 */
public class IntervalTree {

	/**
	 * The root of the interval tree
	 */
	IntervalTreeNode root;

	/**
	 * Constructs entire interval tree from set of input intervals. Constructing the tree
	 * means building the interval tree structure and mapping the intervals to the nodes.
	 * 
	 * @param intervals Array list of intervals for which the tree is constructed
	 */
	public IntervalTree(ArrayList<Interval> intervals) {

		// make a copy of intervals to use for right sorting
		ArrayList<Interval> intervalsRight = new ArrayList<Interval>(intervals.size());
		for (Interval iv : intervals) {
			intervalsRight.add(iv);
		}

		// rename input intervals for left sorting
		ArrayList<Interval> intervalsLeft = intervals;

		// sort intervals on left and right end points
		Sorter.sortIntervals(intervalsLeft, 'l');
		Sorter.sortIntervals(intervalsRight,'r');

		// get sorted list of end points without duplicates
		ArrayList<Integer> sortedEndPoints = Sorter.getSortedEndPoints(intervalsLeft, intervalsRight);

		// build the tree nodes
		root = buildTreeNodes(sortedEndPoints);

		// map intervals to the tree nodes
		mapIntervalsToTree(intervalsLeft, intervalsRight);
	}

	/**
	 * Builds the interval tree structure given a sorted array list of end points.
	 * 
	 * @param endPoints Sorted array list of end points
	 * @return Root of the tree structure
	 */
	public static IntervalTreeNode buildTreeNodes(ArrayList<Integer> endPoints) {
		Queue<IntervalTreeNode> nodeBuilder = new Queue<IntervalTreeNode>();
		int i =0;
		while(i<endPoints.size()){
			IntervalTreeNode temp = new IntervalTreeNode(endPoints.get(i),endPoints.get(i),endPoints.get(i));
			nodeBuilder.enqueue(temp);
			i++;
		}
		IntervalTreeNode temp1;
		IntervalTreeNode temp2;
		int tempSize = nodeBuilder.size();
		while(tempSize>1){
			while(tempSize>1){
				temp1 = nodeBuilder.dequeue();
				IntervalTreeNode temp1a = temp1;
				temp2 = nodeBuilder.dequeue();
				IntervalTreeNode temp2a = temp2;
				float t1Value = temp1.maxSplitValue;
				float t2Value = temp2.minSplitValue;
				while(temp1!=null){
					if(temp1.rightChild==null){
						t1Value = temp1.maxSplitValue;
					}
					temp1=temp1.rightChild;
				}
				while(temp2!=null){
					if(temp2!=null){
						t2Value = temp2.minSplitValue;
					}
					temp2=temp2.leftChild;
				}
				float itemValue = (t1Value+t2Value)/2;
				IntervalTreeNode item = new IntervalTreeNode(itemValue, t1Value, t2Value);
				item.leftChild = temp1a;
				item.rightChild = temp2a;
				nodeBuilder.enqueue(item);
				tempSize = tempSize - 2;
			}
			if(tempSize==1){
				nodeBuilder.enqueue(nodeBuilder.dequeue());
			}
			tempSize = nodeBuilder.size();
		}
		IntervalTreeNode treeRoot = nodeBuilder.dequeue();
		return treeRoot;
	}

	/**
	 * Maps a set of intervals to the nodes of this interval tree. 
	 * 
	 * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
	 * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
	 */
	public void mapIntervalsToTree(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
		int sizeL = leftSortedIntervals.size();
		int sizeR = rightSortedIntervals.size();
		IntervalTreeNode tempRoot = root;

		for(int i = 0; i < sizeL ; i++){
			tempRoot=root;
			Interval temp = leftSortedIntervals.get(i);
			int tempR = temp.rightEndPoint;
			int tempL = temp.leftEndPoint;
			while(tempRoot!=null){
				if(tempR>=tempRoot.splitValue&&tempL<=tempRoot.splitValue){
					if(tempRoot.leftIntervals == null){
						tempRoot.leftIntervals = new ArrayList<Interval>();
					}
					tempRoot.leftIntervals.add(temp);
					break;
				}else if(tempR<tempRoot.splitValue){
					tempRoot = tempRoot.leftChild;
				}else{
					tempRoot = tempRoot.rightChild;
				}
			}
		}
		for(int i = 0; i < sizeR ; i++){
			tempRoot=root;
			Interval temp = rightSortedIntervals.get(i);
			int tempR = temp.rightEndPoint;
			int tempL = temp.leftEndPoint;
			while(tempRoot!=null){
				if(tempR>=tempRoot.splitValue&&tempL<=tempRoot.splitValue){
					if(tempRoot.rightIntervals == null){
						tempRoot.rightIntervals = new ArrayList<Interval>();
					}
					tempRoot.rightIntervals.add(temp);
					break;
				}else if(tempR<tempRoot.splitValue){
					tempRoot = tempRoot.leftChild;
				}else{
					tempRoot = tempRoot.rightChild;
				}
			}
		}
		return;
	}

	/**
	 * Gets all intervals in this interval tree that intersect with a given interval.
	 * 
	 * @param q The query interval for which intersections are to be found
	 * @return Array list of all intersecting intervals; size is 0 if there are no intersections
	 */
	public ArrayList<Interval> findIntersectingIntervals(Interval q) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		findIntersectingIntervalsRec(q, root, result);
		// COMPLETE THIS METHOD
		// THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE PROGRAM COMPILE
		return result;
	}
	private ArrayList<Interval> findIntersectingIntervalsRec(Interval q, IntervalTreeNode root, ArrayList<Interval> result){
		IntervalTreeNode tempRoot = root;
		int i = 0;
		Interval tempL = null;
		if(tempRoot!=null && tempRoot.leftIntervals != null){
			while(i<tempRoot.leftIntervals.size()){
				tempL = tempRoot.leftIntervals.get(i);
				if((q.leftEndPoint >= tempL.leftEndPoint && q.leftEndPoint<=tempL.rightEndPoint) || (q.rightEndPoint <= tempL.rightEndPoint && q.rightEndPoint>=tempL.leftEndPoint)){
					result.add(tempL);
				}
				i++;
			}
		}
		if(tempRoot.leftChild!=null){
			findIntersectingIntervalsRec(q, tempRoot.leftChild, result);
		}
		if(tempRoot.rightChild!=null){
			findIntersectingIntervalsRec(q, tempRoot.rightChild, result);
		}
		return result;
	}

	/**
	 * Returns the root of this interval tree.
	 * 
	 * @return Root of interval tree.
	 */
	public IntervalTreeNode getRoot() {
		return root;
	}
}

