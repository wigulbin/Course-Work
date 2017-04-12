
public class BetterDaytime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// SUNRISE
		// read sunrise hour
		System.out.println("Was sunrise in the AM (enter yes) or PM (enter no): ");
		boolean sunriseIsAM = IO.readBoolean();

		if (sunriseIsAM) {  // same as doing: if (sunriseIsAM == true)
			System.out.println("Enter sunrise hour, 0...11 : ");
		} else{
			System.out.println("Enter sunrise hour, 1...12 :");
		}
		int sunriseHour = IO.readInt();
		if (sunriseIsAM && (sunriseHour < 0 || sunriseHour >11)) {
			System.out.println("Sunrise hour must be betweeen 0 and 11, inclusive");
			System.exit(1);  // stops the program (0) means stop program, not errors. Anything else means something went wrong
		}

		// read sunrise minute
		System.out.println("Enter sunrise minute, 0...59 : ");
		int sunriseMinute = IO.readInt();
		if (sunriseMinute < 0 || sunriseMinute >59) {
			System.out.println("Sunrise minute must be between 0 and 59, inclusive");
			System.exit(1);
		}

		// add 12 hours if AM and hour is <12
		if (!sunriseIsAM && sunriseHour < 12) {  // !sunriseIsAM is same as sunriseIsAM != true
			sunriseHour += 12;
		}

		// SUNSET
		//sunset hour
		System.out.println("Was sunrise in the AM (enter yes) or PM (enter no): ");
		boolean sunsetIsAM = IO.readBoolean();

		if (sunsetIsAM) {  // same as doing: if (sunriseIsAM == true)
			System.out.println("Enter sunset hour, 0...11 : ");
		} else{
			System.out.println("Enter sunset hour, 1...12 :");
		}
		int sunsetHour = IO.readInt();
		if (sunsetIsAM && (sunsetHour < 0 || sunsetHour >11)) {
			System.out.println("Sunset hour must be betweeen 0 and 11, inclusive");
			System.exit(1);  // stops the program (0) means stop program, not errors. Anything else means something went wrong
		}
		//sunset minute
		System.out.println("Enter sunrise minute, 0...59 : ");
		int sunsetMinute = IO.readInt();
		if (sunsetMinute < 0 || sunsetMinute >59) {
			System.out.println("Sunset minute must be between 0 and 59, inclusive");
			System.exit(1);
		}


		if (!sunsetIsAM && sunsetHour < 12) {
			sunsetHour += 12;
		}

		int sunriseMinsAfterMidnight = sunriseHour*60+ sunriseMinute;
		int sunsetMinsAfterMidnight = sunsetHour*60 + sunsetMinute;

		int daylightMins = sunsetMinsAfterMidnight - sunriseMinsAfterMidnight;

		if (daylightMins < 0) {
			System.out.println("Sunset cannot be before sunrise!");
			System.exit(1);
		}
		int daylightHours = daylightMins / 60;  // integer division, gives quatient
		int daylightMinutes = daylightMins % 60; // & is for remainder

		System.out.println("daylight time: " + daylightHours + " hours, " + daylightMinutes + " minutes");
	}

}
