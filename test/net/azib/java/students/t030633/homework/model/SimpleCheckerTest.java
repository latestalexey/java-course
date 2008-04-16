package net.azib.java.students.t030633.homework.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * SimpleCheckerTest
 * 
 * @author t030633
 */
public abstract class SimpleCheckerTest {

	private SimpleChecker checker;

	public SimpleCheckerTest(SimpleChecker checker) {
		this.checker = checker;
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.SimpleChecker#checkCountry(String)}.
	 */
	@Test
	public void nullCountryAvoided() {
		assertNotNull(checker.checkCountry(null));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.SimpleChecker#checkCountry(String)}.
	 */
	@Test
	public void existingCountryAccepted() {
		assertEquals("EE", checker.checkCountry("EE"));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.SimpleChecker#checkCountry(String)}.
	 */
	@Test
	public void notExistingCountryRemoved() {
		assertEquals("", checker.checkCountry("PP"));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.SimpleChecker#checkDate(java.util.Date)}.
	 */
	@Test
	public void nullDateAvoided() {
		assertNotNull(checker.checkDate(null));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.SimpleChecker#checkName(String)}.
	 */
	@Test
	public void testCheckName() {
		assertNotNull(checker.checkName(null));
	}

}