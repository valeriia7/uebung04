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
		return new Iterator<T>() {
			StackImpl<Element> rev = new StackImpl<>();

			// Konstruktor fuer anonyme innere Klasse
			{
				// Alle Elemente in den Stack legen => dreht die Reihenfolge um!
				Element it = top;
				while (it != null) {
					rev.push(it);
					it = it.next;
				}
			}
			@Override
			public boolean hasNext() {
				return rev.size() > 0;
			}
			@Override
			public T next() {
				// pop liefert uns jetzt FIFO
				return rev.pop().value;
			}
		};
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
