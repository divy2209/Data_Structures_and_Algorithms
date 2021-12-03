package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=Qo1GXMgIjxk
// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
public class List_cycle {
	static Node<Integer> listCycleStart(Node<Integer> head){
		Node<Integer> slow = head, fast = head;
		boolean check = true;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				check = false;
				break;
			}
		}
		if(check) return null;
		fast = head;
		while(fast!=slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	static ListNode<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		ListNode<Integer> list = new ListNode<Integer>();
		if(n>0) {
			list.head = new Node<Integer>(scan.nextInt());
			Node<Integer> node = list.head;
			Node<Integer> loop = null;
			if(m==0) loop = node;
			for(int i = 1; i<n; i++) {
				node.next = new Node<Integer>(scan.nextInt());
				node = node.next;
				if(m==i) loop = node;
			}
			node.next = loop;
		}
		scan.close();
		return list;
	}
	public static void main(String[] args) {
		ListNode<Integer> list = input();
		Node<Integer> node = listCycleStart(list.head);
		if(node!=null) System.out.println(node.data);
		else System.out.println(node);
	}
}
