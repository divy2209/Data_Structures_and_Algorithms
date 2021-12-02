package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

public class Remove_nth_node_from_list_end {
	static Scanner scan = new Scanner(System.in);
	static Node<Integer> removeNthFromLast(Node<Integer> head, int n){
		Node<Integer> temp = head;
		int count = 0;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		if(n>=count) return head.next;
		count = count-n-1;
		temp = head;
		while(count>0) {
			temp = temp.next;
			count--;
		}
		temp.next = temp.next.next;
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
		ListNode<Integer> list = input();
		int n = scan.nextInt();
		scan.close();
		Node<Integer> head = removeNthFromLast(list.head, n);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
