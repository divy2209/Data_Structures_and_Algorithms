package LinkedListImplementationAndExamples;

import java.util.Scanner;

import LinkedListImplementationAndExamples.ListNode.Node;

// https://www.youtube.com/watch?v=sYcOK51hl-A
public class Reverse_linked_list {
	static ListNode<Integer> input() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ListNode<Integer> list = new ListNode<Integer>();
		if(n>0) {
			list.head = new Node<Integer>(scan.nextInt());
			Node<Integer> last = list.head;
			for(int i = 1; i<n; i++) {
				last.next = new Node<Integer>(scan.nextInt());
				last = last.next;
			}
		}
		scan.close();
		return list;
	}
	static void printList(Node<Integer> list) {
		Node<Integer> curr = list;
		while(curr!=null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	static Node<Integer> reverseList(Node<Integer> head) {
		Node<Integer> curr = head;
		Node<Integer> prev = null;
		Node<Integer> next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	public static void main(String[] args) {
		ListNode<Integer> list = input();
		Node<Integer> l = reverseList(list.head);
		printList(l);
	}
}