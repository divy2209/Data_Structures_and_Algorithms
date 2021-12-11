package BacktrackingImplementationAndExamples;

public class ListNode<T> {
	Node<T> head;
	static class Node<T>{
		Node<T> next;
		T data;
		Node(T d){
			data = d;
			next = null;
		}
	}
}
