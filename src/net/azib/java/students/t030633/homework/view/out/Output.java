package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;

import java.io.IOException;
import java.util.List;

/**
 * Decathlon output interface - all outputs write a list of athletes.
 * 
 * @author t030633
 */
public interface Output {

	/**
	 * @param athletes -
	 *            List<Athlete>, a list of athletes to output
	 * @throws IOException
	 *             if writing fails
	 */
	void write(List<Athlete> athletes) throws IOException;

	/**
	 * @param param - String parameters for output
	 */
	void setParameters(String... param);
	
}