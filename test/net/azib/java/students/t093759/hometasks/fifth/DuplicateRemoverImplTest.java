package net.azib.java.students.t093759.hometasks.fifth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         23.03.11 13:27
 */
public class DuplicateRemoverImplTest {
	@Test
	public void noDuplicatesWereRemovedBecauseThereWerentAny() {
		String[] initialStrings = {"cat", "dog", "etc"};
		String[] expectedStrings = initialStrings;
		String[] stringsWithNoDuplicates = new DuplicateRemoverImpl().removeDuplicateStrings(initialStrings);
		assertThat(stringsWithNoDuplicates, equalTo(expectedStrings));
	}

	@Test
	public void someDuplicatesShouldBeRemoved() {
		String[] initialStrings = {"dog", "dog", "cat"};
		String[] expectedStrings = {"dog", "cat"};
		String[] stringsWithSomeDuplicatesRemoved = new DuplicateRemoverImpl().removeDuplicateStrings(initialStrings);
		assertThat(stringsWithSomeDuplicatesRemoved, is(expectedStrings));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantRemoveDuplicatesFromNull() {
		new DuplicateRemoverImpl().removeDuplicateStrings(null);
	}
}
