package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=ZD8jW0mM8Iw
public class Reorder_list {
	static Node<Integer> reorderList(Node<Integer> head){
		Node<Integer> slow = head, fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node<Integer> node1 = head, node2 = slow.next;
		slow.next = null;
		Node<Integer> curr = node2, next = null, prev = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node2 = prev;
		Node<Integer> temp = null;
		while(node1!=null && node2!=null) {
			temp = node1.next;
			node1.next = node2;
			node1 = node1.next;
			node2 = node2.next;
			node1.next = temp;
			node1 = node1.next;
		}
		return head;
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
		Node<Integer> head = reorderList(list.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
