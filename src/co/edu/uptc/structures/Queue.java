package co.edu.uptc.structures;

public class Queue<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;

	public Queue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		if (rear != null) {
			rear.setNext(newNode);
			newNode.setPrevious(rear);
		}
		rear = newNode;
		if (front == null) {
			front = newNode;
		}
		size++;
	}

	public T poll() {
		if (isEmpity()) {
			return null;
		}
		T data = front.getData();
		front = front.getNext();
		if (front != null) {
			front.setPrevious(null);
		} else {
			rear = null;
		}
		size--;
		return data;
	}

	public T peek() {
		if (isEmpity()) {
			return null;
		}
		return front.getData();
	}

	public boolean isEmpity() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}