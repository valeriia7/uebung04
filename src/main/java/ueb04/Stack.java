package ueb04;

interface Stack<T> extends Iterable<T> {
	void push(T c);
	T pop();
	int size();
}
