package co.edu.uptc.structures;

import java.util.EmptyStackException;

public class Stack<T> {
	private Node<T> top;

	public void push(T item) {
		Node<T> node = new Node<>(item);
		node.setNext(top);
		top = node;
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T item = top.getData();
		top = top.getNext();
		return item;
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getData();
	}

	public boolean isEmpty() {
		return top == null;
	}

	public boolean exist(T item) {
		Node<T> current = top;
		while (current != null) {
			if (current.getData().equals(item)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
}