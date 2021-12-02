package LinkedListImplementationAndExamples;

import java.util.Scanner;

import LinkedListImplementationAndExamples.ListNode.Node;

// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class Intersection_of_linked_lists {
	static Scanner scan = new Scanner(System.in);
	static Node<Integer> getIntsectingNode(Node<Integer> head1, Node<Integer> head2) {
		int n1 = totalNodes(head1);
		int n2 = totalNodes(head2);
		int d;
		
		if(n1>n2) {
			d = n1-n2;
			return intersectingNodeData(head1, head2, d);
		} else {
			d = n2-n1;
			return intersectingNodeData(head2, head1, d);
		}
	}
	static Node<Integer> intersectingNodeData(Node<Integer> node1, Node<Integer> node2, int d) {
		Node<Integer> curr1 = node1;
		Node<Integer> curr2 = node2;
		for(int i = 0; i<d; i++) {
			if(curr1==null) return null;
			else {
				curr1 = curr1.next;
			}
		}
		while(curr1!=null && curr2!=null) {
			if(curr1==curr2) {
				return curr2;
			} else {
				curr1=curr1.next;
				curr2=curr2.next;
			}
		}
		return null;
	}
	static int totalNodes(Node<Integer> head) {
		int count = 0;
		Node<Integer> curr = head;
		while(curr!=null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
	static ListNode<Integer> input() {
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
		return list;
	}
	public static void main(String[] args) {
		ListNode<Integer> list1 = input();
		ListNode<Integer> list2 = input();
		int n = scan.nextInt();
		Node<Integer> node1 = list1.head;
		Node<Integer> node2 = list2.head;
		while(list1.head!=null && node1.next!=null) {
			node1 = node1.next;
		}
		while(list2.head!=null && node2.next!=null) {
			node2 = node2.next;
		}
		for(int i = 0; i<n; i++) {
			Node<Integer> temp = new Node<Integer>(scan.nextInt());
			node1.next = temp;
			node2.next = temp;
			node1 = node1.next;
			node2 = node2.next;
		}
		scan.close();
		Node<Integer> t = getIntsectingNode(list1.head, list2.head);
		while(t!=null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
	}
}