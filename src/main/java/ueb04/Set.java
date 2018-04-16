package ueb04;

interface Set<T extends Comparable<T>> extends Iterable<T> {
	/**
	 * Fügt das übergebene Element in das Set ein.
	 * @param s
	 * @return true, wenn `s` neu eingefügt wurde, false wenn es bereits enthalten war
	 */
	boolean add(T s);

	/**
	 * Prüft, ob ein Element im Set enthalten ist.
	 */
	boolean contains(T s);

	/**
	 * Gibt die Größe des Sets zurück
	 */
	int size();
}
