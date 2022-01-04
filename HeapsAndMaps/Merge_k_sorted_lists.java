package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.youtube.com/watch?v=k_EtYoQGKmw
public class Merge_k_sorted_lists {
	static Node mergeKSortedLists(ArrayList<Node> arr){
		int n = arr.size();
		PriorityQueue<Heads> q = new PriorityQueue<>(n, new comparatorList());
		for(int i = 0; i<n; i++) q.add(new Heads(arr.get(i), i));
		Node node = new Node(0);
		Node ans = node;
		while(!q.isEmpty()) {
			Heads temp = q.poll();
			node.next = temp.node;
			node = node.next;
			if(temp.node.next!=null) q.add(new Heads(temp.node.next, temp.i));
		}
		return ans.next;
	}
	static ArrayList<Node> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		ArrayList<Node> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) {
			Node node = new Node(0);
			Node temp = node;
			for(int j = 0; j<k; j++) {
				temp.next = new Node(scan.nextInt());
				temp = temp.next;
			}
			arr.add(node.next);
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		Node node = mergeKSortedLists(input());
		while(node!=null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
class Heads {
	Node node;
	int i;
	Heads(Node node, int i){
		this.node = node;
		this.i = i;
	}
}
class comparatorList implements Comparator<Heads> {
	public int compare(Heads head1, Heads head2) {
		if(head1.node.data==head2.node.data) return 0;
		else if(head1.node.data>head2.node.data) return 1;
		else return -1;
	}
}
class Node {
	int data;
	Node next;
	Node(int data){
		this.data = data;
		next = null;
	}
}