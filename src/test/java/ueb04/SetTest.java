package ueb04;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {
	@Test
	void testStringSet() {
		Set<String> impl = new SetImpl<>();
		String str = "In Ulm und um Ulm und um Ulm herum";

		for (String c : str.split(" ")) {
			impl.add(c);
		}

		System.out.println(impl);

		// sollte sein: In Ulm und um herum
		assertEquals(5, impl.size());

		// Elemente testen
		assertTrue(impl.contains("In"));
		assertTrue(impl.contains("Ulm"));
		assertFalse(impl.contains(""));
		assertFalse(impl.contains("Hans"));

		// Elemente besuchen...
		int count = 0;
		for (String s : impl) {
			// jedes muss drin sein, lol
			assertTrue(impl.contains(s));
			count++;
		}

		// ...und es muessen genau 5 gewesen sein
		assertEquals(5, count);
	}


	@Test
	void testLeafIterator() {
		SetImpl<String> impl = new SetImpl<>();
		String str = "In Ulm und um Ulm und um Ulm herum";

		for (String c : str.split(" ")) {
			impl.add(c);
		}

		System.out.println(impl);

		List<String> li = new LinkedList<>();
		Iterator<String> it = impl.leafIterator();
		while (it.hasNext())
			li.add(it.next());

		assertEquals(1, li.size());
		assertEquals("herum", li.get(0));
	}
}