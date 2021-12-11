package BacktrackingImplementationAndExamples;

import java.util.Scanner;

import BacktrackingImplementationAndExamples.ListNode.Node;

// https://www.geeksforgeeks.org/recursively-reversing-a-linked-list-a-simple-implementation/
// https://www.youtube.com/watch?v=MRe3UsRadKw
public class Reverse_link_list_recursion {
	static Node<Integer> reverse(Node<Integer> head){
		//if(head==null) return head;
		if(head.next==null) return head;
		Node<Integer> newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	static ListNode<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ListNode<Integer> list = new ListNode<Integer>();
		if(n>0) {
			list.head = new Node<Integer>(scan.nextInt());
			Node<Integer> node = list.head;
			for(int i = 1; i<n; i++) {
				node.next = new Node<Integer>(scan.nextInt());
				node = node.next;
			}
		}
		scan.close();
		return list;
	}
	public static void main(String[] args) {
		ListNode<Integer> list = input();
		Node<Integer> head = reverse(list.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
