package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=rNhFZSwYuWE
public class Insertion_sort_list {
	static Node<Integer> insertionSort(Node<Integer> node){
		if(node.next==null) return node;
		Node<Integer> sorted = null;
		while(node!=null) {
			Node<Integer> temp = node;
			node = node.next;
			if(sorted==null || sorted.data>temp.data) {
				temp.next = sorted;
				sorted = temp;
			} else {
				Node<Integer> t = sorted;
				while(t!=null) {
					if(t.next==null || t.next.data>temp.data) {
						temp.next = t.next;
						t.next = temp;
						break;
					}
					t = t.next;
				}
			}
		}
		return sorted;
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
		Node<Integer> head = insertionSort(list.head);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
