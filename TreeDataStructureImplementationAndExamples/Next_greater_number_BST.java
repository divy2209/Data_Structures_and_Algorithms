package TreeDataStructureImplementationAndExamples;

import java.util.Scanner;

// https://www.youtube.com/watch?v=5cPbNCrdotA
public class Next_greater_number_BST {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	static Scanner scan = new Scanner(System.in);
	static TreeNode getSuccessor(TreeNode root, int k) {
		TreeNode temp = search(root, k);
		if(temp.right!=null) return min(temp.right);
		else {
			TreeNode successor = null;
			TreeNode ancestor = root;
			while(ancestor!=temp) {
				if(ancestor.data>k) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else ancestor = ancestor.right;
			}
			return successor;
		}
	}
	static TreeNode min(TreeNode root) {
		if(root==null) return null;
		while(root.left!=null) root = root.left;
		return root;
		
		/*while(root!=null) {
			if(root.left!=null) return root;
			else root = root.left;
		}
		return null;*/
	}
	static TreeNode search(TreeNode root, int data) {
		while(root!=null) {
			if(root.data==data) return root;
			else if(root.data>data) root = root.left;
			else root = root.right;
		}
		return null;
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
		root = getSuccessor(root, k);
		System.out.println(root!=null ? root.data : null);
	}
	
}
