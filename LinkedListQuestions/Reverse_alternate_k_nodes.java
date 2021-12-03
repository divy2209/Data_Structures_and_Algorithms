package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

public class Reverse_alternate_k_nodes {
	static Scanner scan = new Scanner(System.in);
	static Node<Integer> reverseAlternateKNodes(Node<Integer> head, int k){
		if(k==1) return head;
		Node<Integer> result = new Node<Integer>(0);
		result.next = head;
		Node<Integer> ptail = result, temph = null, t = result;
		int count = 0;
		while(t!=null) {
			if(count==1) {
				temph = t;
			}
			if(count==k) {
				Node<Integer> h = null;
				if(t.next!=null) {
					h = t.next;
					t.next = null;
				}
				t = h;
				h = reverse(temph);
				ptail.next = h;
				temph.next = t;
				count++;
				while(t!=null&&count<2*k) {
					t = t.next;
					count++;
				}
				ptail = t;
				count = 0;
			}
			if(t==null) break;
			t = t.next;
			count++;
		}
		if(ptail==result) return reverse(head);
		return result.next;
	}
	static Node<Integer> reverse(Node<Integer> curr){
		Node<Integer> next = null, prev = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
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
		Node<Integer> head = reverseAlternateKNodes(list.head, k);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
