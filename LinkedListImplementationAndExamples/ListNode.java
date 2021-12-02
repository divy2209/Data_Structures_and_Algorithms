package LinkedListImplementationAndExamples;

public class ListNode<T> {
	Node<T> head;
	static class Node<T> {
		T data;
		Node<T> next;
		Node(T d) {
			data = d;
			next = null;
		}
	}
}
