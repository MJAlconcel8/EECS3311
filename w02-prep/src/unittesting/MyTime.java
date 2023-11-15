package unittesting;

/**
 * 
 * @author ilirdema
 * Represents time in 12h format
 */
public class MyTime {
	
	protected static final String AM = "am";
	protected static final String PM = "pm";
	
	protected int hr, min;
	protected String ampm;
	
	public MyTime(int hr, int min, String ampm) {
		this.hr = hr;
		this.min = min;
		this.ampm = ampm;
	}
	
	/**
	 * 
	 * @param mt: MyTime
	 * @return elapsed time within 24 hours
	 */
	protected int minutesElapsed(MyTime mt) {
		int hr1 = this.hr;
		int hr2 = mt.hr;
		int min1 = this.min;
		int min2 = mt.min;
		String ampm1 = this.ampm;
		String ampm2 = mt.ampm;
		if (hr1 == 12)
			hr1 = 0;
		if (hr2 == 12)
			hr2 = 0;
		if (ampm1 == PM)
			hr1 += 12;
		if (ampm2 == PM)
			hr2 += 12;
		if (min2 < min1) {
			min2 = min2 + 1;
		    hr2 = hr2-1;
		}
		if (hr2 < hr1)
			hr2 += 24;
		return min2 - min1 + 60 * (hr2 - hr1);
	}

}
