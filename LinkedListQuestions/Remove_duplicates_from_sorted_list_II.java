package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=FpTFQPHW5r4
public class Remove_duplicates_from_sorted_list_II {
	static Node<Integer> removeDuplicatesII(Node<Integer> head){
		Node<Integer> nhead = new Node<Integer>(0);
		nhead.next = head;
		Node<Integer> t = nhead;
		while(head!=null) {
			while(head.next!=null && head.data==head.next.data) head = head.next;
			// This is elimination method, removing the repetative nodes
			if(t.next==head) t = t.next;
			else t.next = head.next;
			head = head.next;
		}
		return nhead.next;
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
		Node<Integer> head = removeDuplicatesII(list.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
