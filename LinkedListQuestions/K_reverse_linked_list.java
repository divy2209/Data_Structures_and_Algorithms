package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=oyZzgEy5WAQ
public class K_reverse_linked_list {
	static Scanner scan = new Scanner(System.in);
	static Node<Integer> kReverse(Node<Integer> head, int k){
		Node<Integer> currhead = head, tail = head, result = null;
		Node<Integer> curr = head, prev = null, next = null;
		boolean check = true;
		while(curr!=null) {
			int count = 0;
			currhead = curr;
			prev = null;
			while(count<k) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			if(check) {
				result = prev;
				check = false;
			} else {
				tail.next = prev;
				tail = currhead;
			}
		}
		return result;
	}
	
	static Node<Integer> kReverseRecursive(Node<Integer> head, int k){
		Node<Integer> curr = head, next = null, prev = null;
		int count = 0;
		while(count<k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(curr!=null) head.next = kReverseRecursive(curr, k);
		return prev;
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
		Node<Integer> head = kReverseRecursive(list.head, k);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
