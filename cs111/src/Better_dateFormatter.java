
public class Better_dateFormatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the dat in mm/dd/yyyy format: ");
		String date = IO.readString();
		
		int slashPos = date.indexOf('/');
		String month = date.substring(0,slashPos);
		
		int slashPos2 = date.indexOf('/', slashPos+1); // search starting at previous slash position + 1
		String dt = date.substring(slashPos + 1, slashPos2);
		
		String year = date.substring(slashPos2+1);
		
		
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
