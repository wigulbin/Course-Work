
public class Daytime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter sunrise hour, 0...11: "); // assume AM
		int sunriseHour = IO.readInt();
		System.out.println("Enter sunrise minute, 0...59 : ");
		int sunriseMinute = IO.readInt();
		
		System.out.println("Enter sunset hour, 1...12 : "); // assum PM
		int sunsetHour = IO.readInt();
		System.out.println("Enter sunrise minute, 0...59 : ");
		int sunsetMinute = IO.readInt();
		
		int sunriseMinsAfterMidnight = sunriseHour*60+ sunriseMinute;
		if (sunsetHour !=12) {
			sunsetHour +=12;     // same as sunsetHour = sunsetHour +12
		}
		int sunsetMinsAfterMidnight = sunsetHour*60 + sunsetMinute;
		
		int daylightMins = sunsetMinsAfterMidnight - sunriseMinsAfterMidnight;
		int daylightHours = daylightMins / 60;  // integer division, gives quatient
		int daylightMinutes = daylightMins % 60; // & is for remainder
		
		System.out.println("daylight time: " + daylightHours + " hours, " + daylightMinutes + " minutes");
	}

}
