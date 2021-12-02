package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

public class Merge_two_sorted_lists {
	static Scanner scan = new Scanner(System.in);
	static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
		Node<Integer> head = null;
		if(head1.data<head2.data) {
			head = head1;
			head1 = head1.next;
		} else {
			head = head2;
			head2 = head2.next;
		}
		Node<Integer> tempHead = head;
		while(head1!=null && head2!=null) {
			if(head1.data<head2.data) {
				tempHead.next = head1;
				head1 = head1.next;
			} else {
				tempHead.next = head2;
				head2 = head2.next;
			}
			tempHead = tempHead.next;
		}
		
		if(head1!=null) tempHead = head1;
		if(head2!=null) tempHead = head2;
		
		return head;
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
		ListNode<Integer> list1 = input();
		ListNode<Integer> list2 = input();
		scan.close();
		Node<Integer> head = merge(list1.head, list2.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
