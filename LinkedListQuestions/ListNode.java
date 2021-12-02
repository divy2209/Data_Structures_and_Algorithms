package LinkedListQuestions;

// https://www.geeksforgeeks.org/how-to-implement-generic-linkedlist-in-java/
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
