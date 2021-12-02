package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

public class Sort_binary_linked_list {
	static void sort(Node<Integer> head) {
		Node<Integer> zPoint = head;
		while(head!=null) {
			if(head.data==0) {
				swap(head, zPoint);
				zPoint = zPoint.next;
			}
			head = head.next;
		}
	}
	static void swap(Node<Integer> node1, Node<Integer> node2) {
		int temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}
	static ListNode<Integer> input(){
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
	public static void main(String[] args) {
		ListNode<Integer> list = input();
		sort(list.head);
		Node<Integer> node = list.head;
		while(node!=null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
