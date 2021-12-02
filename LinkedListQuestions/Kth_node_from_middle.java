package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

public class Kth_node_from_middle {
	static Scanner scan = new Scanner(System.in);
	static int kthNodeFromMiddle(Node<Integer> head, int k) {
		Node<Integer> slow = head, fast = head;
		int count = 1;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			count++;
		}
		if(fast.next!=null) count++;
		if(k>count || (count==1 && k==1)) return -1;
		count = count-k-1;
		while(count>0) {
			head = head.next;
			count--;
		}
		return head.data;
	}
	static ListNode<Integer> input(){
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
		return list;
	}
	public static void main(String[] args) {
		ListNode<Integer> list = input();
		int k = scan.nextInt();
		scan.close();
		System.out.println(kthNodeFromMiddle(list.head, k));
	}
}
