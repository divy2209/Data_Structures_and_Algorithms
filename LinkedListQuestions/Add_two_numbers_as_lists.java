package LinkedListQuestions;

import java.util.Scanner;

import LinkedListQuestions.ListNode.Node;

// https://www.youtube.com/watch?v=fThpzrA0vGc
public class Add_two_numbers_as_lists {
	static Scanner scan = new Scanner(System.in);
	static Node<Integer> addNumbers(Node<Integer> head1, Node<Integer> head2){
		int carry = 0;
		//int num1 = 0, num2 = 0;
		Node<Integer> result = new Node<Integer>(0);
		Node<Integer> temp = result;
		while(head1!=null || head2!=null || carry != 0) {
			int sum = 0;
			if(head1!=null) {
				sum += head1.data;
				//num1 = head1.data;
				head1 = head1.next;
			}
			//else num1 = 0;
			
			if(head2!=null) {
				sum += head2.data;
				//num2 = head2.data;
				head2 = head2.next;
			}
			//else num2 = 0;
			
			//int sum = num1+num2+carry;
			sum += carry;
			carry = sum/10;
			result.next = new Node<Integer>(sum%10);
			result = result.next;
		}
		temp = reverseList(temp.next);
		while(temp!=null && temp.data==0) temp = temp.next;
		temp = reverseList(temp);
		return temp;
	}
	static Node<Integer> reverseList(Node<Integer> head){
		Node<Integer> curr = head, next = null, prev = null;
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
		ListNode<Integer> list1 = input();
		ListNode<Integer> list2 = input();
		scan.close();
		Node<Integer> head = addNumbers(list1.head, list2.head);
		String ans = "";
		while(head!=null) {
			ans = head.data.toString() + ans;
			head = head.next;
		}
		System.out.println(ans);
	}
}
