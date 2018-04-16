package ueb04;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {
	@Test
	void testStack() {
		int[] a = {1, 4, 5, 2};

		Stack<Integer> cs = new StackImpl<>();

		// zu Beginn muss der Stack leer sein!
		assertEquals(0, cs.size());

		// ...und entsprechend eine NoSuchElementException werfen, wenn man pop ruft!
		assertThrows(NoSuchElementException.class, cs::pop);

		// jetzt ein paar Werte pushen
		for (int i : a)
			cs.push(i);
		assertEquals(a.length, cs.size());

		// reverse-iterator testen
		Iterator<Integer> it = cs.iterator();
		for (int i : a)
			assertEquals((Integer) i, it.next());

		// ...und rückwärts, stimmt pop immernoch?!
		for (int i = a.length-1; i >= 0; i--)
			assertEquals((Integer) a[i], cs.pop());

		// Jetzt muss er wieder leer sein!
		assertEquals(0, cs.size());
	}
}
