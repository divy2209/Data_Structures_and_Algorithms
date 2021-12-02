package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=J0dLiObC_0E
public class Palindrome_list {
	static int isPalindrome(Node<Integer> head) {
		Node<Integer> slow = head, fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node<Integer> next = null;
		Node<Integer> prev = null;
		Node<Integer> curr = slow.next;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		slow.next = null;
		while(head!=null && prev!=null) {
			if(head.data!=prev.data) {
				return 0;
			}
			head = head.next;
			prev = prev.next;
		}
		return 1;
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
		System.out.println(isPalindrome(list.head));
	}
}
