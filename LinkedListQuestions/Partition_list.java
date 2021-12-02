package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=yLL168YObrI
public class Partition_list {
	static Scanner scan = new Scanner(System.in);
	
	static Node<Integer> partition(Node<Integer> head, int x) {
		Node<Integer> curr = head;
		Node<Integer> s = new Node<Integer>(0);
		Node<Integer> g = new Node<Integer>(0);
		Node<Integer> nodes = s, nodeg = g;
		while(curr!=null) {
			if(curr.data<x) {
				nodes.next = curr;
				nodes = nodes.next;
			} else {
				nodeg.next = curr;
				nodeg = nodeg.next;
			}
			curr = curr.next;
		}
		nodes.next = g.next;
		nodeg.next = null;
		return s.next;
	}
	static ListNode<Integer> input(){
		int n = scan.nextInt();
		ListNode<Integer> list = new ListNode<Integer>();
		if(n>0) {
			list.head = new Node<Integer>(scan.nextInt());
			Node<Integer> last = list.head;
			for(int i = 1; i<n; i++) {
				last.next = new Node<Integer>(scan.nextInt());
				last = last.next;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		ListNode<Integer> list = input();
		int x = scan.nextInt();
		scan.close();
		Node<Integer> head = partition(list.head, x);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
