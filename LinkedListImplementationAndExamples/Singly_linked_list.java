package LinkedListImplementationAndExamples;

import java.util.Scanner;

import LinkedListImplementationAndExamples.SinglyListNode.Node;

// https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
// https://www.youtube.com/watch?v=k9r80o_DeK4&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=17
public class Singly_linked_list {
	static SinglyListNode input() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		SinglyListNode list = new SinglyListNode();
		for(int i = 0; i<n; i++) {
			list = list.insert(list, scan.nextInt());
		}
		scan.close();
		return list;
	}
	static void printList(SinglyListNode list) {
		Node curr = list.head;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	public static void main(String[] args) {
		SinglyListNode list = input();
		SinglyListNode.deleteByKey(list, 2);
		SinglyListNode.deleteByPosition(list, 1);
		System.out.println(list.head.data);
		printList(list);
	}
}

class SinglyListNode {
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public SinglyListNode insert(SinglyListNode list, int data) {
		Node new_node = new Node(data);
		new_node.next = null;
		
		if(list.head==null) {
			list.head = new_node;
		} else {
			Node last = list.head;
			while(last.next!=null) {
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
	}
	
	public static SinglyListNode deleteByKey(SinglyListNode list, int k) {
		Node curr = list.head, prev = null;
		if(curr !=null && curr.data==k) {
			list.head = curr.next;
			return list;
		}
		
		while(curr!=null && curr.data!=k) {
			prev = curr;
			curr = curr.next;
		}
		
		if(curr !=null) {
			prev.next = curr.next;
		}
		
		if(curr==null) {
			System.out.println("Element not found");
		}
		
		return list;
	}
	
	public static SinglyListNode deleteByPosition(SinglyListNode list, int k) {
		Node curr = list.head, prev = null;
		if(k==0 && curr!=null) {
			list.head = curr.next;
			return list;
		}
		
		int counter = 0;
		while(curr!=null) {
			if(k==counter) {
				prev.next = curr.next;
				break;
			} else {
				prev = curr;
				curr = curr.next;
				counter++;
			}
		}
		
		if(curr==null) {
			System.out.println("Element at that position not found");
		}
		return list;
	}
}
