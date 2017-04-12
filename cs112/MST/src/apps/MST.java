package apps;

import structures.*;
import structures.Vertex.Neighbor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import apps.PartialTree.Arc;

public class MST {
	/**
	 * Initializes the algorithm by building single-vertex partial trees
	 * 
	 * @param graph Graph for which the MST is to be found
	 * @return The initial partial tree list
	 */
	public static PartialTreeList initialize(Graph graph) {
		PartialTreeList l = new PartialTreeList();
		Vertex[] temp = graph.vertices;
		PartialTree t = new PartialTree(temp[0]);
		for(int i = 0; i < temp.length; i++){
			t = new PartialTree(temp[i]);
			MinHeap<Arc> p = t.getArcs();
			Neighbor n = temp[i].neighbors;
			while(n!=null){
				Vertex v = n.vertex;
				Arc x = new Arc(temp[i],v,n.weight);
				t.getArcs().insert(x);
				n=n.next;
			}
			l.append(t);
		}
		/* COMPLETE THIS METHOD */

		return l;
	}

	/**
	 * Executes the algorithm on a graph, starting with the initial partial tree list
	 * 
	 * @param graph Graph for which MST is to be found
	 * @param ptlist Initial partial tree list
	 * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
	 */
	public static ArrayList<PartialTree.Arc> execute(Graph graph, PartialTreeList ptlist) {
		ptlist = initialize(graph);
		ArrayList<PartialTree.Arc> result = new ArrayList<PartialTree.Arc>(); 
		PartialTree tempPTree = null;
		Arc arc = null;
		Arc tempArc = arc;
		PartialTree tempPTree2 = null;
		PartialTree PTree = tempPTree;
		Boolean s4 = false;
		while(ptlist.size()>1||s4){
			if(!s4){
				tempPTree = ptlist.remove();
				PTree = tempPTree;
			}else{
				s4=false;
			}
			arc = tempPTree.getArcs().deleteMin();
			tempArc = arc;
			Vertex v1 = tempArc.v1;
			Vertex v2 = tempArc.v2;
			Iterator<Arc> a1 = tempPTree.getArcs().iterator();
			Arc a2 = a1.next();
			do{
				if(a2.v1.equals(v2)||a2.v2.equals(v2)){
					s4 = true;
					break;
				}
				if(a1.hasNext()){
					a2=a1.next();
					continue;
				}else if (!a1.hasNext()){
					break;
				}
			}while(a1!=null);
			if(s4){
				continue;
			}
			result.add(arc);
			tempPTree2 = ptlist.removeTreeContaining(v2);
			tempPTree.getRoot(); 
			tempPTree.merge(tempPTree2);
			ptlist.append(tempPTree);
		}
		return result;
	}
}
