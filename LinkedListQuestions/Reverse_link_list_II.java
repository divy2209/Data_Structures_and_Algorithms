package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=ZS9jlUW5DoY
public class Reverse_link_list_II {
	static Scanner scan = new Scanner(System.in);
	static Node<Integer> reverseListBetween(Node<Integer> head, int m, int n){
		Node<Integer> result = new Node<Integer>(0);
		result.next = head;
		Node<Integer> curr = result, next = null, prev = null, tail = null, ptail = null;
		int count = 0;
		while(curr!=null) {
			if(count==m-1) {
				tail = curr;
				ptail = curr.next;
				curr = curr.next;
				count++;
				while(count<=n) {
					next = curr.next;
					curr.next = prev;
					prev = curr;
					curr = next;
					count++;
				}
				tail.next = prev;
				ptail.next = curr;
				break;
			} /*else if(m==1) {
				ptail = curr;
				while(count<=n) {
					next = curr.next;
					curr.next = prev;
					prev = curr;
					curr = next;
					count++;
				}
				ptail.next = curr;
				head = prev;
				break;
			}*/
			count++;
			curr = curr.next;	
		}
		return result.next;
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
		int m = scan.nextInt();
		int n = scan.nextInt();
		scan.close();
		Node<Integer> head = reverseListBetween(list.head, m, n);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
