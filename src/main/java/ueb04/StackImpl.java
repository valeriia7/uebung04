package ueb04;

import java.util.Iterator;
import java.util.NoSuchElementException;

class StackImpl<T> implements Stack<T> {
	/**
	 * Gibt einen Reverse-Iterator zurück, d.h. ein Iterator, welcher die Elemente
	 * in umgekehrter Reihenfolge zurück gibt. Also als erstes das letzte (also "unterste"),
	 * Element, dann das zweit-unterste etc.
	 */
	@Override
	public Iterator<T> iterator() {
		// Iterator implementieren...
		throw new UnsupportedOperationException();
	}

	private class Element {
		T value;
		Element next;
		Element(T value, Element next) {
			this.value = value;
			this.next = next;
		}
	}

	private Element top;
	private int s = 0;

	@Override
	public void push(T c) {
		top = new Element(c, top);
		s++;
	}

	@Override
	public T pop() {
		if (top == null)
			throw new NoSuchElementException();
		T v = top.value;
		top = top.next;
		s--;
		return v;
	}

	@Override
	public int size() {
		return s;
	}
}
