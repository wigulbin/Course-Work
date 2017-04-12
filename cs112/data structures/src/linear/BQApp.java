package linear;

public class BQApp {

	public static void main(String[] args) 
	throws QueueFullException{
		BoundedQueue<Integer> bq = new BoundedQueue<Integer>(2);
		bq.enqueue(5);
		bq.enqueue(6);
		bq.enqueue(7);
		
	}

}
