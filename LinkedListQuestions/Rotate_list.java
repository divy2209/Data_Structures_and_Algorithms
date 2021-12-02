package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=_zrtqC-jSFM
// At the end, there is a good concept
public class Rotate_list {
	static Scanner scan = new Scanner(System.in);
	static Node<Integer> rotateByK(Node<Integer> head, int k){
		Node<Integer> temptail = head, temp = head;
		int count = 0;
		while(temptail!=null) {
			count++;
			if(temptail.next==null) break;
			temptail = temptail.next;
		}
		//Node<Integer> result = new Node<Integer>(0);
		k%=count;
		if(k==0) return head;
		count = count-k-1;
		while(count>0) {
			temp = temp.next;
			count--;
		}
		temptail.next = head;
		head = temp.next;
		//result.next = temp.next;
		temp.next = null;
		//return result.next;
		return head;
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
		Node<Integer> head = rotateByK(list.head, k);
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
