package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=QzsHZoGbczQ
public class Swap_list_nodes_in_pairs {
	static Node<Integer> swapNodesInPair(Node<Integer> head){
		Node<Integer> currhead = head, tail = head, result = null;
		Node<Integer> curr = head, next = null, prev = null;
		boolean check = true;
		while(curr!=null) {
			currhead = curr;
			prev = null;
			int count = 0;
			while(count<2 && curr!=null) {
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
	
	static Node<Integer> swapNodesInPairRecursive(Node<Integer> head){
		Node<Integer> curr = head, next = null, prev = null;
		int count = 0;
		while(count<2 && curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(curr!=null) head.next = swapNodesInPairRecursive(curr);
		return prev;
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
		Node<Integer> head = swapNodesInPairRecursive(list.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
