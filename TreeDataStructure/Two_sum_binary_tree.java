package TreeDataStructure;

import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=nNwTWOhrffo
public class Two_sum_binary_tree {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	static Scanner scan = new Scanner(System.in);
	static int twoSumBinaryTree(TreeNode root, int k) {
		Stack<TreeNode> left = new Stack<>();
		Stack<TreeNode> right = new Stack<>();
		TreeNode curr = root;
		while(curr!=null) {
			left.push(curr);
			curr = curr.left;
		}
		curr = root;
		while(curr!=null) {
			right.push(curr);
			curr = curr.right;
		}
		while(!left.isEmpty()&&!right.isEmpty()) {
			TreeNode l = left.peek();
			TreeNode r = right.peek();
			if(l.data+r.data==k&&l!=r) return 1;
			else if(l.data+r.data>k) {
				right.pop();
				r = r.left;
				while(r!=null) {
					right.push(r);
					r = r.right;
				}
			} else {
				left.pop();
				l = l.right;
				while(l!=null) {
					left.push(l);
					l = l.left;
				}
			}
		}
		return 0;
	}
	static TreeNode input() {
		int n = scan.nextInt();
		TreeNode root = new TreeNode(scan.nextInt());
		for(int i = 1; i<n; i++) insert(root, scan.nextInt());
		return root;
	}
	static TreeNode insert(TreeNode root, int data) {
		if(root==null) {
			root = new TreeNode(data);
			return root;
		}
		if(root.data>data) root.left = insert(root.left, data);
		else root.right = insert(root.right, data);
		return root;
	}
	public static void main(String[] args) {
		TreeNode root = input();
		int k = scan.nextInt();
		scan.close();
		System.out.println(twoSumBinaryTree(root, k));
	}
}
