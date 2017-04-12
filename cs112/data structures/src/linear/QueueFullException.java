package linear;

public class QueueFullException extends Exception {	// extends is inheritance, QueueFullExcpetions gets code from Exception
	
	public QueueFullException(){
		super();	// call superclass (Exception) constructor that does not take arguments
	}
	
	public QueueFullException(String message){
		super(message);	// call superclass (Exception) constructor that does not take arguments
	}
}
