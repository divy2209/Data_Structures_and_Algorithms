package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

public class Remove_duplicates_from_sorted_list_I {
	static Node<Integer> removeDuplicates(Node<Integer> head){
		Node<Integer> curr = head, temp = head;
		while(curr!=null) {
			while(curr.next!=null && curr.data==curr.next.data) curr = curr.next;
			temp.next = curr.next;
			temp = temp.next;
			curr = curr.next;
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
		Node<Integer> head = removeDuplicates(list.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
