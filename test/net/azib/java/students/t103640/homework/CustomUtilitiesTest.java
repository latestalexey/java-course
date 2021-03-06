package net.azib.java.students.t103640.homework;

import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.assertEquals;

public class CustomUtilitiesTest {
	/**
	 * This test contains tests of various methods that are defined in CustomUtilities class.
	 * If any of those would fail, then the probability of whole program malfunctioning is very high.
	 */
	    CustomUtilities cu = new CustomUtilities();
	@Test

	public void setStringToDoubleInSecondsTest() throws Exception {
		  assertEquals(83.0, cu.setStringToDoubleInSeconds("1:23"));
		  assertEquals(59.0, cu.setStringToDoubleInSeconds("59"));
	}

	@Test
	public void checkISOCountryTest() throws Exception {
		assertEquals("EE", cu.checkISOCountry("EE"));
		}

	@Test

	public void absolutePathTest(){
		String path = "AbrakaDabra.exe";
		File file = new File(path);

		assertEquals(file.getAbsolutePath(), cu.getAbsolutePath(path));
	}


}
