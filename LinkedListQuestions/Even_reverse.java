package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// Separate odd and even, reverse the even, merge again
public class Even_reverse {
	static Node<Integer> evenReverse(Node<Integer> head){
		Node<Integer> temp = head, even = null, odd = head;
		if(temp.next!=null) even = temp.next;
		Node<Integer> teven = even, todd = odd;
		temp = head.next.next;
		// In this, instead of two new head nodes, we can just remove even nodes from the original, which will become odd then
		while(temp!=null) {
			todd.next = temp;
			if(temp.next!=null) teven.next = temp.next;
			else {
				todd = todd.next;
				teven.next = null;
				break;
			}
			todd = todd.next;
			teven = teven.next;
			temp = temp.next.next;
		}
		todd.next = null;
		if(teven!=null) teven.next = null;
		
		Node<Integer> curr = even, prev = null, next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		even = prev;
		Node<Integer> t = null;
		todd = odd;
		while(even!=null) {
			t = odd.next;
			odd.next = even;
			even = even.next;
			//odd = odd.next;
			//odd.next = t;
			//odd = odd.next;
			odd.next.next = t;
			odd = odd.next.next;
		}
		
		return todd;
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
		Node<Integer> head = evenReverse(list.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
