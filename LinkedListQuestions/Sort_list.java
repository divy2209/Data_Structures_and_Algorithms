package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;
// https://www.youtube.com/watch?v=KEoYzfOUF3o
public class Sort_list {
	static Node<Integer> sort(Node<Integer> head){
		if(head==null || head.next==null) return head;
		Node<Integer> slow = head, fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		return merge(sort(head),sort(fast));
	}
	static Node<Integer> merge(Node<Integer> n1, Node<Integer> n2){
		if(n1==null) return n2;
		if(n2==null) return n1;
		Node<Integer> head = null;
		if(n1.data<n2.data) {
			head = n1;
			n1 = n1.next;
		} else {
			head = n2;
			n2 = n2.next;
		}
		Node<Integer> temp = head;
		while(n1!=null && n2!=null) {
			if(n1.data<n2.data) {
				temp.next = n1;
				n1 = n1.next;
			} else {
				temp.next = n2;
				n2 = n2.next;
			}
			temp = temp.next;
		}
		if(n1!=null) temp.next = n1;
		if(n2!=null) temp.next = n2;
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
		Node<Integer> head = sort(list.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
