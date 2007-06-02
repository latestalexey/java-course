package net.azib.java.students.t960644.homework;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * DecathlonEvent
 * 
 * @author Lembit
 */
public enum DecathlonEvent {
	RACE_100M		(25.437, 	18.0, 	1.81, 	"sec"), 
	LONG_JUMP		(0.14354, 	220, 	1.40, 	"cm"), 
	SHOT_PUT		(51.39, 	1.5, 	1.05, 	"m"), 
	HIGH_JUMP		(0.8465, 	75.0, 	1.42, 	"cm"), 
	RACE_400M		(1.53775, 	82.0, 	1.81, 	"sec"), 
	HURDLES_110M	(5.74352, 	28.5, 	1.92, 	"sec"), 
	DISCUS_THROW	(12.91, 	4.0, 	1.1, 	"m"), 
	POLE_VAULT		(0.2797, 	100.0, 	1.35, 	"cm"), 
	JAVELIN_THROW	(10.14, 	7.0, 	1.08, 	"m"), 
	RACE_1500M		(0.03768, 	480.0, 	1.85, 	"sec");

	private final double a;
	private final double b;
	private final double c;
	private final String units;
	private DecimalFormat RESULT_FORMAT = new DecimalFormat("0.00");
	private SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("m:ss.SSS");
	private SimpleDateFormat SHORT_TIME_FORMAT = new SimpleDateFormat("ss.SSS");


	/**
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param units
	 */
	private DecathlonEvent(double a, double b, double c, String units) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.units = units;
	}
	
	public String units() {return units;}
	/**
	 * Calculates the score for single events. If the performance result is 0 then returns 0.
	 * @param p performance result
	 * @return decatlon score for selected event
	 */
	
	public int eventScore(double p) {
		double result = 0;
		if (p < 0.1) {
			result = 0;
		}
		else {
			if (units=="sec"){
				result = a * Math.pow(b - p, c);				
			}else{
				if(units=="cm"){p*=100;}
				result = a * Math.pow(p- b, c);
			}
		}
		return (int)result;
	}
	/**
	 * 
	 * @param p performance result 
	 * @return formatted result that can be used for various output options
	 */
	public String eventResultFormat(double p) {
		if(units=="sec"){
			if (p<60) {
				return SHORT_TIME_FORMAT.format(p*1000);
			}else{
				return TIME_FORMAT.format(p*1000);
			}
		} else
		{
			return RESULT_FORMAT.format(p);
		}
	}
	public static void main(String[] args) {
		System.out.println(DecathlonEvent.RACE_100M.eventResultFormat(15.2));
		System.out.println(DecathlonEvent.RACE_1500M.eventResultFormat(361.9));
		System.out.println(DecathlonEvent.JAVELIN_THROW.eventResultFormat(62));
		
	}
}
