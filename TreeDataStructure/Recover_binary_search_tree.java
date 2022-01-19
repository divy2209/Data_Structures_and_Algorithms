package TreeDataStructure;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=LR3K5XAWV5k
// https://www.youtube.com/watch?v=HsSSUSckMns
public class Recover_binary_search_tree {
	class TreeNode {
		int  data;
		TreeNode left, right;
	}
	static TreeNode first, last, prev;
	public Recover_binary_search_tree() {
		// TODO Auto-generated constructor stub
		first = null;
		last = null;
		prev = null;
	}
	static ArrayList<Integer> recoverBST(TreeNode root){
		inOrder(root);
		ArrayList<Integer> arr = new ArrayList<>(2);
		// For the sake of sorted order
		arr.add(last.data);
		arr.add(first.data);
		return arr;
	}
	static void inOrder(TreeNode root) {
		if(root==null) return;
		inOrder(root.left);
		if(prev!=null) {
			if(prev.data>root.data) {
				if(first==null) {
					first = prev;
				}
				last = root;
			}
		}
		prev = root;
		inOrder(root.right);
	}
}
