package TreeDataStructure;

import java.util.Scanner;

// https://www.youtube.com/watch?v=5R9_qgIV98s
// Java is pass-by-value not pass-by-reference
// for pass-by-reference use global variable
// https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
public class Kth_smallest_element_in_tree {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	static int result;
	static int n;
	static Scanner scan = new Scanner(System.in);
	static int kthSmallestElementInOrder(TreeNode root, int k) {
		n = k;
		inOrder(root);
		return result;
	}
	static void inOrder(TreeNode root) {
		if(root!=null) {
			inOrder(root.left);
			n--;
			if(n==0) {
				result = root.data;
				return;
			}
			inOrder(root.right);
		}
	}
	static int kthSmallestElement(TreeNode root, int k) {
		int l = 0;
		if(root!=null) l = count(root.left);
		if(l+1==k) return root.data;
		else if(l+1>k) return kthSmallestElement(root.left, k);
		else return kthSmallestElement(root.right, k-l-1);
	}
	static int count(TreeNode root) {
		if(root==null) return 0;
		return 1+count(root.left)+count(root.right);
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
		System.out.println(kthSmallestElement(root, k));
		System.out.println(kthSmallestElementInOrder(root, k));
	}
}
