
public class dateFormatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the dat in mm/dd/yyyy format: ");
		String date = IO.readString();
		
		// get the month, date, and year parts out of String variable date
		String month = date.substring(0,2); // this gives the first two characters of date
		String dt = date.substring(3,5); // gives character sequence at indexes 3...4
		String year = date.substring(6); // only takes one parameter. goes until string end
		
		String[] monthNames = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		
		int mon = Integer.parseInt(month);	//convert month string to int
		
		//start creating the output string
		String out = monthNames[mon-1];	//first part of output string is month name
		
		int day = Integer.parseInt(dt);
		out += " " + day + ", " ;
		out+=year;
		System.out.println(out);
		
		
	}

}
