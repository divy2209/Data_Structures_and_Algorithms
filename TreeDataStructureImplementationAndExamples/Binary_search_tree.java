package TreeDataStructureImplementationAndExamples;

import java.util.Scanner;

// https://www.youtube.com/watch?v=5_AZcOOc-kM
// https://www.youtube.com/watch?v=gcULXE7ViZw  deleting a value
public class Binary_search_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data) {
			this.data = data;
			left=right=null;
		}
	}
	TreeNode root;
	public Binary_search_tree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	void insert(int data) {
		//root = insertLoop(root, data);
		root = insertRecursion(root, data);
	}
	/*TreeNode insertLoop(TreeNode root, int data) {
		if(root==null) {
			root = new TreeNode(data);
			return root;
		}
		TreeNode temp = root;
		while(temp!=null) {
			if(temp.data>data) { // temp.data>=data
				if(temp.left==null) {
					temp.left = new TreeNode(data);
					break;
				} else temp = temp.left;
			} else {
				if(temp.right==null) {
					temp.right = new TreeNode(data);
					break;
				} else temp = temp.right;
			}
		}
		return root;
	}*/
	TreeNode insertRecursion(TreeNode root, int data) {
		if(root==null) {
			root = new TreeNode(data);
			return root;
		}
		
		/*if(root.data>=data) root.left = insertRecursion(root.left, data);
		else root.right=insertRecursion(root.right, data);*/
		
		if(root.data>data) root.left = insertRecursion(root.left, data);
		else if(root.data<data) root.right=insertRecursion(root.right, data);
		
		return root;
	}
	boolean search(int data) {
		return searchRecursion(root, data);
	}
	boolean searchRecursion(TreeNode root, int data) {
		if(root==null) return false;
		else if(root.data==data) return true;
		else if(root.data>data) return searchRecursion(root.left, data);
		else return searchRecursion(root.right, data);
	}
	void delete(int data) {
		deleteRecursion(root, data);
	}
	TreeNode deleteRecursion(TreeNode root, int data) {
		if(root==null) return root;
		else if(root.data>data) root.left = deleteRecursion(root.left, data);
		else if(root.data<data) root.right = deleteRecursion(root.right, data);
		else {
			if(root.left==null && root.right==null) {
				root = null;
			} else if(root.left==null) {
				root = root.right;
			} else if(root.right==null) {
				root = root.left;
			} else {
				TreeNode temp = minRecursion(root.right);
				root.data = temp.data;
				root.right = deleteRecursion(root.right, temp.data);
			}
		}
		return root;
	}
	// with loop, the conditions will be super complex, so better to use backtracking
	void inOrder() {
		inOrderRecursion(root);
	}
	void inOrderRecursion(TreeNode root) {
		if(root!=null) {
			inOrderRecursion(root.left);
			System.out.print(root.data + " ");
			inOrderRecursion(root.right);
		}
	}
	void preOrder() {
		preOrderRecursion(root);
	}
	void preOrderRecursion(TreeNode root) {
		if(root!=null) {
			System.out.print(root.data + " ");
			preOrderRecursion(root.left);
			preOrderRecursion(root.right);
		}
	}
	void postOrder() {
		postOrderRecursion(root);
	}
	void postOrderRecursion(TreeNode root) {
		if(root!=null) {
			postOrderRecursion(root.left);
			postOrderRecursion(root.right);
			System.out.print(root.data + " ");
		}
	}
	void max() {
		if(root==null) System.out.println("Empty Tree");
		else System.out.println(maxRecursion(root).data);
	}
	TreeNode maxRecursion(TreeNode root) {
		if(root.right!=null) return maxRecursion(root.right);
		else return root;
	}
	void min() {
		if(root==null) System.out.println("Empty Tree");
		else System.out.println(minRecursion(root).data);
	}
	TreeNode minRecursion(TreeNode root) {
		if(root.left!=null) return minRecursion(root.left);
		else return root;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Binary_search_tree tree = new Binary_search_tree();
		for(int i = 0; i<n; i++) tree.insert(scan.nextInt());
		scan.close();
		tree.inOrder();
		System.out.println();
		//tree.preOrder();
		//System.out.println();
		//tree.postOrder();
		//System.out.println(tree.search(11));
		//tree.max();
		//tree.min();
		tree.delete(17);
		tree.inOrder();
		System.out.println(tree.search(17));
	}
}
